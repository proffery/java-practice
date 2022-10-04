package com.epam.training.student_dmitry_shamko;

import static java.lang.Math.*;

class Segment {

    public Point start;
    public Point end;
    public Segment(Point start, Point end) {

        if (start == null || end == null || start.getX() == end.getX() && start.getY() == end.getY()) {
            throw new IllegalArgumentException();
        }
        this.start = start;
        this.end = end;
    }

    double length() {
        return sqrt(pow(end.getX() - start.getX(),2) + pow(end.getY() - start.getY(),2));
    }

    Point middle() {
        double x = (end.getX() + start.getX())/2;
        double y = (end.getY() + start.getY())/2;
        return new Point(x,y);
    }

    Point intersection(Segment another) {
        double x1,x2,x3,x4,y1,y2,y3,y4,k1,k2;
            x1 = start.getX();
            x2 = end.getX();
            x3 = another.start.getX();
            x4 = another.end.getX();
            y1 = start.getY();
            y2 = end.getY();
            y3 = another.start.getY();
            y4 = another.end.getY();

        if (y2 == y1)
            k1 = 0;
        else
            k1 = ((y2 - y1) / (x2 - x1));

        if (y3 == y4)
            k2 = 0;
        else
            k2 = ((y4 - y3) / (x4 - x3));

        if (k1 % k2 == 0 || k2 % k1 == 0 || k1 == k2) {
            return null;
        }
         else {
            double b1 = y1 - (k1 * x1);
            double b2 = y3 - (k2 * x3);
            double x = ((b2 - b1) / (k1 - k2));
            double y = ((k1 * x) + b1);
            return new Point(x, y);
        }
    }
}
