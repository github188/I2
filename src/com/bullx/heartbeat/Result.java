/**
 * Project: I2
 * 
 * File Created at 2012-8-31
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
package com.bullx.heartbeat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.dom4j.Element;

import com.bullx.common.I2Error;

/**
 * @author Administrator
 */
@SuppressWarnings("unchecked")
public class Result {
    private int                 code;                                // success:0
    private I2Error             errorcode;
    private Map<String, String> attr = new HashMap<String, String>();

    public Result(Element e) {
        if (null == e) {
            return;
        }
        this.code = Integer.valueOf(e.attributeValue("code"));
        if (0 != this.code) {
            Element errorXml = e.element("error");
            if (null != errorXml) {
                this.errorcode = I2Error.codeOf(errorXml.attributeValue("errorcode"));
                List<Element> attrNodeList = errorXml.elements();
                for (Element a : attrNodeList) {
                    this.attr.put(a.attributeValue("name"), a.attributeValue("value"));
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("code: " + code);
        if (0 != code && null != errorcode) {
            sb.append("\nerrorcode: " + errorcode.getCode());
            if (null != attr) {
                for (Entry<String, String> a : attr.entrySet()) {
                    sb.append("\nattr: ");
                    sb.append(a.getKey() + " - " + a.getValue());
                }
            }
        }
        return sb.toString();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public I2Error getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(I2Error errorcode) {
        this.errorcode = errorcode;
    }

    public Map<String, String> getAttr() {
        return attr;
    }

    public void setAttr(Map<String, String> attr) {
        this.attr = attr;
    }

}
