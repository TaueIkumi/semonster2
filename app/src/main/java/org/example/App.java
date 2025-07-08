package org.example;

import java.util.List;

public class App {
    public String getGreeting() {
        return "こんにちは SEMonster!";
    }


    public static void main(String[] args) {
        System.out.println(new App().getGreeting());

        System.out.println("\n=== モンスター召喚のテスト ===");

        Monster monster = Monster.summonMonster(2);
        System.out.println("召喚モンスター1: " + monster);

        // 1. デッキに入れるモンスターのレア度をリストで決める
        List<Integer> rarities = List.of(1, 3, 4, 2, 0);

        // 2. プレイヤーを生成する (名前:"Taro", デッキは上記リストの内容)
        Player player1 = new Player("Taro", rarities);

        // 3. プレイヤーの情報を表示する (PlayerクラスのtoString()が呼ばれる)
        System.out.println(player1);

    }
}