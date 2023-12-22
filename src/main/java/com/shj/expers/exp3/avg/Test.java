package com.shj.expers.exp3.avg;

import com.shj.expers.exp1.Student;
import com.shj.expers.exp2.first.MyDate;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        int sumAge = 0;
        double sumMark = 0.0;
        double[] marks = new double[3];
        int year;
        int month;
        int day;
        try {
            for (int i = 0; i < 3; i++) {
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
                while (!validDate) {
                    System.out.println("日期不合法,请重新输入,每次输入换行");
                    year = scanner.nextInt();
                    month = scanner.nextInt();
                    day = scanner.nextInt();
                    myDate = new MyDate(year, month, day);
                    validDate = myDate.isValidDate();
                }

                boolean markFlag = true;
                while (markFlag){
                    System.out.print("请输入java成绩: ");
                    double mark = scanner.nextDouble();
                    if (mark < 0 || mark > 100){
                        System.out.println("输入不合法,成绩不能小于0或大于100!");
                        continue;
                    }
                    stu.setJavaMark(mark);
                    markFlag = false;
                    marks[i] = stu.getJavaMark();
                }

                students.add(stu);
                // 成绩统计
                sumAge += stu.getAge();
                sumMark += stu.getJavaMark();

            }

        }catch (InputMismatchException e){
            System.err.println("输入的数据不合法!");
        }catch (Exception e){
            System.err.println("未知错误!");
            e.printStackTrace();
        }

        Avg1 avg1 = new Avg1();
        Avg2 avg2 = new Avg2();

        System.out.println(sumMark);
        System.out.println("平均年龄: " + sumAge / (double) students.size());
        System.out.println("平均成绩1: " + avg1.getAvgMark(marks));
        System.out.println("平均成绩2: " + avg2.getAvgMark(marks));
        System.out.println( "students:" + students);

    }
}