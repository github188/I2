package com.bullx.constants;

import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import com.bullx.config.ConfigFactory;
import com.bullx.utils.I2Util;

/**
 * 系统的日志处理类，根据系统配置的日志级别打印日志
 * 
 * @author administrator
 */
public class Log {
    private static final Logger logger      = Logger.getLogger("I2");
    private static final Level  logLevel    = ConfigFactory.getConfig().getLogLevel();
    private static final String logFileName = ConfigFactory.getConfig().getLogFileName();

    static {
        // 设置log级别, log文件名, 输出格式
        logger.setLevel(logLevel);
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler(logFileName);
            fileHandler.setFormatter(new Formatter() {
                @Override
                public String format(LogRecord record) {
                    StringBuilder sb = new StringBuilder("[");
                    sb.append(record.getLevel()).append("] ")
                            .append(I2Util.getStringTime(new Date())).append(" -> ")
                            .append(record.getMessage());
                    return sb.toString();
                }
            });
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileHandler.setLevel(logLevel);
        logger.addHandler(fileHandler);
    }

    public static void info(String msg) {
        logger.info(msg);
    }

    public static void warn(String msg) {
        logger.warning(msg);
    }
}
