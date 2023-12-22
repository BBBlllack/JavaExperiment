package com.shj.expers.exp4.second;

public class ThreadExample {
    public static void main(String[] args) {
        Rabit rabit;
        rabit =new Rabit("兔子",2,30);  // 新建线程rabit
        Tortoise tortoise =new Tortoise("乌龟",2,30);  // 新建线程tortoise
        tortoise.start();  // 启动线程tortoise
        rabit.start(); //启动线程rabit
    }
}
