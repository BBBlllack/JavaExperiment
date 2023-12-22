package com.shj.expers.exp4.second;

public class Tortoise extends Thread {
    int sleepTime = 0, liveLength = 0;

    public Tortoise(String name, int sleepTime, int liveLength) {
        super(name); // 设置线程的名字为name
        this.sleepTime = sleepTime;
        this.liveLength = liveLength;
        System.out.println(getName()+"进程创建");
    }

    @Override
    public void run() {
        System.out.println(getName()+"开始运行");
        while (true) {
            liveLength--;
            System.out.println("@_@");
            try {
                sleep(sleepTime);   // 让线程调用sleep()方法进入中断状态
                System.out.println(getName()+"进入中断状态");
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            if (liveLength <= 0) {
                System.out.println(getName() + "进入死亡状态\n"); //【代码3】 // 结束run()方法的语句
                break;
            }
        }
    }
}
