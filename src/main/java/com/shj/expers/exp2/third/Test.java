package com.shj.expers.exp2.third;

public class Test {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle(4, 1500.0);
        vehicle.displayInfo();

        Car car = new Car(4, 1200.0, 5);
        car.displayInfo();

        Truck truck = new Truck(6, 5000.0, 2, 8000.0);
        truck.displayInfo();
    }
}
