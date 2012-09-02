package com.bullx.client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.bullx.config.ConfigFactory;
import com.bullx.config.Configuration;
import com.bullx.heartbeat.HeartBeat;

public class ClientCall {

    public static Configuration config = ConfigFactory.getConfig();

    public static void main(String[] args) throws Exception {
        String u = config.getCAGUrl() + "CAG?wsdl";
        String path_uri = "http://a.b.c/"; // http://server.bullx.com/
        String service_name = ""; //HelloService

        URL url = new URL(u);
        QName qname = new QName(path_uri, service_name);
        Service service = Service.create(url, qname);

        CAGClient c = service.getPort(CAGClient.class);

        HeartBeat heartBeatXml = new HeartBeat();
        heartBeatXml.response = c.uploadCACHeartbeatInfo(heartBeatXml.getRequest().asXML());
        heartBeatXml.handleResponse();
    }

}
