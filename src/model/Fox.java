package model;

public class Fox extends Entity {
    public static int INITIAL_POPULATION = 100;
    public static float BIRTHRATE = 1f;
    public static int LIFE_EXPECTANCY = 1;
    public static int HARE_INTAKE_PER_YEAR = 1;

    @Override
    protected void age() {
        this.yearsLived++;
        if (this.yearsLived == LIFE_EXPECTANCY) {
            this.isAlive = false;
        }
    }
}
