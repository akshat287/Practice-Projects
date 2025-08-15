package com.student;

public class Student {
	
	private int No;
	private String Name;
	private String Enrollment;
	
	
	public int getNo() {
		return No;
	}

	public void setNo(int no) {
		No = no;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEnrollment() {
		return Enrollment;
	}

	public void setEnrollment(String enrollment) {
		Enrollment = enrollment;
	}

	public Student(String name, String enrollment) {
		super();
		Name = name;
		Enrollment = enrollment;
	}

	public Student(int no, String name, String enrollment) {
		super();
		No = no;
		Name = name;
		Enrollment = enrollment;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Student [No=" + No + ", Name=" + Name + ", Enrollment=" + Enrollment + "]";
	}
	
	
	

}
