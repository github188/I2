package com.bullx.config;

public class DevConfiguration implements Configuration {
    public final String WebServiceUrl = "http://localhost:81/";

    @Override
    public String getWebServiceUrl() {
        return this.WebServiceUrl;
    }
}
