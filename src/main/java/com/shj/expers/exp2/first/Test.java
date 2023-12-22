package com.shj.expers.exp2.first;

import java.util.Scanner;

public class Test {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static void main(String[] args) {
        boolean flag = true;
        while (flag){
            MyDate myDate = new MyDate();
            System.out.print("请输入年:");
            myDate.setYear(SCANNER.nextInt());
            System.out.print("请输入月:");
            myDate.setMonth(SCANNER.nextInt());
            System.out.print("请输入日:");
            myDate.setDay(SCANNER.nextInt());
            flag = !myDate.isValidDate();
            if (flag){
                System.out.println("日期不合法!");
            }else {
                System.out.println("日期合法!");
                break;
            }
        }
    }
}
