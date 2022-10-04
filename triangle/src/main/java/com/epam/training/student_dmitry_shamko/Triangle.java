package com.epam.training.student_dmitry_shamko;
import static java.lang.Math.*;
class Triangle {
    private final Point a;
    private final Point b;
    private final Point c;
    public Triangle(Point a, Point b, Point c) {
        if (a == null || b == null || c == null) {
            throw new IllegalArgumentException();
        }
        Segment one = new Segment(a, b);
        Segment two = new Segment(b, c);
        Segment three = new Segment(c, a);

        if (one.length() >= two.length() + three.length() ||
            two.length() >= one.length() + three.length() ||
            three.length() >= one.length() + two.length()) {
                throw new IllegalArgumentException();
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area() {
        Segment one = new Segment(a, b);
        Segment two = new Segment(b, c);
        Segment three = new Segment(c, a);
        return sqrt(pow(pow(one.length(),2) + pow(two.length(),2) + pow(three.length(),2),2) -
                2 * (pow(one.length(),4) + pow(two.length(),4) + pow(three.length(),4))) / 4;
    }

    public Point centroid(){
        double x = (a.getX()+b.getX()+c.getX())/3;
        double y = (a.getY()+b.getY()+c.getY())/3;
        return new Point(x,y);
    }

}
