package com.test.example;

import java.sql.DriverManager;
import java.sql.Connection;
import org.junit.Test;

public class MySQLConnectionTest {
	//
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/sys?characterEncoding=UTF-8&serverTimezone=UTC&verifyServerCertificate=false&useSSL=false&allowPublicKeyRetrieval=true";
	// 초기 "jdbc:mysql://localhost:3306/example";
	//  Public Key Retrieval is not allowed 에러 수정 "jdbc:mysql://localhost:3306/Database_dbName?allowPublicKeyRetrieval=true&useSSL=false";
	// 이전 "jdbc:mysql://localhost:3306/sys?characterEncoding=UTF-8&serverTimezone=UTC&verifyServerCertificate=false&useSSL=false";

	private static final String USER = "root";
	private static final String PW = "013174zz";
	
	@Test	// Test Annotation 테스트해야 하는 내용을 메스드 안에 작성하고 메소트 위에 @Test 애노테이션을 추가하면 JUnit은 해당 메소드를 테스트용 코드로 간주하고 테스트를 진행 할 수 있습니다
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

/*
import java.sql.DriverManager;
import org.junit.Test;
import java.sql.Connection;

public class MySQLConnectionTest {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/example";
	//jdbc:mysql:주소:포트/DB명
	private static final String USER = "root";
	private static final String PW = "root";
	//Root 비밀번호
	
	@Test
	public void testConnection() throws Exception{
		try {
			// The newInstance() call is a work around for some
			// broken Java implementations

			Class.forName(DRIVER).newInstance();
			} catch (Exception ex) {
			// handle the error
		}
		//Class.forName(DRIVER);	// 문자열로 존재하는 클래스를 메모리에 로드(적재)하는 역할을 한다 즉 위의 com.mysql.jdbc.Driver를 메모리에 로드한다
		// Class.forName(com.mysql.jdbc.Driver)는 자기 자신을 등록하는 과정을 거친다
		
		//getConnection(url, dbname,username, password)
		try(Connection con = DriverManager.getConnection(URL, USER, PW)){
			System.out.println(con);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}*/