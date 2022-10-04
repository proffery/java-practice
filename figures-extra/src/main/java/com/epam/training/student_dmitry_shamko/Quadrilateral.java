package com.epam.training.student_dmitry_shamko;

class Quadrilateral extends Figure {
    public Point a;
    public Point b;
    public Point c;
    public Point d;
    public Quadrilateral(Point a, Point b, Point c, Point d) {
        if (a == null || b == null || c == null || d == null) {
            throw new IllegalArgumentException();
        }

        if (deltaCompare (a.getX(), b.getX()) && deltaCompare (a.getY(), b.getY()) ||
                deltaCompare (b.getX(), c.getX()) && deltaCompare (b.getY(), c.getY()) ||
                deltaCompare (c.getX(), d.getX()) && deltaCompare (c.getY(), d.getY()) ||
                deltaCompare (d.getX(), a.getX()) && deltaCompare (d.getY(), a.getY()) ||
                deltaCompare (a.getX(), c.getX()) && deltaCompare (a.getY(), c.getY()) ||
                deltaCompare (d.getX(), b.getX()) && deltaCompare (d.getY(), b.getY())) {
            throw new IllegalArgumentException();
        }
        if ((a.getX() == b.getX() && b.getX() == c.getX()) || (a.getY() == b.getY() && b.getY() == c.getY()) ||
                (b.getX() == c.getX() && c.getX() == d.getX()) || (b.getY() == c.getY() && c.getY() == d.getY()) ||
                (c.getX() == d.getX() && d.getX() == a.getX()) || (c.getY() == d.getY() && d.getY() == a.getY()) ||
                (d.getX() == a.getX() && a.getX() == b.getX()) || (d.getY() == a.getY() && a.getY() == b.getY())) {
            throw new IllegalArgumentException();
        }

        if (deltaCompare (((c.getX() - a.getX()) / (b.getX() - a.getX())), ((c.getY() - a.getY()) / (b.getY() - a.getY())))) {
            throw new IllegalArgumentException();
        }
        if (deltaCompare (((d.getX() - b.getX()) / (c.getX() - b.getX())), ((d.getY() - b.getY()) / (c.getY() - b.getY())))) {
            throw new IllegalArgumentException();
        }
        if (deltaCompare (((a.getX() - c.getX()) / (d.getX() - c.getX())), ((a.getY() - c.getY()) / (d.getY() - c.getY())))) {
            throw new IllegalArgumentException();
        }
        if (deltaCompare (((b.getX() - d.getX()) / (a.getX() - d.getX())), ((b.getY() - d.getY()) / (a.getY() - d.getY())))) {
            throw new IllegalArgumentException();
        }
        if (deltaCompare(Math.abs((a.getX() - b.getX()) * (a.getY() + b.getY()) + (b.getX() - c.getX()) * (b.getY() + c.getY()) +
                (c.getX() - d.getX()) * (c.getY() + d.getY()) + (d.getX() - a.getX()) * (d.getY() + a.getY())), 0)) {
            throw new IllegalArgumentException();
        }

        if (((c.getX() - b.getX()) * (a.getY() - b.getY()) - ((c.getY() - b.getY()) * (a.getX() - b.getX()))) *
                ((d.getX() - b.getX()) * (a.getY() - b.getY()) - ((d.getY() - b.getY()) * (a.getX() - b.getX()))) < 0) {
            throw new IllegalArgumentException();
        }
        if (((a.getX() - c.getX()) * (b.getY() - c.getY()) - ((a.getY() - c.getY()) * (b.getX() - c.getX()))) *
                ((a.getX() - c.getX()) * (b.getY() - c.getY()) - ((a.getY() - c.getY()) * (b.getX() - c.getX()))) < 0) {
            throw new IllegalArgumentException();
        }
        if (((a.getX() - d.getX()) * (c.getY() - d.getY()) - ((a.getY() - d.getY()) * (c.getX() - d.getX()))) *
                ((b.getX() - d.getX()) * (c.getY() - d.getY()) - ((b.getY() - d.getY()) * (c.getX() - d.getX()))) < 0) {
            throw new IllegalArgumentException();
        }
        if (((b.getX() - a.getX()) * (d.getY() - a.getY()) - ((b.getY() - a.getY()) * (d.getX() - a.getX()))) *
                ((c.getX() - a.getX()) * (d.getY() - a.getY()) - ((c.getY() - a.getY()) * (d.getX() - a.getX()))) < 0) {
            throw new IllegalArgumentException();
        }

        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public double area() {
        return (Math.abs((a.getX() - b.getX()) * (a.getY() + b.getY()) + (b.getX() - c.getX()) * (b.getY() + c.getY()) +
                (c.getX() - d.getX()) * (c.getY() + d.getY()) + (d.getX() - a.getX()) * (d.getY() + a.getY()))) / 2;
    }

    public Point centroid(){
        Triangle triangle1 = new Triangle(new Point(a.getX(),a.getY()), new Point(b.getX(), b.getY()), new Point(d.getX(), d.getY()));
        Triangle triangle2 = new Triangle(new Point(b.getX(),b.getY()), new Point(c.getX(), c.getY()), new Point(d.getX(), d.getY()));
        Point c1 = triangle1.centroid();
        Point c2 = triangle2.centroid();
        double x = ((c1.getX() * triangle1.area()) + (c2.getX() * triangle2.area())) / area();
        double y = ((c1.getY() * triangle1.area()) + (c2.getY() * triangle2.area())) / area();
        return new Point(x, y);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (figure == null)
            return false;
        if (getClass() != figure.getClass())
            return false;
        Quadrilateral object = (Quadrilateral) figure;
        return (deltaCompare(a.getX(), object.a.getX()) && deltaCompare(a.getY(), object.a.getY()) || deltaCompare(a.getX(), object.b.getX()) && deltaCompare(a.getY(), object.b.getY()) ||
                deltaCompare(a.getX(), object.c.getX()) && deltaCompare(a.getY(), object.c.getY()) || deltaCompare(a.getX(), object.d.getX()) && deltaCompare(a.getY(), object.d.getY())) &&
                (deltaCompare(b.getX(), object.b.getX()) && deltaCompare(b.getY(), object.b.getY()) || deltaCompare(b.getX(), object.a.getX()) && deltaCompare(b.getY(), object.a.getY()) ||
                        deltaCompare(b.getX(), object.c.getX()) && deltaCompare(b.getY(), object.c.getY()) || deltaCompare(b.getX(), object.d.getX()) && deltaCompare(b.getY(), object.d.getY())) &&
                (deltaCompare(c.getX(), object.c.getX()) && deltaCompare(c.getY(), object.c.getY()) || deltaCompare(c.getX(), object.a.getX()) && deltaCompare(c.getY(), object.a.getY()) ||
                        deltaCompare(c.getX(), object.b.getX()) && deltaCompare(c.getY(), object.b.getY()) || deltaCompare(c.getX(), object.d.getX()) && deltaCompare(c.getY(), object.d.getY())) &&
                (deltaCompare(d.getX(), object.d.getX()) && deltaCompare(d.getY(), object.d.getY()) || deltaCompare(d.getX(), object.a.getX()) && deltaCompare(d.getY(), object.a.getY()) ||
                        deltaCompare(d.getX(), object.c.getX()) && deltaCompare(d.getY(), object.c.getY()) || deltaCompare(d.getX(), object.b.getX()) && deltaCompare(d.getY(), object.b.getY()));
    }
}