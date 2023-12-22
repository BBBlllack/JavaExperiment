package com.shj.expers.exp3.avg;

public class Avg1 implements Average{
    @Override
    public double getAvgMark(double[] marks) {
        double sum = 0;
        for (double mark : marks) {
            sum += mark;
        }
        return sum / marks.length;
    }
}
