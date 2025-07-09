package org.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ItemTest {

  @Test
  public void testItem() {
    Item healthPotion = new Item("HPポーション", 50, 0);
    assertEquals("HPポーション", healthPotion.getName());
    assertEquals(50, healthPotion.getHpRecoveryAmount());
    assertEquals(0, healthPotion.getMpRecoveryAmount());

    Item manaPotion = new Item("MPポーション", 0, 30);
    assertEquals("MPポーション", manaPotion.getName());
    assertEquals(0, manaPotion.getHpRecoveryAmount());
    assertEquals(30, manaPotion.getMpRecoveryAmount());

    Item elixir = new Item("エリクサー", 100, 50);
    assertEquals("エリクサー", elixir.getName());
    assertEquals(100, elixir.getHpRecoveryAmount());
    assertEquals(50, elixir.getMpRecoveryAmount());

    Item keyItem = new Item("謎の鍵", 0, 0);
    assertEquals("謎の鍵", keyItem.getName());
    assertEquals(0, keyItem.getHpRecoveryAmount());
    assertEquals(0, keyItem.getMpRecoveryAmount());
  }

  @Test
  public void testItemToString() {
    Item healthPotion = new Item("HPポーション", 50, 0);
    assertEquals("HPポーション (HP回復: 50)", healthPotion.toString());

    Item manaPotion = new Item("MPポーション", 0, 30);
    assertEquals("MPポーション (MP回復: 30)", manaPotion.toString());

    Item elixir = new Item("エリクサー", 100, 50);
    assertEquals("エリクサー (HP回復: 100), MP回復: 50)", elixir.toString());

    Item keyItem = new Item("謎の鍵", 0, 0);
    assertEquals("謎の鍵", keyItem.toString());
  }
}
