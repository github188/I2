package com.bullx.core;

import java.util.List;

import org.dom4j.DocumentHelper;
import org.dom4j.dom.DOMElement;
import org.dom4j.Document;

import com.bullx.database.ConfigCac;
import com.bullx.database.ConfigCacDAO;
import com.bullx.database.ConfigIed;
import com.bullx.database.ConfigIedDAO;

/*
 * This class generate HeartBeat xml string 
 * @get		return string
 */
public class HeartBeatXML {
	public String get(){
		return this.getHeartBeatDocument().asXML();
	}
	
	private Document getHeartBeatDocument(){
		Document doc = DocumentHelper.createDocument();
		DOMElement requestNode = new DOMElement("request");
		
		ConfigCacDAO cacDAO = new ConfigCacDAO();
		ConfigCac configCac = cacDAO.getLatestInstance();
		
		ConfigIedDAO iedDAO = new ConfigIedDAO();
		List<ConfigIed> list = iedDAO.findAll();
		
		
		
		requestNode.add(Formatter.ConfigCacFormat(configCac));
		DOMElement sensorsNode = new DOMElement("sensors");
		
		for (int i = 0; i < list.size(); i++) {
			sensorsNode.add(Formatter.SensorFormatter(list.get(i)));
		}
		
		requestNode.add(sensorsNode);
		
		return doc;
	}
}
