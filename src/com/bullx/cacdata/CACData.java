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
package com.bullx.cacdata;

import java.util.HashMap;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.dom.DOMElement;
import org.hibernate.Query;

import com.bullx.database.ConfigIed;
import com.bullx.database.ConfigIedDAO;
import com.bullx.database.DataMmxn;
import com.bullx.database.DataSenv;
import com.bullx.database.DataSimg;
import com.bullx.database.DataSiml;
import com.bullx.database.DataSpdc;
import com.bullx.database.DataZsar;
import com.bullx.utils.FormatterUtil;

/**
 * @author Administrator
 */
public class CACData {

    public Document getRequest() {
        Document doc = DocumentHelper.createDocument();
        Element request = doc.addElement("request");

        DOMElement monitorData = getMonitorData();
        request.add(monitorData);

        return doc;
    }

    @SuppressWarnings("unchecked")
    private DOMElement getMonitorData() {
        DOMElement monitorNode = new DOMElement("monitordata");

        // sensor的数量
        int dataNumber = 0;

        ConfigIedDAO iedDAO = new ConfigIedDAO();
        List<ConfigIed> list = iedDAO.findAll();

        monitorNode.setAttribute("cacid", list.get(0).getConfigCac().getCacId());
        HashMap<String, String> objectMapper = new HashMap<String, String>();
        //add mappers the first is the ied class, the second is the query string
        objectMapper.put("SIML", "DataSiml");
        objectMapper.put("SPDC", "DataSpdc");
        objectMapper.put("MMXN", "DataMmxn");
        objectMapper.put("ZSAR", "DataZsar");
        objectMapper.put("SIMG", "DataSimg");
        objectMapper.put("SENV", "DataSenv");

        for (int i = 0; i < list.size(); i++) {
            ConfigIed ied = list.get(i);

            String objectString = objectMapper.get(ied.getLnClass());
            String queryString = "from " + objectString
                    + " as inst where inst.lnInst=? order by inst.dataTime desc";
            Query query = iedDAO.getSession().createQuery(queryString);
            query.setInteger(0, ied.getLnInst());
            query.setFirstResult(0);
            query.setMaxResults(1);
            List<Node> thizNodes = getDataNodes(ied.getLnClass(), query, ied);
            for (int j = 0; j < thizNodes.size(); j++, dataNumber++) {
                monitorNode.add(thizNodes.get(j));
            }
        }

        monitorNode.setAttribute("datanodenum", Integer.toString(dataNumber));

        return monitorNode;
    }

    /**
     * 根据不同的class去query不同的表
     * 
     * @param className
     * @param query
     * @param ied
     * @return
     */
    @SuppressWarnings("unchecked")
    private List<Node> getDataNodes(String className, Query query, ConfigIed ied) {
        if (className.equals("SIML")) {
            List<DataSiml> list = query.list();
            return FormatterUtil.DataFormatter(list.get(0), ied);
        } else if (className.equals("SPDC")) {
            List<DataSpdc> list = query.list();
            return FormatterUtil.DataFormatter(list.get(0), ied);
        } else if (className.equals("MMXN")) {
            List<DataMmxn> list = query.list();
            return FormatterUtil.DataFormatter(list.get(0), ied);
        } else if (className.equals("ZSAR")) {
            List<DataZsar> list = query.list();
            return FormatterUtil.DataFormatter(list.get(0), ied);
        } else if (className.equals("SIMG")) {
            List<DataSimg> list = query.list();
            return FormatterUtil.DataFormatter(list.get(0), ied);
        } else if (className.equals("SENV")) {
            List<DataSenv> list = query.list();
            return FormatterUtil.DataFormatter(list.get(0), ied);
        } else {
            return null;
        }
    }
}
