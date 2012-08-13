package com.bullx.config;

import java.util.logging.Level;

public interface Configuration {

    String getWebServiceUrl();

    Level getLogLevel();

    String getLogFileName();
}
