package com.epam.rd.autotasks.figures;
class Quadrilateral extends Figure {
    public Point a;
    public Point b;
    public Point c;
    public Point d;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public double area() {
        return (Math.abs((a.getX() - b.getX()) * (a.getY() + b.getY()) + (b.getX() - c.getX()) * (b.getY() + c.getY()) +
                (c.getX() - d.getX()) * (c.getY() + d.getY()) + (d.getX() - a.getX()) * (d.getY() + a.getY()))) / 2;
    }

    @Override
    public String pointsToString() {
        return a.toString() + b.toString() + c.toString() + d.toString();
    }

    @Override
    public Point leftmostPoint() {
        if (a.getX() <= b.getX() && a.getX() <= c.getX() && a.getX() <= d.getX()) {
            return a;
        }
        else if (b.getX() <= c.getX() && b.getX() <= a.getX() && b.getX() <= d.getX()) {
            return b;
        }
        else if (c.getX() <= a.getX() && c.getX() <= b.getX() && c.getX() <= d.getX()) {
            return c;
        }
        return d;
    }
}
