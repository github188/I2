package com.bullx.config;

import java.io.File;
import java.util.logging.Level;

public class ProdConfiguration implements Configuration {
    private final String CACUrl      = "http://127.0.0.1:9999/";
    private final String CAGUrl      = "";
    private final Level  logLevel    = Level.WARNING;
    private final String logFileName = System.getProperty("user.dir") + "/prod.log";

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

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
        System.out.println(ProdConfiguration.class.getClassLoader().getResource(""));
        System.out.println(ClassLoader.getSystemResource(""));
        System.out.println(ProdConfiguration.class.getResource(""));
        System.out.println(ProdConfiguration.class.getResource("/"));
        System.out.println(new File("").getAbsolutePath());
        System.out.println(System.getProperty("user.dir"));
    }
}
