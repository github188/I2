/**
 * Project: I2
 * 
 * File Created at 2012-9-2
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
package com.bullx.cag;

import javax.jws.WebService;

import com.bullx.test.I2Test;
import com.bullx.utils.I2Util;

/**
 * @author Administrator
 */

@WebService
public class CAGPortType {

    public String uploadHeartbeatInfo(String strXMLParams) {
        return I2Util.readFromFile(I2Test.HeartBeatResponse);
    }

    public String uploadCACData(String strXMLParams) {
        return "ok, done!";
    }

    public String uploadCACConfig(String strXMLParams) {
        return null;
    }

    //
    //    String downloadCACLatestVersion(String strXMLParams);
    //
    //    String downloadCACHistoryVersion(String StrXMLParams);
    //
    //    String downloadCACUpdateFile(String StrXMLParams);
    //
    //    @Deprecated
    //    String downloadCAGCtrl(String strXMLParams);
}
