package com.shj.expers.exp2.second;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Student extends Person{
    private String studentId; // 学号
    private String admissionDate; // 入学时间
    private double gpa; // 绩点

    public Student(String name, String idCard, String studentId, String admissionDate) {
        super(name, idCard);
        this.studentId = studentId;
        this.admissionDate = admissionDate;
        this.gpa = 0.0;
    }

    public void setGPA(double gpa) {
        if (gpa >= 0 && gpa <= 4.0) {
            this.gpa = gpa;
            System.out.println("GPA set to: " + gpa);
        }
    }

    public void showDetails() {
        super.showDetails();
        System.out.println("Student ID: " + studentId);
        System.out.println("Admission Date: " + admissionDate);
        System.out.println("GPA: " + gpa);
    }

}
