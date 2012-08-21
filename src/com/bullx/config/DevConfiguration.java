package com.bullx.config;

import java.util.logging.Level;

public class DevConfiguration implements Configuration {
    private final String WebServiceUrl = "http://127.0.0.1:9999/";
    private final Level    logLevel      = Level.INFO;
    private final String logFileName   = System.getProperty("user.dir") + "/dev.log";
    
    @Override
    public String getWebServiceUrl() {
        return this.WebServiceUrl;
    }

    @Override
    public Level getLogLevel() {
        return this.logLevel;
    }

    @Override
    public String getLogFileName() {
        return this.logFileName;
    }
}
