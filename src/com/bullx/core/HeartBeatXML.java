package com.bullx.core;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.dom.DOMElement;

import com.bullx.common.I2Error;
import com.bullx.database.ConfigCac;
import com.bullx.database.ConfigCacDAO;
import com.bullx.database.ConfigIed;
import com.bullx.database.ConfigIedDAO;
import com.bullx.test.I2Test;
import com.bullx.utils.I2Util;
import com.bullx.utils.Log;

/**
 * @author Administrator
 */

@SuppressWarnings("unchecked")
class Result {
    private int                 code;     // success:0
    private I2Error             errorcode;
    private Map<String, String> attr;

    public Result() {
    }

    public Result(Element e) {
        if (null == e) {
            return;
        }
        this.code = Integer.valueOf(e.attributeValue("code"));
        if (0 != this.code) {
            Element errorXml = e.element("error");
            if (null != errorXml) {
                this.errorcode = I2Error.codeOf(errorXml.attributeValue("errorcode"));
                List<Element> attrList = e.elements();
                for (Element a : attrList) {
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

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return the errorcode
     */
    public I2Error getErrorcode() {
        return errorcode;
    }

    /**
     * @param errorcode the errorcode to set
     */
    public void setErrorcode(I2Error errorcode) {
        this.errorcode = errorcode;
    }

    /**
     * @return the attr
     */
    public Map<String, String> getAttr() {
        return attr;
    }

    /**
     * @param attr the attr to set
     */
    public void setAttr(Map<String, String> attr) {
        this.attr = attr;
    }

}

public class HeartBeatXML {

    public String response = null;

    public Document getRequest() {
        Document doc = DocumentHelper.createDocument();
        Element request = doc.addElement("request");

        DOMElement cac = getCAC();
        DOMElement sensors = getSensors();

        request.add(cac);
        request.add(sensors);

        return doc;
    }

    public void handleResponse() {
        response = I2Util.readFromFile(I2Test.ResultXMLFile);
        System.out.println(response);
        Document doc;
        try {
            doc = DocumentHelper.parseText(response);
            Element resultXml = (Element) doc.selectNodes("response/result").get(0);
            Result result = new Result(resultXml);
            System.out.println(result);
        } catch (DocumentException e) {
            Log.error(e.getMessage());
        }
    }

    public static void main(String[] args) {
        HeartBeatXML a = new HeartBeatXML();
        a.handleResponse();
    }

    /**
     * <cac id="97M00090990000597">
     * <ip>10.144.98.101</ip>
     * <curtime>2010-04-1022:10:11</curtime>
     * <operationtemperature>15.00</operationtemperature>
     * </cac>
     * 
     * @return
     */
    private DOMElement getCAC() {
        ConfigCacDAO cacDAO = new ConfigCacDAO();
        ConfigCac configCac = cacDAO.getLatestInstance();

        //create cac node
        DOMElement thisRoot = new DOMElement("cac");
        thisRoot.setAttribute("ip", configCac.getCacId());

        //add cac sub nodes
        //ip node
        DOMElement ipNode = new DOMElement("ip");
        ipNode.addText(configCac.getCacIp());
        thisRoot.add(ipNode);

        //curtime node
        DOMElement curtimeNode = new DOMElement("curtime");
        curtimeNode.addText(I2Util.getStringTime(new Date()));
        thisRoot.add(curtimeNode);

        //operationtemperature node
        DOMElement operationTemperatureNode = new DOMElement("operationtemperature");
        operationTemperatureNode.addText(I2Util.getStringDouble(configCac.getOperTemp()));
        thisRoot.add(operationTemperatureNode);
        return thisRoot;
    }

    /**
     * <sensors>
     * <sensorid="26M00090990000987">
     * <status>NORMAL</status>
     * <operationtemperature>15.00</operationtemperature>
     * </sensor>
     * <sensorid="26M00090990000987">
     * <status>NORMAL</status>
     * <operationtemperature>12.00</operationtemperature>
     * </sensor>
     * </sensors>
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    private DOMElement getSensors() {
        DOMElement sensorsNode = new DOMElement("sensors");

        ConfigIedDAO iedDAO = new ConfigIedDAO();
        List<ConfigIed> list = iedDAO.findAll();

        for (ConfigIed c : list) {
            DOMElement thisRoot = new DOMElement("sensor");
            thisRoot.setAttribute("id", c.getPrimaryId());

            //status
            DOMElement statusNode = new DOMElement("status");
            statusNode.addText(c.getStatus() ? "NORMAL" : "BREAK");
            thisRoot.add(statusNode);

            //operationtempature
            DOMElement operationTemperatureNode = new DOMElement("operationtemperature");
            operationTemperatureNode.addText(I2Util.getStringDouble(c.getOperTemp()));
            thisRoot.add(operationTemperatureNode);

            sensorsNode.add(thisRoot);
        }
        return sensorsNode;
    }
}
