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
package com.bullx.cacconfig;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.dom.DOMElement;

/**
 * @author Administrator
 */
public class CACConfig {

    public Document getRequest() {
        Document doc = DocumentHelper.createDocument();
        Element request = doc.addElement("request");

        DOMElement configsData = getConfigs();
        request.add(configsData);
        return doc;
    }

    @SuppressWarnings("unchecked")
    private DOMElement getConfigs() {
        final int config_count = 5;
        final int attr_count = 2;

        DOMElement configsNode = new DOMElement("configs");

        for (int i = 0; i < config_count; i++) {
            DOMElement config = new DOMElement("config");
            config.setAttribute("objid", "liubida");
            config.setAttribute("dataacquiretime", "30");
            config.setAttribute("heartbeattime", "20");
            config.setAttribute("version", "1.01");
            for (int j = 0; j < attr_count; j++) {
                DOMElement attr = new DOMElement("attr");
                attr.setAttribute("desc", "状态监测数目");
                attr.setAttribute("name", "SENSORNUM");
                attr.setAttribute("type", "INT");
                attr.setAttribute("length", "2");
                attr.setAttribute("uint", "");
                attr.setAttribute("range", ">=0");
                attr.setAttribute("note", "nimabi");
                attr.setAttribute("value", "2");
                config.add(attr);
            }
            configsNode.add(config);
        }

        return configsNode;
    }
    //
    //    private DOMElement getMonitorData() {
    //        DOMElement monitorNode = new DOMElement("monitordata");
    //
    //        // sensor的数量
    //        int dataNumber = 0;
    //
    //        ConfigIedDAO iedDAO = new ConfigIedDAO();
    //        List<ConfigIed> list = iedDAO.findAll();
    //
    //        monitorNode.setAttribute("cacid", list.get(0).getConfigCac().getCacId());
    //        HashMap<String, String> objectMapper = new HashMap<String, String>();
    //        //add mappers the first is the ied class, the second is the query string
    //        objectMapper.put("SIML", "DataSiml");
    //        objectMapper.put("SPDC", "DataSpdc");
    //        objectMapper.put("MMXN", "DataMmxn");
    //        objectMapper.put("ZSAR", "DataZsar");
    //        objectMapper.put("SIMG", "DataSimg");
    //        objectMapper.put("SENV", "DataSenv");
    //
    //        for (int i = 0; i < list.size(); i++) {
    //            ConfigIed ied = list.get(i);
    //
    //            String objectString = objectMapper.get(ied.getLnClass());
    //            String queryString = "from " + objectString
    //                    + " as inst where inst.lnInst=? order by inst.dataTime desc";
    //            Query query = iedDAO.getSession().createQuery(queryString);
    //            query.setInteger(0, ied.getLnInst());
    //            query.setFirstResult(0);
    //            query.setMaxResults(1);
    //            List<Node> thizNodes = getDataNodes(ied.getLnClass(), query, ied);
    //            for (int j = 0; j < thizNodes.size(); j++, dataNumber++) {
    //                monitorNode.add(thizNodes.get(j));
    //            }
    //        }
    //
    //        monitorNode.setAttribute("datanodenum", Integer.toString(dataNumber));
    //
    //        return monitorNode;
    //    }
    //
    //    /**
    //     * 根据不同的class去query不同的表
    //     * 
    //     * @param className
    //     * @param query
    //     * @param ied
    //     * @return
    //     */
    //    @SuppressWarnings("unchecked")
    //    private List<Node> getDataNodes(String className, Query query, ConfigIed ied) {
    //        if (className.equals("SIML")) {
    //            List<DataSiml> list = query.list();
    //            return FormatterUtil.DataFormatter(list.get(0), ied);
    //        } else if (className.equals("SPDC")) {
    //            List<DataSpdc> list = query.list();
    //            return FormatterUtil.DataFormatter(list.get(0), ied);
    //        } else if (className.equals("MMXN")) {
    //            List<DataMmxn> list = query.list();
    //            return FormatterUtil.DataFormatter(list.get(0), ied);
    //        } else if (className.equals("ZSAR")) {
    //            List<DataZsar> list = query.list();
    //            return FormatterUtil.DataFormatter(list.get(0), ied);
    //        } else if (className.equals("SIMG")) {
    //            List<DataSimg> list = query.list();
    //            return FormatterUtil.DataFormatter(list.get(0), ied);
    //        } else if (className.equals("SENV")) {
    //            List<DataSenv> list = query.list();
    //            return FormatterUtil.DataFormatter(list.get(0), ied);
    //        } else {
    //            return null;
    //        }
    //    }
}
