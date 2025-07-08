package org.example;

import java.util.ArrayList;
import java.util.List;

public class Player {
    String name;
    ArrayList<Monster> monsterDeck = new ArrayList<>();

    /**
     * Playerを生成するコンストラクタ
     * @param name プレイヤー名
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
     * プレイヤーのデッキ情報を指定されたフォーマットの文字列で返す
     * @return Deck:プレイヤー名 と各モンスターの情報 を改行でつないだ文字列
     */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Deck:" + this.name + "\n");
        for (Monster monster : this.monsterDeck) {
            sb.append(monster.toString() + "\n");
        }
        return sb.toString();
    }
}
