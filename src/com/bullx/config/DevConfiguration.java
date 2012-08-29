package com.bullx.config;

import java.util.logging.Level;

public class DevConfiguration implements Configuration {
    private final String CACUrl      = "http://127.0.0.1:9999/";
    private final String CAGUrl      = "";

    private final Level  logLevel    = Level.INFO;
    private final String logFileName = System.getProperty("user.dir") + "/dev.log";

    @Override
    public Level getLogLevel() {
        return this.logLevel;
    }

    @Override
    public String getLogFileName() {
        return this.logFileName;
    }

    @Override
    public String getCAGUrl() {
        return this.CAGUrl;
    }

    @Override
    public String getCACUrl() {
        return this.CACUrl;
    }
}
