package com.test.example;

import java.sql.DriverManager;
import java.sql.Connection;
import org.junit.Test;

public class MySQLConnectionTest {

	//
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/sys?characterEncoding=UTF-8&serverTimezone=UTC&verifyServerCertificate=false&useSSL=false";
	private static final String USER = "root";
	private static final String PW = "root";
	
	@Test
	public void testConnection() throws Exception{
		try {
				Class.forName(DRIVER).newInstance();
			} catch (Exception e) {
				e.printStackTrace();
		}
		
		try( Connection con = DriverManager.getConnection(URL, USER, PW) ){
			System.out.println(con);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}