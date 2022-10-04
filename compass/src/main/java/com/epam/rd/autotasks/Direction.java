package com.epam.rd.autotasks;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);
    private final int degrees;
    Direction(final int degrees) {
        this.degrees = degrees;
    }

    public static Direction ofDegrees(int degrees) {
        if (Math.abs(degrees) % 360 == 0) {
            return N;
        }
        if (degrees % 360 == 45 || degrees % 360 == -315) {
            return NE;
        }
        if (degrees % 360 == 90 || degrees % 360 == -270) {
            return E;
        }
        if (degrees % 360 == 135 || degrees % 360 == -225) {
            return SE;
        }
        if (Math.abs(degrees) % 360 == 180) {
            return S;
        }
        if (degrees % 360 == 225 || degrees % 360 == -135) {
            return SW;
        }
        if (degrees % 360 == 270 || degrees % 360 == -90) {
            return W;
        }
        if (degrees % 360 == 315 || degrees % 360 == -45) {
            return NW;
        }
        else {
            return null;
        }
    }

    public static Direction closestToDegrees(int degrees) {
        if (Math.abs(degrees) % 340 <= 22 && Math.abs(degrees) % 340 >= 0 || Math.abs(degrees) % 360 <= 22 && Math.abs(degrees) % 360 >= 0) {
            return N;
        }
        if (degrees % 360 >= 23 && degrees % 360 <= 68 || degrees % 360 >= -339 && degrees % 360 <= -294) {
            return NE;
        }
        if (degrees % 360 >= 69 && degrees % 360 <= 112 || degrees % 360 >= -293 && degrees % 360 <= -248) {
            return E;
        }
        if (degrees % 360 >= 113 && degrees % 360 <= 158 || degrees % 360 >= -247 && degrees % 360 <= -204) {
            return SE;
        }
        if (Math.abs(degrees) % 360 >= 159 && Math.abs(degrees) % 360 <= 203) {
            return S;
        }
        if (degrees % 360 >= 204 && degrees % 360 <= 247 || degrees % 360 >= -158 && degrees % 360 <= -113) {
            return SW;
        }
        if (degrees % 360 >= 248 && degrees % 360 <= 293 || degrees % 360 >= -112 && degrees % 360 <= -69) {
            return W;
        }
        if (degrees % 360 >= 294 && degrees % 360 <= 339 || degrees % 360 >= -68 && degrees % 360 <= -23) {
            return NW;
        }
        return null;
    }

    public Direction opposite() {
        return Direction.ofDegrees(degrees - 180);
    }

    public int differenceDegreesTo(Direction direction) {
        if (direction == NW && Direction.ofDegrees(degrees) == N) {
            return 360 - direction.degrees;
        }
        return Math.abs(degrees - direction.degrees);
    }
}
