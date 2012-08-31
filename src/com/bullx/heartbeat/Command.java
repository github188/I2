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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.dom4j.Element;

/**
 * @author Administrator
 */
public class Command {
    private String              objid;
    private CommandType         commandType;
    private Map<String, String> action = new HashMap<String, String>();

    @SuppressWarnings("unchecked")
    public static List<Command> parse(Element e) {
        if (null == e) {
            return Collections.emptyList();
        }
        List<Element> commandNodeList = e.elements("command");
        List<Command> retList = new ArrayList<Command>();
        for (Element cmNode : commandNodeList) {
            Command c = new Command();
            c.objid = cmNode.attributeValue("objid");
            c.commandType = CommandType.valueOf(cmNode.attributeValue("type"));
            List<Element> actionNodeList = cmNode.elements();
            for (Element a : actionNodeList) {
                c.action.put(a.attributeValue("name"), a.attributeValue("value"));
            }
            retList.add(c);
        }
        return retList;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("objid: " + objid);
        sb.append("\ntype: " + commandType);

        for (Entry<String, String> a : action.entrySet()) {
            sb.append("\naction: ");
            sb.append(a.getKey() + " - " + a.getValue());
        }
        return sb.toString();
    }

    public String getObjid() {
        return objid;
    }

    public void setObjid(String objid) {
        this.objid = objid;
    }

    public CommandType getCommandType() {
        return commandType;
    }

    public void setCommandType(CommandType commandType) {
        this.commandType = commandType;
    }

    public Map<String, String> getAction() {
        return action;
    }

    public void setAction(Map<String, String> action) {
        this.action = action;
    }
}
