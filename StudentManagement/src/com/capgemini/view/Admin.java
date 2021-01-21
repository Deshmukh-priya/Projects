package com.capgemini.view;
import com.capgemini.service.*;
import java.util.*;

public class Admin {
	
	public static  int rollno;
	public static String name,courses;

	private static Scanner sc=new Scanner(System.in);
	private static StudentScheduler studentScheduler = new StudentScheduler();
	
	public static void main(String[]args) {
		showMenu();
	}
	
	private static void showMenu() {
		int choice;
		while(true)
		{
			System.out.println("1. Add Student");
			System.out.println("2. Show all details of students");
			System.out.println("3. Show student details by RollNo");
			System.out.println("4.Show details by Course Name");
			System.out.println("5.Check for student count in courses");
			System.out.println("6. Exit");
			
			System.out.println("Enter your choice");
			choice=sc.nextInt();
		
			
			switch(choice) {
			
			case 1:addStudent();
			break;
			case 2:showAll();
			break;
			case 3:getDetails_rollno();
			break;
			case 4:getDetails_course();
			break;
			case 5:getCount();
			break;
			case 6: System.exit(0);
            
            default:System.out.println("You have entered wrong value");
			}
		}
	}	
	
	private static void addStudent() {
		System.out.println("Enter roll number");
		rollno=sc.nextInt();
		
		System.out.println("Enter name");
		 name = sc.next();
		
		System.out.println("Enter course");
		 courses = sc.next();
		
		System.out.println(studentScheduler.addStudent(rollno,name,courses));
}
	private static void showAll() {
		studentScheduler.showAll();
	}
	
	private static void getDetails_rollno() {
		System.out.println("Enter Roll number");
		rollno = sc.nextInt();
		System.out.println(studentScheduler.getDetails_RollNo(rollno));
		}
	private static void getDetails_course() {
		System.out.println("Enter the course you want to get the details");
		courses=sc.next();
		System.out.println(studentScheduler.getDetails_Course(courses));
	}
	private static void getCount() {
		System.out.println("Enter course name");
		courses=sc.next();
		System.out.println(studentScheduler.getCount(courses));
	}
	}
