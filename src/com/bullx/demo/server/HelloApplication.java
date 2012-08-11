package com.bullx.demo.server;

import javax.xml.ws.Endpoint;

import com.bullx.config.ConfigFactory;
import com.bullx.config.Configuration;

public class HelloApplication {
    static Configuration config        = ConfigFactory.getInstance();
    static String        WebServiceUrl = config.getWebServiceUrl();

    public static void main(String[] args) {
        Endpoint.publish(WebServiceUrl + "hello", new Hello());
    }
}
