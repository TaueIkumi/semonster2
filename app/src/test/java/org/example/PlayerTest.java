package org.example;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class PlayerTest {
  @Test
  public void testPlayerToString() {
    // 1. (Arrange) 準備: テスト用のプレイヤーを作成
    // レア度 0, 4, 0, 6, 1 のモンスターを持つ "user" という名前のプレイヤー
    List<Integer> rarities = List.of(0, 4, 6, 1, 3);
    Player player = new Player("user", rarities);

    // 2. (Act) 実行: toString() メソッドを呼び出す
    String actualOutput = player.toString();

    // 3. (Assert) 検証: 期待される出力と実際の結果が一致するか確認
    String expectedOutput = "Deck:user\n" +
        "ゴブリン:レア度[0] HP:100 MP:50\n" +
        "スーパーベヒーモス:レア度[4] HP:180 MP:90\n" +
        "スーパーフェニックス:レア度[6] HP:220 MP:110\n" +
        "オーク:レア度[1] HP:120 MP:60\n" +
        "スーパーグリフィン:レア度[3] HP:160 MP:80\n" +
        "--- 所持アイテム ---\n" +
        " - アイテムなし\n";
    assertEquals(expectedOutput, actualOutput);
  }
}
