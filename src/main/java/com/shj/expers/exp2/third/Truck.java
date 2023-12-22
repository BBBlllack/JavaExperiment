package com.shj.expers.exp2.third;

public class Truck extends Car{
    private double payload;

    public Truck(int wheels, double weight, int loader, double payload) {
        super(wheels, weight, loader);
        this.payload = payload;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Truck: Payload = " + payload);
    }
}
