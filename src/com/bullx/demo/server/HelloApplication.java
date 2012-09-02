package com.bullx.demo.server;

import javax.xml.ws.Endpoint;

import com.bullx.config.ConfigFactory;
import com.bullx.config.Configuration;
import com.bullx.utils.Log;

public class HelloApplication {
    static Configuration config = ConfigFactory.getConfig();
    static String        CACUrl = config.getCACUrl();

    public static void main(String[] args) {
        Log.info("Service start...");
        Endpoint.publish(CACUrl + "hello", new Hello());
    }
}
