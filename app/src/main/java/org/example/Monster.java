package org.example;

//import java.util.Random;

public class Monster {
  private String name;
  private int rare;
  private int hp;
  private int maxHp;
  private int mp;
  private int maxMp;
  private int attackPower;

  private static final String[] MONSTER_NAMES = {
      "ゴブリン", "オーク", "リザードマン", "グリフィン", "ベヒーモス",
      "ドラゴン", "フェニックス", "ユニコーン", "クラーケン", "バハムート"
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
    this.attackPower = 30 + (rare * 15);
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

  public int getAttackPower() {
    return attackPower;
  }

  public void normalAttack(Monster target) {
    if (this.hp <= 0) {
      System.out.println(this.name + "は倒れているため攻撃できません！");
      return;
    }
    
    int damage = this.attackPower;
    System.out.println(this.name + "の通常攻撃！");
    target.takeDamage(damage);
  }

  public void powerAttack(Monster target) {
    int mpCost = 20;
    if (this.hp <= 0) {
      System.out.println(this.name + "は倒れているため攻撃できません！");
      return;
    }
    if (this.mp < mpCost) {
      System.out.println(this.name + "のMPが足りません！強攻撃を使用できません。");
      return;
    }
    
    int damage = (int)(this.attackPower * 1.5);
    this.mp -= mpCost;
    System.out.println(this.name + "の強攻撃！ (MP-" + mpCost + ")");
    target.takeDamage(damage);
  }

  public void specialAttack(Monster target) {
    int mpCost = 40;
    if (this.hp <= 0) {
      System.out.println(this.name + "は倒れているため攻撃できません！");
      return;
    }
    if (this.mp < mpCost) {
      System.out.println(this.name + "のMPが足りません！必殺技を使用できません。");
      return;
    }
    
    int damage = this.attackPower * 2;
    this.mp -= mpCost;
    System.out.println(this.name + "の必殺技発動！ (MP-" + mpCost + ")");
    target.takeDamage(damage);
  }

  /**
   * モンスターが倒れているかどうかを判定
   */
  public boolean isDefeated() {
    return this.hp <= 0;
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
    return name + ":レア度[" + rare + "] HP:" + hp + "/" + maxHp + " MP:" + mp + "/" + maxMp + " 攻撃力:" + attackPower;
  }

  public static Monster summonMonster(int rare) {
    if (rare < 0 || rare >= MONSTER_NAMES.length) {
      throw new IllegalArgumentException("Invalid rarity: " + rare);
    }
    return new Monster(MONSTER_NAMES[rare], rare);
  }
};
