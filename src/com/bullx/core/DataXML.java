package com.bullx.core;

import java.util.HashMap;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.hibernate.Query;

import com.bullx.database.ConfigIed;
import com.bullx.database.ConfigIedDAO;
import com.bullx.database.DataMmxn;
import com.bullx.database.DataSenv;
import com.bullx.database.DataSimg;
import com.bullx.database.DataSiml;
import com.bullx.database.DataSpdc;
import com.bullx.database.DataZsar;

public class DataXML {
	public String get(){
		return getDataDocument().asXML();
	}
	
	@SuppressWarnings("unchecked")
	private Document getDataDocument(){
		Document doc = DocumentHelper.createDocument();
		
		Element requestNode = doc.addElement("request");
		
		Element monitorNode = requestNode.addElement("monitordata");
		
		int dataNumber = 0;
		
		ConfigIedDAO iedDAO = new ConfigIedDAO();
		List<ConfigIed> list = iedDAO.findAll();
		
		monitorNode.addAttribute("cacid", list.get(0).getConfigCac().getCacId());
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
			String queryString = "from " + objectString + " as inst where inst.lnInst=? order by inst.dataTime desc";
			Query query = iedDAO.getSession().createQuery(queryString);
			query.setInteger(0, ied.getLnInst());
			query.setFirstResult(0);
			query.setMaxResults(1);
			List<Node> thizNodes = getDataNodes(ied.getLnClass(), query, ied);
			for (int j = 0; j < thizNodes.size(); j++) {
				++dataNumber;
				monitorNode.add(thizNodes.get(j));
			}
			
		}
		
		monitorNode.addAttribute("datanodenum", Integer.toString(dataNumber));
		
		return doc;
	}
	
	@SuppressWarnings("unchecked")
	private List<Node> getDataNodes(String className, Query query, ConfigIed ied) {
		if (className.equals("SIML")) {
			List<DataSiml> list = query.list();
			return Formatter.DataFormatter(list.get(0), ied);
		} else if (className.equals("SPDC")) {
			List<DataSpdc> list = query.list();
			return Formatter.DataFormatter(list.get(0), ied);
		} else if (className.equals("MMXN")) {
			List<DataMmxn> list = query.list();
			return Formatter.DataFormatter(list.get(0), ied);
		} else if (className.equals("ZSAR")) {
			List<DataZsar> list = query.list();
			return Formatter.DataFormatter(list.get(0), ied);
		} else if (className.equals("SIMG")) {
			List<DataSimg> list = query.list();
			return Formatter.DataFormatter(list.get(0), ied);
		} else if (className.equals("SENV")) {
			List<DataSenv> list = query.list();
			return Formatter.DataFormatter(list.get(0), ied);
		} else {
			return null;
		}
	}
}
