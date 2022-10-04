package com.epam.training.student_dmitry_shamko;

import static java.lang.Math.*;

class Triangle extends Figure {
    public Point a;
    public Point b;
    public Point c;

    public Triangle(Point a, Point b, Point c) {

        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area() {
        Segment one = new Segment(a, b);
        Segment two = new Segment(b, c);
        Segment three = new Segment(c, a);

        return sqrt(pow(pow(one.length(),2) + pow(two.length(),2) + pow(three.length(),2),2) -
                2 * (pow(one.length(),4) + pow(two.length(),4) + pow(three.length(),4))) / 4;
    }

    @Override
    public String pointsToString() {
        return a.toString() + b.toString() + c.toString();
    }

    @Override
    public Point leftmostPoint() {
        if (a.getX() <= b.getX() && a.getX() <= c.getX()) {
            return a;
        }
        else if (b.getX() <= c.getX() && b.getX() <= a.getX()) {
            return b;
        }
        return c;
    }
}
