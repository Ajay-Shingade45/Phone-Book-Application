package com.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {

	private static Connection con;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/phonedata","root", "");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return con;
		
	} 
}
