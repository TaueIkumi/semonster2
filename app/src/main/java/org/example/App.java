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

    Item hpPotion = new Item("HPポーション", 50, 0);
    Item mpPotion = new Item("MPポーション", 0, 30);
    player1.addItem(hpPotion);
    player1.addItem(mpPotion);

    // 3. プレイヤーの情報を表示する (PlayerクラスのtoString()が呼ばれる)
    System.out.println(player1);

    Monster target = player1.getMonsterDeck().get(0);

    target.takeDamage(60);

    player1.useItem(0, target);

    System.out.println(player1);

    System.out.println("\n=== スキル攻撃のテスト ===");
    
    List<Integer> rarities2 = List.of(2, 1, 3, 0, 4);
    Player player2 = new Player("Jiro", rarities2);
    
    System.out.println("プレイヤー1のモンスター:");
    System.out.println(player1.getMonsterDeck().get(0));
    System.out.println("プレイヤー2のモンスター:");
    System.out.println(player2.getMonsterDeck().get(0));
    
    System.out.println("\n--- バトル開始 ---");
    
    player1.monsterNormalAttack(0, player2.getMonsterDeck().get(0));
    
    player2.monsterPowerAttack(0, player1.getMonsterDeck().get(0));
    
    player1.monsterSpecialAttack(0, player2.getMonsterDeck().get(0));
    
    System.out.println("\n--- バトル後の状態 ---");
    System.out.println("プレイヤー1のモンスター:");
    System.out.println(player1.getMonsterDeck().get(0));
    System.out.println("プレイヤー2のモンスター:");
    System.out.println(player2.getMonsterDeck().get(0));

  }
}
