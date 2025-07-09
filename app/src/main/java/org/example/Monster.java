package org.example;

//import java.util.Random;

public class Monster {
  private String name;
  private int rare;
  private int hp;
  private int maxHp;
  private int mp;
  private int maxMp;

  // ここを新しいモンスター名に変更しました
  private static final String[] MONSTER_NAMES = {
      "ゴブリン", "オーク", "リザードマン", "グリフィン", "ベヒーモス",
      "ドラゴン", "フェニックス", "ユニコーン"
  };

  public Monster(String name, int rare) {
    if (rare >= 3) {
      this.name = "スーパー" + name;
    } else {
      this.name = name;
    }
    this.rare = rare;

    this.maxHp = 100 + (rare * 20);
    this.hp = this.maxHp;
    this.maxMp = 50 + (rare * 10);
    this.mp = this.maxMp;
  }

  public int getHp() {
    return hp;
  }

  public int getMp() {
    return mp;
  }

  public String getName() {
    return name;
  }

  public void recoverHp(int amount) {
    this.hp = Math.min(this.hp + amount, this.maxHp);
    System.out.println(this.name + "のHPが " + amount + " 回復した！ 現在HP: " + this.hp + "/" + this.maxHp);
  }

  public void recoverMp(int amount) {
    this.mp = Math.min(this.mp + amount, this.maxMp);
    System.out.println(this.name + "のMPが " + amount + " 回復した！ 現在MP: " + this.mp + "/" + this.maxMp);
  }

  public void takeDamage(int amount) {
    this.hp -= amount;
    System.out.println(this.name + "は " + amount + " のダメージを受けた！ 現在HP: " + this.hp + "/" + this.maxHp);
    if (this.hp <= 0) {
      this.hp = 0;
      System.out.println(this.name + "は倒れた！");
    }
  }

  @Override
  public String toString() {
    return name + ":レア度[" + rare + "] HP:" + hp + " MP:" + mp;
  }

  public static Monster summonMonster(int rare) {
    if (rare < 0 || rare >= MONSTER_NAMES.length) {
      throw new IllegalArgumentException("Invalid rarity: " + rare);
    }
    return new Monster(MONSTER_NAMES[rare], rare);
  }
};
