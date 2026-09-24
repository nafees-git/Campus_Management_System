package com.campus.service;
import com.campus.model.Student;

public class StudentService {
    //calculate total marks
    public int calculateTotal(Student student) {
        int[] Marks = student.getMarks();
        if (Marks == null) {
            return 0;
        }
        int total = 0;
        for (int mark : Marks) {
            total += mark;
        }
        return total;
    }
    //calculate average marks
    public double calculateAverage(Student student) {
        int[] Marks = student.getMarks();
        if (Marks == null || Marks.length == 0) {
            return 0.0;
        }
        int total = calculateTotal(student);
        return (double) total / Marks.length;
    }
    //find maximum marks
    public int findMax(Student student) {
        int[] Marks = student.getMarks();
        if (Marks == null || Marks.length == 0) {
            return 0;
        }
        int max = Marks[0];
        for (int mark : Marks) {
            if (mark > max) {
                max = mark;
            }
        }
        return max;
    }
    //find minimum marks
    public int findMin(int[] marks) {
        if (marks == null || marks.length == 0) {
            return 0;
        }
        int min = marks[0];
        for (int mark : marks) {
            if (mark < min) {
                min = mark;
            }
        }
        return min;
    }
    //grade based on marks
    public char grade(Student student) {
        int[] marks = student.getMarks();
        if (marks == null || marks.length == 0) {
            return 'F';
        }
        
        int average = (int) calculateAverage(student);
        if (average >= 90) {
            return 'A';
        } else if (average >= 80) {
            return 'B';
        }else if (average >= 70) {
            return 'C';
        }else if (average >= 60) {
            return 'D';          
        } else {
            return 'F';
        }
    }
    //pass or fail based on marks
    public boolean isPass(Student student) {
        int[] marks = student.getMarks();
        if (marks == null || marks.length == 0) {
            return false;
        }
        for (int mark : marks) {
            if (mark < 40) {
                return false;
            }
        }
        return true;
    }
    //display report card
    public void displayReportCard(Student student) {
        System.out.println("Report Card for Student ID: " + student.getStudentid());
        System.out.println("Student Name: " + student.getStudentname());
        System.out.println("Age: " + student.getAge());
        System.out.println("Department: " + student.getDepartment());
        System.out.print("Marks: "+java.util.Arrays.toString(student.getMarks()));
        System.out.println("\nTotal Marks: " + calculateTotal(student));
        System.out.println("Average Marks: " + calculateAverage(student));
        System.out.println("Maximum Marks: " + findMax(student));
        System.out.println("Minimum Marks: " + findMin(student.getMarks()));
        System.out.println("Grade: " + grade(student));
        System.out.println("Pass/Fail: " + (isPass(student) ? "Pass" : "Fail"));
    }   
}
