package com.shj.expers.exp3;

import java.util.Scanner;

public class MyExceptionTest{

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("输入一个字符串: ");
        String s = scanner.next();
        try {
            if (s.equals("XYZ"))
                throw new MyException();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static class MyException extends Exception{
        public MyException(){
            super("This is a XYZ");
        }
    }
}
