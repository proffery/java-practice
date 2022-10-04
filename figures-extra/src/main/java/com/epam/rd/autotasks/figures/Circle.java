package com.epam.rd.autotasks.figures;

class Circle extends Figure {
    public Point a;

    public double diam;


    public Circle(Point a, double diam) {
        if (a == null || diam <= 0) {
            throw new IllegalArgumentException();
        }
        this.a = a;
        this.diam = diam;

        if (area() == 0) {
            throw new IllegalArgumentException();
        }
    }

    public double area() {
        double rad = diam / 2;
        return Math.PI * rad * rad;
    }

    public Point centroid(){
        return a;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (figure == null)
            return false;
        if (getClass() != figure.getClass())
            return false;
        Circle object = (Circle) figure;
        return deltaCompare(a.getX(), object.a.getX()) && deltaCompare(a.getY(), object.a.getY()) && deltaCompare(diam, object.diam);
    }
}