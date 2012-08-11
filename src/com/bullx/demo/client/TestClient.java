package com.bullx.demo.client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class TestClient {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:81/hello?wsdl");

        QName qname = new QName("http://server.demo.bullx.com/", "HelloService");

        Service service = Service.create(url, qname);

        HelloClient h = service.getPort(HelloClient.class);

        System.out.println(h.sayHello("liubida"));
        System.out.println(h.sayHelloToOne("tom"));
        System.out.println(h.sayHelloToTwo("tom","merry"));
    }
}
