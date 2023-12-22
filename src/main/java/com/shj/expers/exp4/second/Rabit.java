package com.shj.expers.exp4.second;

public class Rabit extends Thread {
    int sleepTime = 0, liveLength = 0;

    public Rabit(String name, int sleepTime, int liveLength) {
        super(name); // 调用父类构造函数，设置线程的名字为name
        this.sleepTime = sleepTime;
        this.liveLength = liveLength;
        System.out.println(getName()+"进程创建");
    }

    @Override
    public void run() {
        System.out.println(getName()+"开始运行");
        while (true) {
            liveLength--;
            System.out.println("*_*");
            try {
                sleep(sleepTime);
                System.out.println(getName()+"进入中断状态");
            } catch (InterruptedException e) {
            }
            if (liveLength <= 0) {
                System.out.println(getName() + "进入死亡状态\n");
                break;
            }
        }
    }
}
