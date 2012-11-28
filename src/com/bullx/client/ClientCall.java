package com.bullx.client;

import java.net.URL;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.bullx.cacdata.CACData;
import com.bullx.config.ConfigFactory;
import com.bullx.config.Configuration;
import com.bullx.heartbeat.Command;
import com.bullx.heartbeat.HeartBeat;

public class ClientCall {

    public static Configuration config = ConfigFactory.getConfig();

    public static String u = "http://10.138.19.72:7001/TRANSFCAG/services/CAGAccessService?wsdl";
    public static final String path_uri = "http://info.nari-china.com/CAG";
    public static String service_name = "CAGAccessService";

    public static int TIMEOUT = 300;

    private static boolean bStop = true;

    //    public String call() {
    public static void main(String[] args) {
        //        String u = config.getCAGUrl() + "CAG?wsdl";
        //        String path_uri = Constant.CAG_TARGET;
        //        String service_name = "CAGPortTypeService";

        // just for test
        String u = "http://127.0.0.1:9000/" + "CAGAccessService?wsdl";
        String path_uri = "http://cag.bullx.com/";
        String service_name = "CAGPortTypeService";

        URL url = null;
        QName qname = null;
        Service service = null;
        CAGClient c = null;
        ExecutorService exec = null;
        try {
            bStop = false;
            url = new URL(u);
            qname = new QName(path_uri, service_name);
            service = Service.create(url, qname);
            c = service.getPort(CAGClient.class);
            exec = Executors.newCachedThreadPool();
            while (!Thread.interrupted() && !bStop) {
                Future<List<Command>> hearBeatFuture = exec.submit(new HeartBeatWorker(c));
                List<Command> commands = hearBeatFuture.get(TIMEOUT, TimeUnit.SECONDS);

                if (null != commands && !commands.isEmpty()) {
                    for (Command command : commands) {
                        switch (command.getCommandType()) {
                            case GETNEWDATA: {
                                Future<Boolean> cacDataFuture = exec.submit(new CACDataWorker(c));
                                Boolean result = cacDataFuture.get(TIMEOUT, TimeUnit.SECONDS);
                                if (result) {
                                    System.out.println("uploadCACData success");
                                }
                                // TODO if result error
                                break;
                            }
                            default:
                        }
                    }
                }
                TimeUnit.SECONDS.sleep(5);
            }
            bStop = true;
            //            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //            return e.getMessage();
        } finally {
            exec = null;
            bStop = true;
        }
    }

    public boolean getStatus() {
        return !bStop;
    }

    public boolean cancel() {
        return bStop = true;
    }
}

class HeartBeatWorker implements Callable<List<Command>> {

    private final HeartBeat heartBeatXml = new HeartBeat();
    private final CAGClient c;

    public HeartBeatWorker(CAGClient c) {
        this.c = c;
    }

    @Override
    public List<Command> call() {
        String request = heartBeatXml.getRequest().asXML();
        heartBeatXml.response = c.uploadHeartbeatInfo(request);
        return heartBeatXml.handleResponse();
    }
}

class CACDataWorker implements Callable<Boolean> {
    private final CACData cacDataXml = new CACData();
    private final CAGClient c;

    public CACDataWorker(CAGClient c) {
        this.c = c;
    }

    public Boolean call() {
        String request = cacDataXml.getRequest().asXML();
        cacDataXml.response = c.uploadCACData(request);
        // TODO parse response to get the real result
        return true;
    }
}
