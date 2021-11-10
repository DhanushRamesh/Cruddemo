package com.crud.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	
	public static Connection connection;
	
	public Connection getconnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		if(connection==null) {
			
			connection = DriverManager.getConnection("jdbc:mysql://:3306/crud?allowPublicKeyRetrieval=true&useSSL=false", "root", "Rajadhdh22@");
			
		}
		return connection;
	}

}
