package com.campus.app;

import java.util.Scanner;
import com.campus.model.Student;
import com.campus.service.StudentService;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input student details
        System.out.print("Enter student ID: "); 
        int studentid = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        System.out.print("Enter student name: ");  
        String studentname = scanner.nextLine();

        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        System.out.print("Enter student department: ");
        String department = scanner.nextLine();
        System.out.println("number of subjects: ");
        int numSubjects = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        int[] marks = new int[numSubjects];
        System.out.println("Enter marks for " + numSubjects + " subjects: ");
        for (int i = 0; i < numSubjects; i++) {
            marks[i] = scanner.nextInt();
            scanner.nextLine(); // consume the newline character
        }
        Student student = new Student(studentid, studentname, age, department, marks);
        student.displayStudentInfo(true);
        Student.displayStudentCount();
        StudentService studentService = new StudentService();
        studentService.displayReportCard(student);
        scanner.close();
    }
    
}
