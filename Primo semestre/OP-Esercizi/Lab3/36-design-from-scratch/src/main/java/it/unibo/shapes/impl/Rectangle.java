package it.unibo.shapes.impl;

import it.unibo.shapes.api.Polygon;

public class Rectangle implements Polygon {
    private final int edgeN = 4;
    private final double edgeBase;
    private final double edgeheigth;

    public Rectangle(final double base, final double heigth) {
        this.edgeBase = base;
        this.edgeheigth = heigth;
    }

    @Override
    public double area() {
        return this.edgeBase * this.edgeheigth;
    }

    @Override
    public double perimeter() {
        return 2 * this.edgeBase + 2 * this.edgeheigth;
    }

    @Override
    public int getEdgeCount() {
        return this.edgeN;
    }

}
