package com.shj.expers.exp2.fifth;

import com.shj.expers.exp2.fifth.Mypackage.Test_YMD;

public class YMD_2 {
    private String name;
    private Test_YMD birth;

    public static void main(String[] args) {
        YMD_2 a = new YMD_2("张弛", 1990, 1, 11);
        a.output();
    }

    public YMD_2(String n1, Test_YMD d1) {
        name = n1;
        birth = d1;
    }

    public YMD_2(String n1, int y, int m, int d) {
        this(n1, new Test_YMD(y, m, d));
    }

    public int age(){
        return Test_YMD.thisyear() - birth.year();
    }

    public void output(){
        System.out.println("姓名:" + name);
        System.out.println("出生日期:" + birth.toString());
        System.out.println("今年年龄:" + age());
    }
}
