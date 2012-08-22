package com.bullx.demo.client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.bullx.config.ConfigFactory;
import com.bullx.config.Configuration;
import com.bullx.database.ConfigCac;
import com.bullx.database.ConfigCacDAO;

public class TestClient {

    static Configuration config = ConfigFactory.getConfig();

    public static void main(String[] args) throws Exception {
        String u = config.getWebServiceUrl() + "hello?wsdl";
        URL url = new URL(u);

        QName qname = new QName("http://server.demo.bullx.com/", "HelloService");

        Service service = Service.create(url, qname);

        HelloClient h = service.getPort(HelloClient.class);

        System.out.println(h.sayHello("liubida"));
        System.out.println(h.sayHelloToOne("tom"));
        System.out.println(h.sayHelloToTwo("tom", "merry"));
        
//        ConfigCacDAO cacDAO = new ConfigCacDAO();
//        ConfigCac cacInstance = (ConfigCac) cacDAO.getSession().get(ConfigCac.class, "000");
//        System.out.println(h.sayHelloToOne(cacInstance.toString()));
    }
}
