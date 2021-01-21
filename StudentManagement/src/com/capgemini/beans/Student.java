package com.capgemini.beans;

public class Student {
	private int student_RollNo;
	private String student_Name,student_Course;
	
	public Student(int student_RollNo,String student_Name,String student_Course) {
		super();
		this.setStudent_RollNo(student_RollNo);
		this.setStudent_Name(student_Name);
		this.setStudent_Course(student_Course);
	}

	public int getStudent_RollNo() {
		return student_RollNo;
	}

	public void setStudent_RollNo(int student_RollNo) {
		this.student_RollNo = student_RollNo;
	}

	public String getStudent_Name() {
		return student_Name;
	}

	public void setStudent_Name(String student_Name) {
		this.student_Name = student_Name;
	}

	public String getStudent_Course() {
		return student_Course;
	}

	public void setStudent_Course(String student_Course) {
		this.student_Course = student_Course;
	}
	

}
