package com.bullx.heartbeat;

import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingQueue;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.dom.DOMElement;

import com.bullx.database.ConfigCac;
import com.bullx.database.ConfigCacDAO;
import com.bullx.database.ConfigIed;
import com.bullx.database.ConfigIedDAO;
import com.bullx.utils.I2Util;
import com.bullx.utils.Log;

/**
 * @author Administrator
 */
public class HeartBeat {
    public String response;
    private Result result;
    private List<Command> commands;

    /**
     * 构造心跳包的request
     * 
     * @return
     */
    public Document getRequest() {
        Document doc = DocumentHelper.createDocument();
        Element request = doc.addElement("request");

        DOMElement cac = getCAC();
        DOMElement sensors = getSensors();

        //cac和sensors是平级的
        request.add(cac);
        request.add(sensors);

        return doc;
    }

    /**
     * 解析心跳包的response
     */
    public List<Command> handleResponse(BlockingQueue<String> buffer) {
        Document doc;
        try {
            doc = DocumentHelper.parseText(response);

            // 解析出result
            Element resultXml = (Element) doc.selectNodes("response/result").get(0);
            result = new Result(resultXml);

            // 解析出commands
            Element commandsXml = (Element) doc.selectNodes("response/commands").get(0);
            commands = Command.parse(commandsXml);

            if (0 != result.getCode()) {
                buffer.put("result is error");
                buffer.put(result.toString());
                System.out.println("result is error");
                System.out.println(result);
            } else {
                buffer.put("result is success");
                System.out.println("result is success");
            }

            buffer.put("---------");
            System.out.println();
            return commands;
        } catch (DocumentException e) {
            Log.error(e.getMessage());
        } catch (Exception e) {
            Log.error(e.getMessage());
        }
        return null;
    }

    public List<Command> handleResponse() {
        Document doc;
        try {
            doc = DocumentHelper.parseText(response);

            // 解析出result
            Element resultXml = (Element) doc.selectNodes("response/result").get(0);
            result = new Result(resultXml);

            // 解析出commands
            Element commandsXml = (Element) doc.selectNodes("response/commands").get(0);
            commands = Command.parse(commandsXml);

            if (0 != result.getCode()) {
                System.out.println("result is error");
                System.out.println(result);
            } else {
                System.out.println("result is success");
            }

            System.out.println();
            return commands;
        } catch (DocumentException e) {
            Log.error(e.getMessage());
        } catch (Exception e) {
            Log.error(e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        HeartBeat a = new HeartBeat();
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
