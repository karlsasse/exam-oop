package hu.nive.ujratervezes.oopcollection.army;

public class Swordsman extends MilitaryUnit {

    private boolean hasHandShield = true;

    public Swordsman(boolean shielded) {
        super(10, shielded, 100);
    }

    @Override
    public void sufferDamage(int damage) {
        if (hasHandShield) {
            hasHandShield = false;
            return;
        }
        super.sufferDamage(damage);
    }
}