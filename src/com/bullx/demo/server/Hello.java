package com.bullx.demo.server;

import javax.jws.WebService;

@WebService
public class Hello {
    public String sayHello() {
        return "hello";
    }

    public String sayHelloToOne(String name) {
        return "hello," + name;
    }

    public String sayHelloToTwo(String name1, String name2) {
        return "hello, " + name1 + " and " + name2;
    }
}
