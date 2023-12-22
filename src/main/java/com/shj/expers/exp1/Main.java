package com.shj.expers.exp1;
import com.shj.expers.exp2.first.MyDate;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 实验内容:
 * 1、编写一个 Java 应用程序，用户从键盘输入十名学生的信息，至少包括 姓名、年龄、出生年月日、java 课程实验成绩
 * 成绩使用浮点数，年龄使用整型，程序将输出年龄、java 课程实验成绩的平均值。
 * 提示:Scanner 对象调用 nextDouble()或 nextFloat()可以获取用户从键盘输 入的浮点数。
 * 2、使用 Arrays 类实现数组排序:使用 java.util 包中的 Arrays 类的类方法
 * public static void sort(double a[])可以把参数a指定的double类型数组按升序排序
 * ;public static void sort(double a[], int start , int end)可以把参数 a 指定的 double 类型数
 * 组中从位置 start 到 end 位置的值按升序排序。
 * 给定数组 int a[]={12,34,9,-23,45,6,90,123,19,45,34}; 从键盘读入一个整数， 使用折半查找判断该整数是否在这个数组中，并将结果输出。
 * *3、输出 100~200 之间的所有素数。
 * *4、采用 for 循环求 1 至 1000 之内的所有“完全数”。所谓“完全数”是 指一个数，恰好等于它的因子之和。例如，6 是一个完全数，因为 6 的因子为 1、 2、3，而 6=1+2+3。
 * *5、已知 XYZ+YZZ=532，其中 X、Y 和 Z 为数字，编程求出 X，Y 和 Z 的值。
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        int sumAge = 0;
        double sumMark = 0.0;

        int year;
        int month;
        int day;

        for (int i = 0; i < 2; i++) {
            Student stu = new Student();
            System.out.print("请输入用户名： ");
            stu.setUsername(scanner.next());

            System.out.print("请输入年龄: ");
            stu.setAge(scanner.nextInt());

            System.out.print("请输入出生年月日,每次输入换行: ");
            year = scanner.nextInt();
            month = scanner.nextInt();
            day = scanner.nextInt();

            MyDate myDate = new MyDate(year, month, day);
            boolean validDate = myDate.isValidDate();
            while (!validDate){
                System.out.println("日期不合法,请重新输入,每次输入换行");
                year = scanner.nextInt();
                month = scanner.nextInt();
                day = scanner.nextInt();
                myDate = new MyDate(year, month, day);
                validDate = myDate.isValidDate();
            }
            stu.setBirthday(String.valueOf(myDate.getYear()) + myDate.getMonth() + myDate.getDay());
            System.out.print("请输入java成绩: ");
            stu.setJavaMark(scanner.nextDouble());

            students.add(stu);
            // 成绩统计
            sumAge += stu.getAge();
            sumMark += stu.getJavaMark();
        }

        System.out.println(sumMark);
        System.out.println("平均年龄: " + sumAge / (double)students.size());
        System.out.println("平均成绩: " + sumMark / students.size());
        System.out.println(students);
    }

}
