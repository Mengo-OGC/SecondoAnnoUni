package it.unibo.shapes.impl;
import it.unibo.shapes.api.*;

public class Circle implements Shape {
    private final double radius;

    public Circle(final double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * this.radius * this.radius;
    }

    @Override
    public double perimeter() {
        return Math.PI * this.radius * 2;
    }
    
}