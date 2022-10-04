package com.epam.rd.autotasks.figures;
import static java.lang.Math.*;
class Triangle extends Figure {
    private final Point a;
    private final Point b;
    private final Point c;
    public Triangle(Point a, Point b, Point c) {
        if (a == null || b == null || c == null) {
            throw new IllegalArgumentException();
        }


        this.a = a;
        this.b = b;
        this.c = c;

        if (area() == 0) {
            throw new IllegalArgumentException();
        }
    }

    public double area() {
        return abs((b.getX() - a.getX()) * (c.getY() - a.getY()) - (c.getX() - a.getX()) * (b.getY() - a.getY()))/ 2;
    }

    public Point centroid(){
        double x = (a.getX() + b.getX() + c.getX())/3;
        double y = (a.getY() + b.getY() + c.getY())/3;
        return new Point(x, y);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (figure == null)
            return false;
        if (getClass() != figure.getClass())
            return false;
        Triangle object = (Triangle) figure;
        return deltaCompare(a.getX(), object.a.getX()) && deltaCompare(a.getY(), object.a.getY()) &&
                deltaCompare(b.getX(), object.b.getX()) && deltaCompare(b.getY(), object.b.getY()) &&
                deltaCompare(c.getX(), object.c.getX()) && deltaCompare(c.getY(), object.c.getY());
    }
}