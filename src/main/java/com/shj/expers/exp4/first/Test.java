package com.shj.expers.exp4.first;

public class Test {
    public static void main(String[] args) {
        // even使用err打印, 方便区别
        // 同时为线程添加sleep方法, 便于观察交替效果
        OddCounter oddCounter = new OddCounter();
        EvenCounter evenCounter = new EvenCounter();

        oddCounter.setName("OddThread");
        evenCounter.setName("EvenThread");

        oddCounter.start();
        evenCounter.start();
    }
}
