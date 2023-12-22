package com.shj.expers.exp2.forth;

public class MainDemo {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(0, 0, 5, 3);
        Circle circle = new Circle(0, 0, 4);
        Triangle triangle = new Triangle(0, 0, 3, 4, 5);

        System.out.println("Rectangle Area: " + rectangle.getArea());
        System.out.println("Rectangle Perimeter: " + rectangle.getPerimeter());

        System.out.println("Circle Area: " + circle.getArea());
        System.out.println("Circle Perimeter: " + circle.getPerimeter());

        System.out.println("Triangle Area: " + triangle.getArea());
        System.out.println("Triangle Perimeter: " + triangle.getPerimeter());
    }
}
