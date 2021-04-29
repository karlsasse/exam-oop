package hu.nive.ujratervezes.oopcollection.army;

import cccr.CCCRTestExecutionListener;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith({CCCRTestExecutionListener.class})
class ArmyTest {

    Army army;

    @BeforeEach
    void init() {
        army = new Army();
    }

    /*
     * ArmyTests
     */
    @Test
    void testGetArmySizeEmpty() {
        assertEquals(0, army.getArmySize());
    }

    @Test
    void testAddUnit() {
        army.addUnit(new HeavyCavalry());
        assertEquals(1, army.getArmySize());
    }

    @Test
    void testGetArmyDamageEmptyArmy() {
        assertEquals(0, army.getArmyDamage());
    }

    @Test
    void testGetArmyDamage_oneOfEachKind() {
        army.addUnit(new HeavyCavalry());
        army.addUnit(new Swordsman(true));
        army.addUnit(new Archer());
        assertEquals(90, army.getArmyDamage());
    }

    @Test
    void testDamageAll_someRemain() {
        army.addUnit(new HeavyCavalry());
        army.addUnit(new Swordsman(true));
        army.addUnit(new Swordsman(false));
        army.addUnit(new Archer());
        army.damageAll(80);
        army.damageAll(80);
        assertEquals(2, army.getArmySize());
    }

    @Test
    void testDamageAll_noneRemain() {
        army.addUnit(new HeavyCavalry());
        army.addUnit(new Swordsman(true));
        army.addUnit(new Swordsman(false));
        army.addUnit(new Archer());
        army.damageAll(200);
        army.damageAll(200);
        assertEquals(0, army.getArmySize());
    }

    /*
     * MilitaryUnitTests
     */
    @Test
    void test_militaryUnitIsAbstract() {
        assertTrue(Modifier.isAbstract(MilitaryUnit.class.getModifiers()));
    }

    @Test
    void testArcher() {
        Archer archer = new Archer();
        assertEquals(20, archer.doDamage());
        archer.sufferDamage(20);
        assertEquals(30, archer.getHitPoints());
    }

    @Test
    void testHeavyCavalry() {
        HeavyCavalry heavyCavalry = new HeavyCavalry();
        assertEquals(60, heavyCavalry.doDamage());
        assertEquals(20, heavyCavalry.doDamage());
        heavyCavalry.sufferDamage(20);
        assertEquals(140, heavyCavalry.getHitPoints());
    }

    @Test
    void testSwordsmanArmored() {
        Swordsman swordsman = new Swordsman(true);
        swordsman.sufferDamage(20);
        assertEquals(100, swordsman.getHitPoints());
        swordsman.sufferDamage(20);
        assertEquals(90, swordsman.getHitPoints());
        assertEquals(10, swordsman.doDamage());
    }

    @Test
    void testSwordsmanUnarmored() {
        Swordsman swordsman = new Swordsman(false);
        swordsman.sufferDamage(20);
        assertEquals(100, swordsman.getHitPoints());
        swordsman.sufferDamage(20);
        assertEquals(80, swordsman.getHitPoints());
        assertEquals(10, swordsman.doDamage());
    }
}