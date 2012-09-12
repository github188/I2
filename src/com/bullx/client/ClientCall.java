package com.bullx.client;

import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.bullx.config.ConfigFactory;
import com.bullx.config.Configuration;
import com.bullx.heartbeat.HeartBeat;
import com.bullx.utils.Log;

public class ClientCall {

    public static Configuration config = ConfigFactory.getConfig();

    public static String u = "http://10.138.19.72:7001/TRANSFCAG/services/CAGAccessService?wsdl";
    public static final String path_uri = "http://info.nari-china.com/CAG";
    public static String service_name = "CAGAccessService";

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
        exec.execute(new HeartBeatWorker(c));
    }

}

class HeartBeatWorker implements Runnable {

    private final HeartBeat heartBeatXml = new HeartBeat();
    private final CAGClient c;

    public HeartBeatWorker(CAGClient c) {
        this.c = c;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                String request = heartBeatXml.getRequest().asXML();
                heartBeatXml.response = c.uploadHeartbeatInfo(request);
                heartBeatXml.handleResponse();
                TimeUnit.SECONDS.sleep(5);
            }
        } catch (InterruptedException e) {
            Log.error(e.getMessage());
        }
    }
}
