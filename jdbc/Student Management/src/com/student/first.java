package com.student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class first {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome to My App");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("1. Add Student");
			System.out.println("2. Delete Student");
			System.out.println("3. Show Students");
			System.out.println("4. Exit");
			
			int n=Integer.parseInt(br.readLine());
			switch(n) {
			case 1:
				System.out.println("Enter name: ");
				String name=br.readLine();
				System.out.println("Enter Enrollment: ");
				String en=br.readLine();
				
				Student st=new Student(name,en);
				boolean b=StudentDao.insertDb(st);
				if(b)System.out.println("Student added!!");
				else System.out.println("Error Occured..");
				
				System.out.println(st);
				break;
				
			case 2:
				System.out.println("Enter Enrollment: ");
				String id=br.readLine();
				boolean b1=StudentDao.deleteStudent(id);
				if(b1)System.out.println("Executed successfully!!");
				else System.out.println("Error Ocuured..");
				break;
				
			case 3:
				StudentDao.showDetails();
				break;
			case 4:
				System.out.println("Thanks for using the app!");
				System.exit(0);
				
			}
			
		}
	}

}

