package com.bullx.core;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.dom.DOMElement;

import com.bullx.common.DataType;
import com.bullx.database.ConfigIed;
import com.bullx.database.DataMmxn;
import com.bullx.database.DataSenv;
import com.bullx.database.DataSimg;
import com.bullx.database.DataSiml;
import com.bullx.database.DataSpdc;
import com.bullx.database.DataZsar;
import com.bullx.utils.I2Util;

public class FormatterUtil {

    /**
     * 获取DataMmxn的attr
     * 
     * @param param
     * @param ied
     * @return
     */
    private static Node MmxnAttrsFormatter(DataMmxn param, ConfigIed ied) {
        DOMElement thisRoot = new DOMElement("attrs");

        Element attrNode = thisRoot.addElement("attr");
        attrNode.addAttribute("name", "AmpTh");
        attrNode.addAttribute("value", I2Util.getStringDouble(param.getAmp()));
        attrNode.addAttribute("alarm", "FALSE");

        return thisRoot;
    }

    public static List<Node> DataFormatter(DataMmxn param, ConfigIed ied) {
        DOMElement thisRoot = new DOMElement("datanode");
        thisRoot.setAttribute("sensorid", ied.getPrimaryId());

        Element typeNode = thisRoot.addElement("type");
        typeNode.setText(DataType.MMXN);

        Element equipmentNode = thisRoot.addElement("equipmentid");
        equipmentNode.setText(ied.getEquipmentInfo().getEqId());

        Element timeStampNode = thisRoot.addElement("timestamp");
        timeStampNode.setText(I2Util.getStringTime(param.getDataTime()));

        thisRoot.add(MmxnAttrsFormatter(param, ied));

        List<Node> list = new ArrayList<Node>();
        list.add(thisRoot);
        return list;
    }

    private static Node SenvAttrsFormatter(DataSenv param, ConfigIed ied) {
        return new DOMElement("NOT-IMPLEMENTED");
    }

    public static List<Node> DataFormatter(DataSenv param, ConfigIed ied) {
        DOMElement thisRoot = new DOMElement("datanode");
        thisRoot.setAttribute("sensorid", ied.getPrimaryId());

        Element typeNode = thisRoot.addElement("type");
        typeNode.setText(DataType.MMXN);

        Element equipmentNode = thisRoot.addElement("equipmentid");
        equipmentNode.setText(ied.getEquipmentInfo().getEqId());

        Element timeStampNode = thisRoot.addElement("timestamp");
        timeStampNode.setText(I2Util.getStringTime(param.getDataTime()));

        thisRoot.add(SenvAttrsFormatter(param, ied));

        List<Node> list = new ArrayList<Node>();
        list.add(thisRoot);
        return list;
    }

    private static Node SimgAttrsFormatter(DataSimg param, ConfigIed ied) {
        return new DOMElement("NOT-IMPLEMENTED");
    }

    public static List<Node> DataFormatter(DataSimg param, ConfigIed ied) {
        DOMElement thisRoot = new DOMElement("datanode");
        thisRoot.setAttribute("sensorid", ied.getPrimaryId());

        Element typeNode = thisRoot.addElement("type");
        typeNode.setText(DataType.MMXN);

        Element equipmentNode = thisRoot.addElement("equipmentid");
        equipmentNode.setText(ied.getEquipmentInfo().getEqId());

        Element timeStampNode = thisRoot.addElement("timestamp");
        timeStampNode.setText(I2Util.getStringTime(param.getDataTime()));

        thisRoot.add(SimgAttrsFormatter(param, ied));

        List<Node> list = new ArrayList<Node>();
        list.add(thisRoot);
        return list;
    }

    private static Node SimlAttrsFormatter(DataSiml dataSiml, ConfigIed ied) {
        return new DOMElement("NOT-IMPLEMENTED");
    }

    /**
     * @param dataSiml
     * @param ied
     * @return
     */
    public static List<Node> DataFormatter(DataSiml dataSiml, ConfigIed ied) {
        DOMElement thisRoot = new DOMElement("datanode");
        thisRoot.setAttribute("sensorid", ied.getPrimaryId());

        Element typeNode = thisRoot.addElement("type");
        typeNode.setText(DataType.MMXN);

        Element equipmentNode = thisRoot.addElement("equipmentid");
        equipmentNode.setText(ied.getEquipmentInfo().getEqId());

        Element timeStampNode = thisRoot.addElement("timestamp");
        timeStampNode.setText(I2Util.getStringTime(dataSiml.getDataTime()));

        thisRoot.add(SimlAttrsFormatter(dataSiml, ied));

        List<Node> list = new ArrayList<Node>();
        list.add(thisRoot);
        return list;
    }

    private static Node SpdcAttrsFormatter(DataSpdc param, ConfigIed ied) {
        return new DOMElement("NOT-IMPLEMENTED");
    }

    public static List<Node> DataFormatter(DataSpdc param, ConfigIed ied) {
        DOMElement thisRoot = new DOMElement("datanode");
        thisRoot.setAttribute("sensorid", ied.getPrimaryId());

        Element typeNode = thisRoot.addElement("type");
        typeNode.setText(DataType.MMXN);

        Element equipmentNode = thisRoot.addElement("equipmentid");
        equipmentNode.setText(ied.getEquipmentInfo().getEqId());

        Element timeStampNode = thisRoot.addElement("timestamp");
        timeStampNode.setText(I2Util.getStringTime(param.getDataTime()));

        thisRoot.add(SpdcAttrsFormatter(param, ied));

        List<Node> list = new ArrayList<Node>();
        list.add(thisRoot);
        return list;
    }

    private static Node ZsarAttrsFormatter(DataZsar param, ConfigIed ied) {
        return new DOMElement("NOT-IMPLEMENTED");
    }

    public static List<Node> DataFormatter(DataZsar param, ConfigIed ied) {
        DOMElement thisRoot = new DOMElement("datanode");
        thisRoot.setAttribute("sensorid", ied.getPrimaryId());

        Element typeNode = thisRoot.addElement("type");
        typeNode.setText(DataType.MMXN);

        Element equipmentNode = thisRoot.addElement("equipmentid");
        equipmentNode.setText(ied.getEquipmentInfo().getEqId());

        Element timeStampNode = thisRoot.addElement("timestamp");
        timeStampNode.setText(I2Util.getStringTime(param.getDataTime()));

        thisRoot.add(ZsarAttrsFormatter(param, ied));

        List<Node> list = new ArrayList<Node>();
        list.add(thisRoot);
        return list;
    }
}
