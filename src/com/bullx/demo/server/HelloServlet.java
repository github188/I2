package com.bullx.demo.server;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.xml.ws.Endpoint;

public class HelloServlet extends GenericServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("WebService start...");
        Endpoint.publish("http://localhost:8088/Hello", new Hello());
    }

    @Override
    public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException,
            IOException {
    }

    //    public void service(ServletRequest request, ServletResponse response) throws ServletException,
    //            IOException {
    //        response.setCharacterEncoding("GBK");
    //        Writer wr = response.getWriter();
    //        wr.write("<a href='http://192.168.1.103:8088/WS_Java6/HelloService?WSDL'>�������WSDL</a>");
    //        wr.close();
    //    }

}

