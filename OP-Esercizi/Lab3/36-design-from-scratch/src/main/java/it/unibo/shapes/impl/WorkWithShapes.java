package it.unibo.shapes.impl;

public class WorkWithShapes {

    public static void main(String[] args) {
        Circle c = new Circle(10);
        System.out.println("Area: " + c.area() + ", Perimetro: " + c.perimeter());
        Rectangle re = new Rectangle(10, 12.3);
        System.out.println("Area: " + re.area() + ", Perimetro: " + re.perimeter());
        Square s = new Square(22);
        System.out.println("Area: " + s.area() + ", Perimetro: " + s.perimeter());
        Triangle t = new Triangle(10, 10, 2);
        System.out.println("Area: " + t.area() + ", Perimetro: " + t.perimeter());
    }
}
