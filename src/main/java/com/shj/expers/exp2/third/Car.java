package com.shj.expers.exp2.third;

public class Car extends Vehicle{
    private int loader;

    public Car(int wheels, double weight, int loader) {
        super(wheels, weight);
        this.loader = loader;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Car: Loader = " + loader);
    }
}
