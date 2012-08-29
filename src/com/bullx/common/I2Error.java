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
package com.bullx.common;

/**
 * @author Administrator
 */
public enum I2Error {
    XML_ERROR_1("020001", "XML校验错误", "调用服务方法失败，输入参数xml过大"),
    XML_ERROR_2("020002", "XML校验错误", "调用服务方法失败，参数不符合规范"),
    ID_ERROR_1("0201001", "ID校验错误", "调用方法出错, ID不合法"),
    ID_ERROR_2("0201002", "ID校验错误", "调用方法出错, ID不存在"),
    ID_ERROR_3("0201003", "ID校验错误", "调用方法出错, CAC与所辖状态监测装置不匹配"),
    ID_ERROR_4("0201004", "ID校验错误", "调用方法出错, 状态监测装置与被监测设备不匹配"),
    DATA_FORMAT_ERROR_1("0202001", "数据格式错误", "调用服务方法出错，时间格式错误"),
    DATA_FORMAT_ERROR_2("0202002", "数据格式错误", "调用服务方法出错，数据无法转换成对应格式"),
    DATA_ERROR_1("0203001", "数据内容错误", "调用服务方法出错，监测类型与监测参数不一致"),
    DATA_ERROR_2("0203002", "数据内容错误", "调用服务方法出错，监测类型不存在"),
    DATA_ERROR_3("0203003", "数据内容错误", "调用服务方法出错，监测参数不存在"),
    DATA_ERROR_4("0203004", "数据内容错误", "调用服务方法出错，监测参数缺失"),
    DATA_ERROR_5("0203005", "数据内容错误", "调用服务方法出错，数据不符合业务规范"),
    UNKNOWN_ERROR("99", "位置错误类型", "调用方法失败");

    public static I2Error codeOf(String code) {
        if (null == code || "".equalsIgnoreCase(code)) {
            return null;
        }
        for (I2Error e : I2Error.values()) {
            if (e.getCode().equalsIgnoreCase(code)) {
                return e;
            }
        }
        return null;
    }

    private final String code;
    private final String type;
    private final String comments;

    private I2Error(String code, String type, String comments) {
        this.code = code;
        this.type = type;
        this.comments = comments;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @return the comments
     */
    public String getComments() {
        return comments;
    }
}
