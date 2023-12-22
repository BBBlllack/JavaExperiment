package com.shj.expers.exp4.third;

public class WaitedCustomer {
    private int five = 1, ten = 0, twenty = 0;

    public synchronized void buyticket(int money, int ticketNeed) {

        if (money == 5) {//周只要拿钱买票就可以买到
            notifyAll();
            five++;
            System.out.println(Thread.currentThread().getName() + "用5元买了1张票，买票成功");
        } else if (money == 10) {
            if (ticketNeed == 1) {//孙买票的情况
                if (five >= 1) {
                    notifyAll();
                    five--;
                    ten++;
                    System.out.println(Thread.currentThread().getName() + "用10元买了1张票，买票成功");

                }
            } else if (ticketNeed == 2) {//李买票的情况
                notifyAll();
                ten++;
                System.out.println(Thread.currentThread().getName() + "用10元买了2张票，买票成功");

            }

        } else {
            while (money == 20) {

                if (ticketNeed == 1) {//钱买票的情况
                    if (five >= 1 && ten >= 1) {
                        ten--;
                        five--;
                        twenty++;
                        System.out.println(Thread.currentThread().getName() + "用20元买了1张票，买票成功");
                        Thread.currentThread().stop();

                    } else {
                        System.out.println(Thread.currentThread().getName() + "在等待买票");
                        try {
                            wait();

                        } catch (InterruptedException e) {
                        }
                    }

                }
                if (ticketNeed == 2) {
                    if (ten >= 1) {//赵买票的情况
                        ten--;
                        twenty++;
                        System.out.println(Thread.currentThread().getName() + "用20元买了2张票，买票成功");
                        Thread.currentThread().stop();
                    } else {
                        System.out.println(Thread.currentThread().getName() + "在等待买票");
                        try {
                            wait();

                        } catch (InterruptedException e) {
                        }
                    }
                }
            }

        }

    }
}

