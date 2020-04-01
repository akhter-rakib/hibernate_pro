package com.rakib.hibernamte_pro;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcTest {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hibernate_pro?useSSL=false";
		String user ="root";
		String passWord = "mysql123";
		try{
			System.out.println("Database Conncection " +jdbcUrl);
			Connection mycon = DriverManager.getConnection(jdbcUrl, user, passWord);
			System.out.println("Connection Connection");
		}catch(Exception exc){
			exc.printStackTrace();
		}
				

	}

}
