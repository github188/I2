package com.bullx.database;

public class TestDatabase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigCacDAO cdao = new ConfigCacDAO();
		ConfigCac cacInstance = cdao.findById("00000000000000000");
		System.out.println(cacInstance.getCagip());
	}

}
