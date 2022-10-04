package com.epam.rd.autotasks.triangle;
import static java.lang.Math.*;

class Segment {

    public Point start;
    public Point end;

    public Segment(Point start, Point end) {

        if (start == null || end == null || start.equals(end)) {
            throw new IllegalArgumentException();
        }
        if (start.getX() == end.getX() && start.getY() == end.getY()) {
            throw new IllegalArgumentException();
        }
        this.start = start;
        this.end = end;
    }

    double length() {
        return sqrt(pow(end.getX() - start.getX(), 2) + pow(end.getY() - start.getY(), 2));
    }
}
