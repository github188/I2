package com.bullx.demo.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "Hello", targetNamespace = "http://server.demo.bullx.com/")
public interface HelloClient {
    @WebMethod 
    
    //    @WebResult(partName = "return")
    String sayHello(@WebParam(name = "arg0", partName = "arg0") String arg0);

    String sayHelloToOne(@WebParam(name = "arg0", partName = "arg0") String arg0);

    String sayHelloToTwo(String arg0, String arg1);
}
