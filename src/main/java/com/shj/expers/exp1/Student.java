package com.shj.expers.exp1;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 姓名、年龄、出生年月日、java 课程实验成绩
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String username;
    private int age;
    private String birthday;
    private double javaMark;
}
