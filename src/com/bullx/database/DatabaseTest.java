package com.bullx.database;

import java.util.ArrayList;
import java.util.List;


public class DatabaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigCacDAO cacDAO = new ConfigCacDAO();
		List<ConfigCac> list = cacDAO.findAll();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getCacId());
		}
		
		ConfigIedDAO iedDAO = new ConfigIedDAO();
		List<ConfigIed> iList = iedDAO.findAll();
		for (int i = 0; i < iList.size(); i++) {
			ConfigIed ied = iList.get(i);
			System.out.println(ied.getIedName() + " " + ied.getIedNameCn() + " " + ied.getConfigCac().getCacId());
		}
	}

}
