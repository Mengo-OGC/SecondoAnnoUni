package it.unibo.shapes.impl;

import it.unibo.shapes.api.Polygon;

public class Square implements Polygon {
    private final int edgeN = 4;
    private final double edgeLen;

    public Square (final double edgeLen) {
        this.edgeLen = edgeLen;
    }

    @Override
    public double area() {
        return edgeLen * edgeLen;
    }

    @Override
    public double perimeter() {
        return edgeLen * edgeN;
    }

    @Override
    public int getEdgeCount() {
        return this.edgeN;
    }
    
}
