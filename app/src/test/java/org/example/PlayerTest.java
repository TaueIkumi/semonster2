package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class PlayerTest {
  @Test
  public void testPlayerToString() {
    List<Integer> rarities = List.of(0, 4, 6, 1, 3);
    Player player = new Player("user", rarities);

    String actualOutput = player.toString();

    String expectedOutput = "Deck:user\n" +
        "ゴブリン:レア度[0] HP:100/100 MP:50/50 攻撃力:30\n" +
        "スーパーベヒーモス:レア度[4] HP:180/180 MP:90/90 攻撃力:90\n" +
        "スーパーフェニックス:レア度[6] HP:220/220 MP:110/110 攻撃力:120\n" +
        "オーク:レア度[1] HP:120/120 MP:60/60 攻撃力:45\n" +
        "スーパーグリフィン:レア度[3] HP:160/160 MP:80/80 攻撃力:75\n" +
        "--- 所持アイテム ---\n" +
        " - アイテムなし\n";
    assertEquals(expectedOutput, actualOutput);
  }
}
