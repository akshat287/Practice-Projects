package com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CP {
	
	static Connection con;
	public static Connection createC() throws ClassNotFoundException, SQLException {
		
		//load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//create the connection
		String user="root";
		String password="root";
		String url="jdbc:mysql://localhost:3306/student_management";
		con=DriverManager.getConnection(url,user,password);
		
		return con;
		
	}
}
