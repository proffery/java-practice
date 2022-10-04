package com.epam.training.student_dmitry_shamko;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        long map = -1150950973573693440L;
        List<String> shots = List.of("C4", "D4", "E4", "F4");
        Battleship8x8 battle = new Battleship8x8(map);
        shots.forEach(battle::shoot);
        System.out.println(battle.state());
    }
}