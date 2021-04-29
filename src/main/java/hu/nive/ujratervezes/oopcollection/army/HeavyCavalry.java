package hu.nive.ujratervezes.oopcollection.army;

public class HeavyCavalry extends MilitaryUnit {

    private boolean hasAttacked = false;

    public HeavyCavalry() {
        super(20, true, 150);
    }

    @Override
    public int doDamage() {
        if (!hasAttacked) {
            hasAttacked = true;
            return 3 * super.doDamage();
        }
        return super.doDamage();
    }
}