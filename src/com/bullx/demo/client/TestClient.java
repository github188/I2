package com.bullx.demo.client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class TestClient {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:81/hello?wsdl");

        // 第一个参数是服务的URI  
        // 第二个参数是在WSDL发布的服务名  
        QName qname = new QName("http://server.demo.bullx.com/", "HelloService");

        // 创建服务  
        Service service = Service.create(url, qname);

        // 提取端点接口，服务“端口”。  
        HelloClient h = service.getPort(HelloClient.class);

        System.out.println(h.sayHello("liubida"));
        System.out.println(h.sayHelloToOne("tom"));
        System.out.println(h.sayHelloToTwo("tom","merry"));
    }
}
