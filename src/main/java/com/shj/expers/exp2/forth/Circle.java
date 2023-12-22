package com.shj.expers.exp2.forth;

public class Circle extends Coordinates implements Shape{
    double radius;

    Circle(int x, int y, double radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}
