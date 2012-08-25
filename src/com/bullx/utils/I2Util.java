/**
 * Project: I2
 * 
 * File Created at 2012-8-13
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
package com.bullx.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * tools of I2
 * 
 * @author Administrator
 */
public class I2Util {

    public static String           DATE_PATTERN_FOR_DAY  = "yyyy-MM-dd";
    public static String           DATE_PATTERN_FOR_TIME = "yyyy-MM-dd HH:mm:ss";
    public static SimpleDateFormat dateFormatterDay      = new SimpleDateFormat(
                                                                 DATE_PATTERN_FOR_DAY);

    public static SimpleDateFormat dateFormatterTime     = new SimpleDateFormat(
                                                                 DATE_PATTERN_FOR_TIME);

    public static String getStringDate(Date date) {
        if (null == date) {
            return "";
        }
        return dateFormatterDay.format(date);
    }

    public static String getStringTime(Date date) {
        if (null == date) {
            return "";            
        }
        return dateFormatterTime.format(date);
    }
    
    //FIXME: there are only two bits after point
    public static String getStringDouble(Double dbs){
    	return Double.toString(dbs);
    }
}
