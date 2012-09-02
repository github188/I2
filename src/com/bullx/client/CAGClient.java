/**
 * Project: I2
 * 
 * File Created at 2012-8-28
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
package com.bullx.client;

import javax.jws.WebService;

/**
 * @author Administrator
 */
//@WebService(name = "CAG", targetNamespace = "http://server.demo.bullx.com/")
@WebService(name = "CAG", targetNamespace = "http://server.demo.bullx.com/")
public interface CAGClient {

    String uploadCACHeartbeatInfo(String strXMLParams);

    String uploadCACData(String strXMLParams);
    //
    //    String uploadCACConfig(String strXMLParams);
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
