package hu.nive.ujratervezes.oopcollection.army;


import java.util.ArrayList;
import java.util.List;

/**
 Hozzunk létre egy egyszerű alkalmazást, amivel egy középkori hadsereg működését modellezhetjük.

 Katonai egységek (OOP feladat, 20 pont, tesztosztály: ArmyTest)
 Minden egységnek vannak életerő pontjai (int) és támadási sebzése (int). Az egységeknek lehet páncéljuk.

 Minden katonai egység számára elérhetőek az alábbi metódusok:

 doDamage(): adja vissza az egység sebzését int-ben.

 sufferDamage(int damage): a paraméterül kapott értéket levonja az egység életerő pontjaiból,
 ha az egység páncélozott, akkor csak az érték felét vonjuk le.

 Archer
 Az íjász életereje 50 pont, sebzése 20.
 Nem rendelkezik páncéllal.

 Heavy Cavalry
 A nehézlovas életereje 150 pont, sebzése 20.
 Páncélozott.

 A lovasság a csatát rohammal indítja,
 így minden lovas első támadása háromszoros sebzést okoz,
 az utána következők egyszereset.

 Swordsman
 A kardforgató életereje 100 pont, sebzése 10.
 Vagy van páncélja vagy nincs.

 Minden kardforgatónak van pajzsa, amivel kivédi az első őt ért csapást.
 A pajzs az első kapott sebzés 100%-át felfogja, majd összetörik, tovább nem használható.

 Sereg (Collections feladat, 20 pont, tesztosztály: ArmyTest)
 A hadseregnek az alábbi metódusai vannak:

 addUnit(MilitaryUnit militaryUnit), amivel egy katonai egységet tudunk hozzáadni a sereghez,

 damageAll(int damage), ami a sereg minden egységének életerejéből levonja a paraméterül kapott értéket,
 valamint eltávolítja a seregből azokat az egységeket, melyeknek így 25 pont alá csökkent az életerejük
 (azaz harcképtelenek vagy halottak),

 getArmyDamage(), ami visszaadja, hogy az aktuális támadással mennyi sebzést okoz a sereg összesen,

 getArmySize(), ami visszaadja, hogy hány egységből áll a sereg.
 */

public class Army {
    private List<MilitaryUnit> warriors = new ArrayList<>();
    public void addUnit(MilitaryUnit militaryUnit) {
        warriors.add(militaryUnit);
    }

    public int getArmyDamage() {
        int allDamage = 0;
        for (MilitaryUnit warrior: warriors) {
            allDamage += warrior.doDamage();
        }
        return allDamage;
    }

    public void damageAll(int damage) {
        List<MilitaryUnit> removeThem = new ArrayList<>();
        for (MilitaryUnit warrior: warriors) {
            warrior.sufferDamage(damage);
            if (warrior.getHitPoints() < 25) {
                removeThem.add(warrior);
            }
        }
        for (MilitaryUnit removeWarrior: removeThem) {
            warriors.remove(removeWarrior);
        }
    }

    public int getArmySize() {
        return warriors.size();
    }
}