package com.shj.expers.exp4.third;

public class SellTicket {
    public static void main(String[] args) {
        WaitedCustomer tempObject = new WaitedCustomer();
        BuyThread t1 = new BuyThread(tempObject);
        t1.setName("赵");
        BuyThread t2 = new BuyThread(tempObject);
        t2.setName("钱");
        BuyThread t3 = new BuyThread(tempObject);
        t3.setName("孙");
        BuyThread t4 = new BuyThread(tempObject);
        t4.setName("李");
        BuyThread t5 = new BuyThread(tempObject);
        t5.setName("周");

        t1.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        t2.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        t3.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        t4.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }

        t5.start();
    }
}
