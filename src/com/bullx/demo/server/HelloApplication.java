package com.bullx.demo.server;

import javax.xml.ws.Endpoint;

public class HelloApplication {
    public static void main(String[] args) {
        // ����һ��WebService
        Endpoint.publish("http://localhost:81/hello", new Hello());
    }
}
