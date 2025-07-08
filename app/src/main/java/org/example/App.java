package org.example;

public class App {
    public String getGreeting() {
        return "こんにちは SEMonster!";
    }


    public static void main(String[] args) {
        System.out.println(new App().getGreeting());

        System.out.println("\n=== モンスター召喚のテスト ===");

        Monster monster = Monster.summonMonster(2);
        System.out.println("召喚モンスター1: " + monster);

    }
}