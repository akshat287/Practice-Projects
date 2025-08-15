package com.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDao {
	
	private static boolean flag;
	
	public static boolean insertDb(Student s) {
		
		flag=false;
		
		try {
			//jdbc code..
			Connection con=CP.createC();
			String q="insert into students(Name, Enrollment) values(?,?)";
			
			//prepared statement
			PreparedStatement ps=con.prepareStatement(q);
			
			//set the values
			ps.setString(1, s.getName());
			ps.setString(2, s.getEnrollment());
			
			//execute
			ps.executeUpdate();
			flag=true;
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}

	
	
	public static boolean deleteStudent(String id) {
		// TODO Auto-generated method stub
		flag=false;
		
		try {
			
			Connection con=CP.createC();
			String q="delete from students where Enrollment=?";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setString(1, id);
			if(0<ps.executeUpdate())flag=true;
			else System.out.println("No student found with this Enrollment: "+ id);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	

	public static void showDetails() {
		// TODO Auto-generated method stub
		try {
			Connection con=CP.createC();
			String q="select * from students;";
			Statement st=con.createStatement();
			ResultSet set=st.executeQuery(q);
			
			while(set.next()) {
				int id=set.getInt(1);
				String name=set.getString(2);
				String er=set.getString(3);
				
				System.out.println("No: "+id);
				System.out.println("Name: "+name);
				System.out.println("Enrollment: "+er);
				System.out.println("***********************************");
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
