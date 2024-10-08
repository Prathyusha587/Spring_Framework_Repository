package com.java.springormhibernate.SpringORMHibernate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.springormhibernate.SpringORMHibernate.dao.StudentDao;
import com.java.springormhibernate.SpringORMHibernate.entities.Student;

public class App {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
		// the below code is for a menu driven application to perform CRUD operations
		// using spring orm
		// BufferedReader to read user choice
        System.out.println("Welcome to Student Management System's Basic Operations!! ");
        System.out.println();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// declare a boolean var to break the loop after choice 6
		System.out.println("Please choose any of the below options!!");
		System.out.println();
		boolean go = true;
		while (go) {
			
			System.out.println("Press 1 to add a new student!");
			System.out.println("Press 2 to display all students!");
			System.out.println("Press 3 to get details of a single student!");
			System.out.println("Press 4 to delete a student!");
			System.out.println("Press 5 to update a new student!");
			System.out.println("Press 6 to exit. ");

			try {

				int input = Integer.parseInt(br.readLine());
				// switch case to match user input in menu
				switch (input) {
				case 1:
					// Add a new student
					System.out.println("Enter user id:");
					int uId = Integer.parseInt(br.readLine());

					System.out.println("Enter user name:");
					String uName = br.readLine();

					System.out.println("Enter user city:");
					String uCity = br.readLine();

					// set user input values to student objects
					Student s = new Student();
					s.setStudentId(uId);
					s.setStudentName(uName);
					s.setStudentCity(uCity);

					int r = studentDao.insert(s);
					System.out.println("Student with id:" + r +  " added successfully!!");
					System.out.println();// newline

					break;

				case 2:
					// displays all students
					List<Student> allStudents = studentDao.getAllStudents();
					for (Student st : allStudents) {
						System.out.println("Student Id: " + st.getStudentId());
						System.out.println("Student Name: " + st.getStudentName());
						System.out.println("Student City: " + st.getStudentCity());
						System.out.println("------------------------------------");

					}

					break;

				case 3:
					// fetch details of a single student
					System.out.println("Enter user id: ");
					int userId = Integer.parseInt(br.readLine());
					Student student = studentDao.getStudent(userId);

					System.out.println("Details of the student with id: " + userId + " are");
					System.out.println("Student Id: " + student.getStudentId());
					System.out.println("Student Name: " + student.getStudentName());
					System.out.println("Student City: " + student.getStudentCity());
					System.out.println("-------------------------------------------");
					break;

				case 4:
					// delete a student
					System.out.println("Enter user id: ");
					int user_Id = Integer.parseInt(br.readLine());
					studentDao.deleteStudent(user_Id);
					System.out.println("Student with id:" + user_Id + " deleted successfully!!");
					System.out.println("-----------------------------------");
					break;

				case 5:
					// Update a student
					System.out.println("Enter ID: ");
					int u_Id = Integer.parseInt(br.readLine());
					System.out.println("Updated name: ");
					String u_Name = br.readLine();
					System.out.println("Updated City: ");
					String u_City = br.readLine();
					studentDao.updateStudent(u_Id, u_Name, u_City);
					System.out.println("Student with ID:" + u_Id + " is updated...!");
					break;

				case 6:
					// exit switch case - invalid choice
					go = false;
					break;

				}

			} catch (Exception e) {
				System.out.println("You have entered an invalid input. Please try again!! ");
				e.getMessage();
			}
		}
		// code that displays when input=6
		System.out.println("Thank you for using my application.");
	}
}
