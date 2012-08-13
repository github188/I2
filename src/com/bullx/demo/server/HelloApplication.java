package com.bullx.demo.server;

import javax.xml.ws.Endpoint;

import com.bullx.config.ConfigFactory;
import com.bullx.config.Configuration;
import com.bullx.constants.Log;

public class HelloApplication {
    static Configuration config        = ConfigFactory.getConfig();
    static String        WebServiceUrl = config.getWebServiceUrl();

    public static void main(String[] args) {
        Log.info("Service start...");
        Endpoint.publish(WebServiceUrl + "hello", new Hello());
    }
}
