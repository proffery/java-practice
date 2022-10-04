package com.epam.rd.autotasks;
public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;
    public Battleship8x8(final long ships) {
        this.ships = ships;
    }
    public boolean shoot(String shot) {
        strToLongAndSave(shootToString(shot));
        for (int i = 0; i < longToString(ships).length(); i++) {
            if (longToString(ships).charAt(i) == '1' && shootToString(shot).charAt(i) == '1') {
                return true;
            }
        }
        return false;
    }
    public String state() {
        StringBuilder builder = new StringBuilder();
            for (int i = 0; i < longToString(ships).length(); i++) {
                if (i % 8 == 0 && i != 0) {
                    builder.append("\n");
                }
                if (longToString(ships).charAt(i) == '0' && longToString(shots).charAt(i) == '0')  {
                    builder.append(".");
                }
                else if (longToString(ships).charAt(i) == '0' && longToString(shots).charAt(i) == '1') {
                    builder.append("×");
                }
                else if (longToString(ships).charAt(i) == '1' && longToString(shots).charAt(i) == '1') {
                    builder.append("☒");
                }
                else if (longToString(ships).charAt(i) == '1' && longToString(shots).charAt(i) == '0') {
                    builder.append("☐");
                }
            }
        return builder.toString();
    }
    public String shootToString(String shot) {
        int[][]shotArray = new int[8][8];
        String strJ = String.valueOf(shot.charAt(1));
        int j = Integer.parseInt(strJ) - 1;
        int i = 0;
        String strI = String.valueOf(shot.charAt(0));
        if (strI.equals("A"))
            i = 0;
        if (strI.equals("B"))
            i = 1;
        if (strI.equals("C"))
            i = 2;
        if (strI.equals("D"))
            i = 3;
        if (strI.equals("E"))
            i = 4;
        if (strI.equals("F"))
            i = 5;
        if (strI.equals("G"))
            i = 6;
        if (strI.equals("H"))
            i = 7;
        shotArray[j][i] = 1;
        StringBuilder buildForShoot = new StringBuilder();
        for (int[] ints : shotArray) {
            for (int anInt : ints) {
                if (anInt == 0) {
                    buildForShoot.append("0");
                } else {
                    buildForShoot.append("1");
                }
            }
        }
        return buildForShoot.toString();
    }
    public String longToString(long longValue) {
        StringBuilder builder = new StringBuilder();
        String string = Long.toBinaryString(longValue);
        builder.append("0".repeat(64 - string.length()));
        for (int i = 0; i < string.length(); i++) {
            builder.append(string.charAt(i));
        }
        return builder.toString();
    }
    public void strToLongAndSave(String str){
        String strShots = longToString(shots);
        StringBuilder build = new StringBuilder();
        for (int i = 0; i < strShots.length(); i++) {
            if (str.charAt(i) == '1' || strShots.charAt(i) == '1') {
                build.append("1");
            }
            else {
                build.append("0");
            }
        }
        for (int i = 0; i < str.length(); i++) {
            shots <<= 1;
            if (build.charAt(i) == '1') shots++;
        }
    }
}
