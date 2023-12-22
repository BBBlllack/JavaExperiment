package com.shj.expers.exp2.fifth.Mypackage;

import java.util.*;

public class Test_YMD {
    private int year, month, day;

    public static void main(String[] args) {

    }

    public Test_YMD(int y, int m, int d) {
        year = y;
        month = (((m >= 1) && (m <= 12)) ? m : 1);
        day = ((d >= 1) && (d <= 31)) ? d : 1;
    }

    public Test_YMD(){
        this(0,0,0);
    }

    public static int thisyear(){
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    public int year(){
        return year;
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }
}
