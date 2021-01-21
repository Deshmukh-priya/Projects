package com.capgemini.service;
import com.capgemini.beans.Student;
import com.capgemini.view.Admin;

public class StudentScheduler extends Admin {
	private Student[] students=new Student[10];
	int counterStudent;
	Student s=new Student(counterStudent, name, courses);
	
	public String addStudent(int student_RollNo,String student_Name,String student_Course) {
		students[counterStudent++]=new Student(student_RollNo,student_Name,student_Course);
		return"Student added successfully";
	}
	public void showAll() {
		for(int i=0;i<10;i++) {
			System.out.println(students[i].getStudent_RollNo());
			System.out.println(students[i].getStudent_Name());
			System.out.println(students[i].getStudent_Course());
		}
		
	}
	
		
	public String getDetails_RollNo(int rollno) {
		int rollNum=Admin.rollno;
		for(Student s:students)
		{
			if(rollNum==s.getStudent_RollNo())
			{
				System.out.println("Roll Number: "+s.getStudent_RollNo() );
				System.out.println("Name: "+s.getStudent_Name());
				System.out.print("Courses Registered: "+s.getStudent_Course());
				
				
				break;			
			}
		}
		
	
		return " ";
	}
	
	public String getDetails_Course(String courses) {
		String course=Admin.courses;
			for(Student s:students)
			{
				if(course==s.getStudent_Course())
				{
					System.out.println("Roll Number: "+s.getStudent_RollNo() );
					System.out.println("Name: "+s.getStudent_Name());
					System.out.println("Course: "+ s.getStudent_Course());
					
					
					break;			
				}
			}
			
		return course;
		
	}
	public int getCount(String courses) {
		int count=0;
		String course=Admin.courses;
		for(int i=0;i<students.length;i++)
		{
			for(Student s:students) 
			{
				if(course.equalsIgnoreCase(course))
					count++;
			}
		}
		System.out.println(count +" Students have registered for this course\n");
		return count;
	}
}
	
	
	
	


