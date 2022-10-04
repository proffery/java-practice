package com.epam.rd.autotasks.figures;

abstract class Figure {
    final static double DELTA = 0.0001;

    public abstract Point centroid();
    public abstract boolean isTheSame(Figure figure);
    public boolean deltaCompare(double v1, double v2) {
        return Math.abs(v1 - v2) < Quadrilateral.DELTA;
    }
}
