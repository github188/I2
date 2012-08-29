/**
 * Project: I2
 * 
 * File Created at 2012-8-27
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
package com.bullx.core;

import org.dom4j.Document;

/**
 * @author Administrator
 */
public interface Body {

    Document getRequest();

    Document getResponse();
}
