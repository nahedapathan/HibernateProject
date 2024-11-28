package com.mainApp;

import java.util.Scanner;

import com.service.StudentService;

public class main {

	 public static void main(String[] args) {
	        StudentService studentService = new StudentService();
	        Scanner sc = new Scanner(System.in);
	        boolean exit = false;

	        while (!exit) {
	            System.out.println("*** Welcome to Student Management System ***");
	            System.out.println("1. Add Student Data");
	            System.out.println("2. View All Student Data");
	            System.out.println("3. Search Student by ID");
	            System.out.println("4. Update Student Data");
	            System.out.println("5. Delete Student Data");
	            System.out.println("6. Exit System");

	            System.out.print("Enter your choice: ");
	            int choice = sc.nextInt();

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter Student Name: ");
	                    sc.nextLine(); // consume newline
	                    String name = sc.nextLine();
	                    System.out.print("Enter Student Email: ");
	                    String email = sc.nextLine();
	                    System.out.print("Enter Student Age: ");
	                    int age = sc.nextInt();
	                    System.out.print("Enter Student Grade: ");
	                    sc.nextLine(); // consume newline
	                    String grade = sc.nextLine();

	                    studentService.createStudent(name, email, age, grade);
	                    break;

	                case 2:
	                    studentService.getStudentAll();
	                    break;

	                case 3:
	                    System.out.print("Enter Student ID: ");
	                    int id = sc.nextInt();
	                    studentService.getStudentById(id);
	                    break;

	                case 4:
	                    System.out.print("Enter Student ID to Update: ");
	                    int updateId = sc.nextInt();
	                    sc.nextLine(); // consume newline
	                    System.out.print("Enter New Name: ");
	                    String newName = sc.nextLine();
	                    System.out.print("Enter New Email: ");
	                    String newEmail = sc.nextLine();
	                    System.out.print("Enter New Age: ");
	                    int newAge = sc.nextInt();
	                    System.out.print("Enter New Grade: ");
	                    sc.nextLine(); // consume newline
	                    String newGrade = sc.nextLine();

	                    studentService.updateStudent(updateId, newName, newEmail, newAge, newGrade);
	                    break;

	                case 5:
	                    System.out.print("Enter Student ID to Delete: ");
	                    int deleteId = sc.nextInt();
	                    studentService.deleteStudent(deleteId);
	                    break;

	                case 6:
	                    exit = true;
	                    System.out.println("System Exited. Goodbye!");
	                    break;

	                default:
	                    System.out.println("Invalid Choice. Please try again.");
	                    break;
	            }
	        }
	        sc.close();
	    }
}
