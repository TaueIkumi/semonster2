package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MonsterSkillTest {

    @Test
    public void testNormalAttack() {
        Monster attacker = new Monster("テストモンスター1", 2);
        Monster target = new Monster("テストモンスター2", 1);
        
        int targetInitialHp = target.getHp();
        int expectedDamage = attacker.getAttackPower();
        
        attacker.normalAttack(target);
        
        assertEquals(targetInitialHp - expectedDamage, target.getHp());
    }

    @Test
    public void testPowerAttack() {
        Monster attacker = new Monster("テストモンスター1", 2);
        Monster target = new Monster("テストモンスター2", 1);
        
        int targetInitialHp = target.getHp();
        int attackerInitialMp = attacker.getMp();
        int expectedDamage = (int)(attacker.getAttackPower() * 1.5);
        
        attacker.powerAttack(target);
        
        assertEquals(targetInitialHp - expectedDamage, target.getHp());
        assertEquals(attackerInitialMp - 20, attacker.getMp());
    }

    @Test
    public void testSpecialAttack() {
        Monster attacker = new Monster("テストモンスター1", 2);
        Monster target = new Monster("テストモンスター2", 1);
        
        int targetInitialHp = target.getHp();
        int attackerInitialMp = attacker.getMp();
        int expectedDamage = attacker.getAttackPower() * 2;
        
        attacker.specialAttack(target);
        
        assertEquals(targetInitialHp - expectedDamage, target.getHp());
        assertEquals(attackerInitialMp - 40, attacker.getMp());
    }

    @Test
    public void testAttackWithInsufficientMp() {
        Monster attacker = new Monster("テストモンスター1", 0);
        Monster target = new Monster("テストモンスター2", 1);
        
        // 強攻撃でMPを消費させる
        attacker.powerAttack(target);
        attacker.powerAttack(target);
        // この時点でMPが足りなくなる
        
        int targetHpBeforeAttack = target.getHp();
        
        attacker.powerAttack(target);
        
        // MPが足りないので攻撃が発動しない
        assertEquals(targetHpBeforeAttack, target.getHp());
    }

    @Test
    public void testDefeatedMonsterCannotAttack() {
        Monster attacker = new Monster("テストモンスター1", 2);
        Monster target = new Monster("テストモンスター2", 1);
        
        // 攻撃者のHPを0にする
        attacker.takeDamage(attacker.getHp());
        
        int targetInitialHp = target.getHp();
        
        attacker.normalAttack(target);
        
        // 倒れたモンスターは攻撃できない
        assertEquals(targetInitialHp, target.getHp());
    }

    @Test
    public void testIsDefeated() {
        Monster monster = new Monster("テストモンスター", 1);
        
        assertFalse(monster.isDefeated());
        
        monster.takeDamage(monster.getHp());
        
        assertTrue(monster.isDefeated());
    }
}
