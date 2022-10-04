package com.epam.rd.autotasks.figures;

class Circle extends Figure {
public Point a;
public double rad;

    public Circle(Point a, double rad) {
        this.a = a;
        this.rad = rad;
    }
    @Override
    public double area() {
        return Math.PI * rad * rad;
    }

    @Override
    public String pointsToString() {
        return a.toString();
    }

    @Override
    public Point leftmostPoint() {
        return new Point(a.getX() - rad, a.getY());
    }
    public String toString() {
        return this.getClass().getSimpleName() + "[" + pointsToString() + rad + "]";
    }
}
