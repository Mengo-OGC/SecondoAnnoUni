package it.unibo.shapes.impl;

import it.unibo.shapes.api.Polygon;

public class Triangle implements Polygon {
    private final int edgeN = 3;
    private final double edgeA;
    private final double edgeB;
    private final double edgeC;

    public Triangle(
        final double A, 
        final double B,
        final double C
    ) {
        this.edgeA = A;
        this.edgeB = B;
        this.edgeC = C;
    }

    @Override
    public double area() {
        double s = (this.edgeA + this.edgeB + this.edgeC) / 2;
        return Math.sqrt(s * (s-this.edgeA)*(s-this.edgeB)*(s-this.edgeC));
    }

    @Override
    public double perimeter() {
        return this.edgeA + this.edgeB + this.edgeC;
    }

    @Override
    public int getEdgeCount() {
        return this.edgeN;
    }

}
