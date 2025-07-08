package org.example;

import java.util.Random;


public class Monster {
  private String name;
  private int rare;

  // ここを新しいモンスター名に変更しました
  private static final String[] MONSTER_NAMES = {
    "ゴブリン", "オーク", "リザードマン", "グリフィン", "ベヒーモス"
  };

  public Monster(String name, int rare) {
    this.name = name;
    this.rare = rare;
  }

  @Override
  public String toString() {
    return name + ":レア度[" + rare + "]";
  }

  public static Monster summonMonster(int rare) {
    if (rare < 0 || rare >= MONSTER_NAMES.length) {
      throw new IllegalArgumentException("Invalid rarity: " + rare);
    }
    return new Monster(MONSTER_NAMES[rare], rare);
  }
};