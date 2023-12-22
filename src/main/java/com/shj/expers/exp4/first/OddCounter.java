package com.shj.expers.exp4.first;

public class OddCounter extends Thread{
    private static int oddCount = 0;
    private static int oddSum = 0;

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(getName() + "-Odd:" + i);
                oddCount++;
                oddSum += i;
                try {
                    OddCounter.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println("奇数个数：" + oddCount);
        System.out.println("奇数和：" + oddSum);
    }
}
