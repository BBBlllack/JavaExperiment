package com.shj.expers.ThreadTest;

public class Test1 {
    public static void main(String[] args) {
        SellTicket s1 = new SellTicket();
        SellTicket s2 = new SellTicket();

        s1.start();
        s2.start();
    }

    void xialou(){}
}
