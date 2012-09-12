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

    public static void main(String[] args) throws Exception {
        //        String u = config.getCAGUrl() + "CAG?wsdl";
        //        String path_uri = Constant.CAG_TARGET;
        //        String service_name = "CAGPortTypeService";

        // just for test
        //        u = "http://127.0.0.1:9000/" + "CAGAccessService?wsdl";
        //        path_uri = "http://cag.bullx.com/";
        //        service_name = "CAGPortTypeService";

        URL url = new URL(u);
        QName qname = new QName(path_uri, service_name);
        Service service = Service.create(url, qname);

        CAGClient c = service.getPort(CAGClient.class);

        ExecutorService exec = Executors.newCachedThreadPool();
        while (true) {
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
