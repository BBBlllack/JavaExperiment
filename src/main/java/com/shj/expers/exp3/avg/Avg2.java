package com.shj.expers.exp3.avg;

public class Avg2 implements Average{
    @Override
    public double getAvgMark(double[] marks) {
        // 当输入数据小于3个抛出异常
        if (marks.length < 3) {
            throw new IllegalArgumentException("There must be at least 3 marks.");
        }

        double minMark = marks[0];
        double maxMark = marks[0];
        double sum = 0;

        for (double mark : marks) {
            sum += mark;
            if (mark < minMark) {
                minMark = mark;
            }
            if (mark > maxMark) {
                maxMark = mark;
            }
        }

        return (sum - minMark - maxMark) / (marks.length - 2);
    }
}
