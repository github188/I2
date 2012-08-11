/**
 * Project: I2
 * 
 * File Created at 2012-8-11
 * $Id$
 * 
 * Copyright 1999-2100 Bullx.com Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Bullx Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Bullx.com.
 */
package com.bullx.config;

/**
 * 输出配置
 * 
 * @author Administrator
 */

public class ConfigFactory {
    private static class configHolder {
        // TODO 从配置文件里面读取
        static Configuration instance = new DevConfiguration();
    }

    public static Configuration getInstance() {
        return configHolder.instance;
    }
}
