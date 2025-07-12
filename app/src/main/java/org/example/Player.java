package org.example;

import java.util.ArrayList;
import java.util.List;

public class Player {
  String name;
  ArrayList<Monster> monsterDeck = new ArrayList<>();
  // アイテムを保持するリストを追加
  ArrayList<Item> items = new ArrayList<>();

  /**
   * Playerを生成するコンストラクタ
   *
   * @param name            プレイヤー名
   * @param monsterRarities デッキに入れるモンスターのレア度を5つ指定したリスト
   */
  public Player(String name, List<Integer> monsterRarities) {
    this.name = name;
    // 指定されたレア度に基づいてモンスターを5体召喚し、デッキに追加する
    for (int rarity : monsterRarities) {
      this.monsterDeck.add(Monster.summonMonster(rarity));
    }
  }

  /**
   * アイテムを追加するメソッド
   *
   * @param item 追加するアイテム
   */
  public void addItem(Item item) {
    this.items.add(item);
    System.out.println(this.name + "は " + item.getName() + " を手に入れた！");
  }

  /**
   * 指定されたインデックスのアイテムを、指定されたモンスターに使うメソッド
   * アイテムを使用後、所持リストから削除される
   *
   * @param itemIndex     使用するアイテムのリスト内インデックス
   * @param targetMonster アイテムを使用する対象モンスター
   */
  public void useItem(int itemIndex, Monster targetMonster) {
    if (itemIndex < 0 || itemIndex >= items.size()) {
      System.out.println("指定されたアイテムは持っていません。");
      return;
    }

    Item itemToUse = items.get(itemIndex);
    System.out.println(this.name + "は " + itemToUse.getName() + " を " + targetMonster.getName() + " に使った！");

    // HP回復
    if (itemToUse.getHpRecoveryAmount() > 0) {
      targetMonster.recoverHp(itemToUse.getHpRecoveryAmount());
    }
    // MP回復
    if (itemToUse.getMpRecoveryAmount() > 0) {
      targetMonster.recoverMp(itemToUse.getMpRecoveryAmount());
    }

    // アイテムを使ったらリストから削除
    items.remove(itemIndex);
    System.out.println(itemToUse.getName() + " はなくなった。");
  }

  public ArrayList<Monster> getMonsterDeck() {
    return monsterDeck;
  }

  public ArrayList<Item> getItems() {
    return items;
  }

  public void monsterNormalAttack(int attackerIndex, Monster target) {
    if (attackerIndex < 0 || attackerIndex >= monsterDeck.size()) {
      System.out.println("指定されたモンスターは存在しません。");
      return;
    }
    
    Monster attacker = monsterDeck.get(attackerIndex);
    System.out.println(this.name + "の" + attacker.getName() + "が攻撃！");
    attacker.normalAttack(target);
  }


  public void monsterPowerAttack(int attackerIndex, Monster target) {
    if (attackerIndex < 0 || attackerIndex >= monsterDeck.size()) {
      System.out.println("指定されたモンスターは存在しません。");
      return;
    }
    
    Monster attacker = monsterDeck.get(attackerIndex);
    System.out.println(this.name + "の" + attacker.getName() + "が強攻撃を使用！");
    attacker.powerAttack(target);
  }


  public void monsterSpecialAttack(int attackerIndex, Monster target) {
    if (attackerIndex < 0 || attackerIndex >= monsterDeck.size()) {
      System.out.println("指定されたモンスターは存在しません。");
      return;
    }
    
    Monster attacker = monsterDeck.get(attackerIndex);
    System.out.println(this.name + "の" + attacker.getName() + "が必殺技を使用！");
    attacker.specialAttack(target);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Deck:" + this.name + "\n");
    // モンスターデッキの情報を追加
    for (Monster monster : this.monsterDeck) {
      sb.append(monster.toString()).append("\n");
    }

    // 所持アイテムの情報を追加
    sb.append("--- 所持アイテム ---\n");
    if (items.isEmpty()) {
      sb.append(" - アイテムなし\n");
    } else {
      for (int i = 0; i < items.size(); i++) {
        sb.append(" - [" + i + "] ").append(items.get(i).toString()).append("\n");
      }
    }
    return sb.toString();
  }
}
