package com.bullx.config;

import java.util.logging.Level;

public interface Configuration {

    Level getLogLevel();

    String getLogFileName();

    String getCAGUrl();

    String getCACUrl();
}
