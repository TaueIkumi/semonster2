package org.example;

import java.util.List;

public class TestPlayer {
    public static void main(String[] args) {
        List<Integer> rarities = List.of(0, 4, 6, 1, 3);
        Player player = new Player("user", rarities);
        System.out.println(player.toString());
    }
}
