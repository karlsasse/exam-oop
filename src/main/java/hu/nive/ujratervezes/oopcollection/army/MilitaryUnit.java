package hu.nive.ujratervezes.oopcollection.army;

public abstract class MilitaryUnit {

    private int makeDamage;
    private boolean hasShield;
    private int healthPoints;

    protected MilitaryUnit(int makeDamage, boolean hasShield, int healthPoints) {
        this.makeDamage = makeDamage;
        this.hasShield = hasShield;
        this.healthPoints = healthPoints;
    }

    public void sufferDamage(int damage) {
        if (hasShield) {
            damage /= 2;
        }
        healthPoints -= damage;
    }

    public int doDamage() {
        return makeDamage;
    }

    public int getHitPoints() {
        return healthPoints;
    }
}
