package com.shj.expers.exp4.first;

public class EvenCounter extends Thread{
    private static int evenCount = 0;
    private static int evenSum = 0;

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.err.println(getName() + "-Even:" + i);
                evenCount++;
                evenSum += i;
                try {
                    EvenCounter.sleep(20);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.err.println("偶数个数:" + evenCount);
        System.err.println("偶数和" + evenSum);
    }
}
