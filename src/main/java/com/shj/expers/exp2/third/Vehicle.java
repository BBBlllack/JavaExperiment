package com.shj.expers.exp2.third;

public class Vehicle {
    private int wheels;
    private double weight;

    public Vehicle(int wheels, double weight) {
        this.wheels = wheels;
        this.weight = weight;
    }

    public void displayInfo() {
        System.out.println("Vehicle: Wheels = " + wheels + ", Weight = " + weight);
    }
}
