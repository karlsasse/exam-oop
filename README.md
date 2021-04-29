Hozzunk létre egy egyszerű alkalmazást, amivel egy középkori hadsereg működését modellezhetjük.

# Katonai egységek (OOP feladat, 20 pont, tesztosztály: ArmyTest)

Minden egységnek vannak életerő pontjai (int) és támadási sebzése (int). Az egységeknek lehet páncéljuk.

Minden katonai egység számára elérhetőek az alábbi metódusok:

- doDamage(): adja vissza az egység sebzését int-ben.

- sufferDamage(int damage): a paraméterül kapott értéket levonja az egység életerő pontjaiból,<br>
  ha az egység páncélozott, akkor csak az érték felét vonjuk le.

##### Archer

Az íjász életereje 50 pont, sebzése 20.<br>
Nem rendelkezik páncéllal.

##### Heavy Cavalry

A nehézlovas életereje 150 pont, sebzése 20.<br>
Páncélozott.<br>
<br>
A lovasság a csatát rohammal indítja,<br>
így minden lovas első támadása háromszoros sebzést okoz,<br>
az utána következők egyszereset.

##### Swordsman

A kardforgató életereje 100 pont, sebzése 10.<br>
Vagy van páncélja vagy nincs.<br>
<br>
Minden kardforgatónak van pajzsa, amivel kivédi az első őt ért csapást.<br>
A pajzs az első kapott sebzés 100%-át felfogja, majd összetörik, tovább nem használható.<br>

# Sereg (Collections feladat, 20 pont, tesztosztály: ArmyTest)

A hadseregnek az alábbi metódusai vannak:

- addUnit(MilitaryUnit militaryUnit), amivel egy katonai egységet tudunk hozzáadni a sereghez,

- damageAll(int damage), ami a sereg minden egységének életerejéből levonja a paraméterül kapott értéket, <br>
  valamint eltávolítja a seregből azokat az egységeket, melyeknek így 25 pont alá csökkent az életerejük <br>
  (azaz harcképtelenek vagy halottak),

- getArmyDamage(), ami visszaadja, hogy az aktuális támadással mennyi sebzést okoz a sereg összesen,

- getArmySize(), ami visszaadja, hogy hány egységből áll a sereg.