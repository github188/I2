/**
 * Project: I2
 * 
 * File Created at 2012-8-11
 * $Id$
 * 
 * Copyright 1999-2100 Bullx.com Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Bullx Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Bullx.com.
 */
package com.bullx.cag;

import javax.xml.ws.Endpoint;

import com.bullx.config.ConfigFactory;
import com.bullx.config.Configuration;
import com.bullx.utils.Log;

/**
 * @author Administrator
 */
public class CAGServer {

    private static Configuration config = ConfigFactory.getConfig();

    protected void run() {
        final String CAGUrl = config.getCAGUrl();
        Log.info("CAG Server start...");
        Endpoint.publish(CAGUrl + "CAG", new CAG());
    }

    public static void main(String[] args) {
        new CAGServer().run();
    }
    //
    //    public static void main(String[] args) throws Exception {
    //        String u = config.getCACUrl() + "hello?wsdl";
    //        URL url = new URL(u);
    //
    //        QName qname = new QName("http://server.demo.bullx.com/", "HelloService");
    //
    //        Service service = Service.create(url, qname);
    //
    //        HelloClient h = service.getPort(HelloClient.class);
    //
    //        System.out.println(h.sayHello("liubida"));
    //        System.out.println(h.sayHelloToOne("tom"));
    //        System.out.println(h.sayHelloToTwo("tom", "merry"));
    //    }
}
