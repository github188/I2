package com.bullx.utils;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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

public class FormatterUtil {

    private static Node generateAttr(String name, Object value, String alarm) {
        Element attrNode = new DOMElement("attr");

        String valueS = null;
        if (value == null) {
            valueS = "";
        } else {
            Class<?> valueClass = value.getClass();

            if (valueClass == Double.class) {
                valueS = I2Util.getStringDouble((Double) value);
            } else {
                if (valueClass == Timestamp.class) {
                    valueS = I2Util.getStringTime((Timestamp) value);
                } else {
                    valueS = value.toString();
                }
            }
        }

        attrNode.addAttribute("name", name);
        attrNode.addAttribute("value", valueS);
        attrNode.addAttribute("alarm", alarm);
        return attrNode;
    }

    private static DOMElement generateCommonAttrs(Date dt, ConfigIed ied, DOMElement thisRoot) {
        thisRoot.add(generateAttr("LinkedDevice", ied.getPrimaryId(), "FALSE"));
        thisRoot.add(generateAttr("DeviceCode", ied.getEquipmentInfo().getEqId(), "FALSE"));
        thisRoot.add(generateAttr("AcquisitionTime", dt, "FALSE"));
        return thisRoot;
    }

    //According to figure C.5
    private static Node MmxnAttrsFormatter(DataMmxn param, ConfigIed ied) {
        DOMElement thisRoot = new DOMElement("attrs");
        thisRoot = generateCommonAttrs(param.getDataTime(), ied, thisRoot);
        thisRoot.add(generateAttr("Phase", ied.getPhase(), "FALSE"));
        thisRoot.add(generateAttr("TotalCoreCurrent", param.getAmp(), getFlag(param.getAmpAlm())));
        return thisRoot;
    }

    public static List<Node> DataFormatter(DataMmxn param, ConfigIed ied) {
        DOMElement thisRoot = new DOMElement("datanode");
        thisRoot.setAttribute("sensorid", ied.getPrimaryId());

        Element typeNode = thisRoot.addElement("nodetype");
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

    //According to figure C.15
    //FIXME: Figure C.15 does not exist!!
    private static Node SenvAttrsFormatter(DataSenv param, ConfigIed ied) {
        DOMElement thisRoot = new DOMElement("datanode");
        thisRoot = generateCommonAttrs(param.getDataTime(), ied, thisRoot);
        thisRoot.add(generateAttr("EnvTemp", param.getEnvTmp(), "FALSE"));
        thisRoot.add(generateAttr("EnvHum", param.getEnvHum(), "FALSE"));
        return thisRoot;
    }

    public static List<Node> DataFormatter(DataSenv param, ConfigIed ied) {
        DOMElement thisRoot = new DOMElement("datanode");
        thisRoot.setAttribute("sensorid", ied.getPrimaryId());

        Element typeNode = thisRoot.addElement("nodetype");
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

    private static String getFlag(int value) {
        if (value > 0)
            return "TRUE";
        else
            return "FALSE";
    }

    //According to figure C.12
    //FIXME: 	1.I don't know which temperature here is
    //			2.No Pressure20C found
    private static Node SimgAttrsFormatter(DataSimg param, ConfigIed ied) {
        DOMElement thisRoot = new DOMElement("datanode");
        thisRoot = generateCommonAttrs(param.getDataTime(), ied, thisRoot);
        thisRoot.add(generateAttr("Temperature", param.getTmp(), "FALSE"));
        thisRoot.add(generateAttr("AbsolutePressure", param.getPres(), "FALSE"));
        thisRoot.add(generateAttr("Density", param.getDen(), getFlag(param.getDenAlm())));
        thisRoot.add(generateAttr("Pressure20C", param.getPres(), "FALSE"));
        return thisRoot;
    }

    //According to figure C.13
    private static Node SimgAttrsFormatter2(DataSimg param, ConfigIed ied) {
        DOMElement thisRoot = new DOMElement("datanode");
        thisRoot = generateCommonAttrs(param.getDataTime(), ied, thisRoot);
        thisRoot.add(generateAttr("Temperature", param.getTmp(), "FALSE"));
        thisRoot.add(generateAttr("Moisture", param.getMst(), getFlag(param.getMstAlm())));
        return thisRoot;
    }

    //Notice. According to specify, This object will generate 2 data nodes
    public static List<Node> DataFormatter(DataSimg param, ConfigIed ied) {
        DOMElement thisRoot = new DOMElement("datanode");
        thisRoot.setAttribute("sensorid", ied.getPrimaryId());

        Element typeNode = thisRoot.addElement("nodetype");
        typeNode.setText(DataType.MMXN);

        Element equipmentNode = thisRoot.addElement("equipmentid");
        equipmentNode.setText(ied.getEquipmentInfo().getEqId());

        Element timeStampNode = thisRoot.addElement("timestamp");
        timeStampNode.setText(I2Util.getStringTime(param.getDataTime()));

        thisRoot.add(SimgAttrsFormatter(param, ied));

        List<Node> list = new ArrayList<Node>();
        list.add(thisRoot);

        thisRoot = new DOMElement("datanode");
        thisRoot.setAttribute("sensorid", ied.getPrimaryId());

        typeNode = thisRoot.addElement("nodetype");
        typeNode.setText(DataType.MMXN);

        equipmentNode = thisRoot.addElement("equipmentid");
        equipmentNode.setText(ied.getEquipmentInfo().getEqId());

        timeStampNode = thisRoot.addElement("timestamp");
        timeStampNode.setText(I2Util.getStringTime(param.getDataTime()));

        thisRoot.add(SimgAttrsFormatter2(param, ied));
        list.add(thisRoot);
        return list;
    }

    //According to figure C.3
    //FIXME:	1.CH3 is not found in database figure siml
    //			2.TotalHydrocarbon is not found in database figure siml
    private static Node SimlAttrsFormatter(DataSiml param, ConfigIed ied) {
        DOMElement thisRoot = new DOMElement("datanode");
        thisRoot = generateCommonAttrs(param.getDataTime(), ied, thisRoot);
        thisRoot.add(generateAttr("Phase", ied.getPhase(), "FALSE"));
        thisRoot.add(generateAttr("H2", param.getH2ppm(), getFlag(param.getH2alm())));
        thisRoot.add(generateAttr("CH4", param.getCh4ppm(), "FALSE"));
        //thisRoot.add(generateAttr("CH3", param.get)))
        thisRoot.add(generateAttr("C2H4", param.getC2h4ppm(), "FALSE"));
        thisRoot.add(generateAttr("C2H2", param.getC2h2ppm(), getFlag(param.getC2h2alm())));
        thisRoot.add(generateAttr("CO", param.getCoppm(), "FALSE"));
        thisRoot.add(generateAttr("CO2", param.getCo2ppm(), "FALSE"));
        thisRoot.add(generateAttr("O2", param.getO2ppm(), "FALSE"));
        thisRoot.add(generateAttr("N2", param.getN2ppm(), "FALSE"));
        //thisRoot.add(generateAttr("TotalHydrocarbon", )))
        return thisRoot;
    }

    //According to figure C.4
    private static Node SimlAttrsFormatter2(DataSiml param, ConfigIed ied) {
        DOMElement thisRoot = new DOMElement("datanode");
        thisRoot = generateCommonAttrs(param.getDataTime(), ied, thisRoot);
        thisRoot.add(generateAttr("Phase", ied.getPhase(), "FALSE"));
        thisRoot.add(generateAttr("Moisture", param.getMst(), "FALSE"));
        return thisRoot;
    }

    //According to specifies, siml will generate two nodes
    public static List<Node> DataFormatter(DataSiml param, ConfigIed ied) {
        DOMElement thisRoot = new DOMElement("datanode");
        thisRoot.setAttribute("sensorid", ied.getPrimaryId());

        Element typeNode = thisRoot.addElement("nodetype");
        typeNode.setText(DataType.MMXN);

        Element equipmentNode = thisRoot.addElement("equipmentid");
        equipmentNode.setText(ied.getEquipmentInfo().getEqId());

        Element timeStampNode = thisRoot.addElement("timestamp");
        timeStampNode.setText(I2Util.getStringTime(param.getDataTime()));

        thisRoot.add(SimlAttrsFormatter(param, ied));

        List<Node> list = new ArrayList<Node>();
        list.add(thisRoot);

        thisRoot = new DOMElement("datanode");
        thisRoot.setAttribute("sensorid", ied.getPrimaryId());

        typeNode = thisRoot.addElement("nodetype");
        typeNode.setText(DataType.MMXN);

        equipmentNode = thisRoot.addElement("equipmentid");
        equipmentNode.setText(ied.getEquipmentInfo().getEqId());

        timeStampNode = thisRoot.addElement("timestamp");
        timeStampNode.setText(I2Util.getStringTime(param.getDataTime()));

        thisRoot.add(SimlAttrsFormatter2(param, ied));
        list.add(thisRoot);
        return list;
    }

    //According to figure C.2
    //FIXME:	I can't find the corresponds of figure C.2 and database figure spdc
    private static Node SpdcAttrsFormatter(DataSpdc param, ConfigIed ied) {
        DOMElement thisRoot = new DOMElement("datanode");
        thisRoot = generateCommonAttrs(param.getDataTime(), ied, thisRoot);
        thisRoot.add(generateAttr("Phase", ied.getPhase(), "FALSE"));
        //thisRoot.add(generateAttr("DischargeCapacity", param.get)));
        return thisRoot;
    }

    public static List<Node> DataFormatter(DataSpdc param, ConfigIed ied) {
        DOMElement thisRoot = new DOMElement("datanode");
        thisRoot.setAttribute("sensorid", ied.getPrimaryId());

        Element typeNode = thisRoot.addElement("nodetype");
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

    //According to figure C.8
    //FIXME: there is a Alarm member in the database figure, but I don't know where to put it.
    private static Node ZsarAttrsFormatter(DataZsar param, ConfigIed ied) {
        DOMElement thisRoot = new DOMElement("datanode");
        thisRoot = generateCommonAttrs(param.getDataTime(), ied, thisRoot);
        thisRoot.add(generateAttr("Phase", ied.getPhase(), "FALSE"));
        thisRoot.add(generateAttr("SystemVoltage", param.getSysVol(), "FALSE"));
        thisRoot.add(generateAttr("TotalCurrent", param.getTotA(), "FALSE"));
        thisRoot.add(generateAttr("ResistiveCurrent", param.getRisA(), "FALSE"));
        thisRoot.add(generateAttr("ActionCount", param.getActCount(), "FALSE"));
        thisRoot.add(generateAttr("LastActionTime", param.getLastActTime(), "FALSE"));
        return thisRoot;
    }

    public static List<Node> DataFormatter(DataZsar param, ConfigIed ied) {
        DOMElement thisRoot = new DOMElement("datanode");
        thisRoot.setAttribute("sensorid", ied.getPrimaryId());

        Element typeNode = thisRoot.addElement("nodetype");
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

    public static Node CacConfigFormatter() {
        return null;
    }
}
