package com.shj.expers.ThreadTest;

import org.apache.ibatis.javassist.compiler.ast.Variable;

public class SellTicket extends Thread{

    static int tickets = 0;
    final static Object lock = new Object();

    static int mutex = 1;

    @Override
    public void run() {

        while (true){
//            synchronized (lock) {
                if (tickets < 100 && mutex >= 1){
                    mutex--;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    tickets++;
                    System.out.println( getName() + "-正在卖第" + tickets + "张票");
                }else{
                    break;
                }
                mutex++;
//            }
        }
    }
}
