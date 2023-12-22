package com.shj.expers.exp2.forth;

public class Rectangle extends Coordinates implements Shape{
    double width;
    double height;

    Rectangle(int x, int y, double width, double height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
}
