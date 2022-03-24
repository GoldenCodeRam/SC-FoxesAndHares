package model;

public class Hare extends Entity {
    public static int INITIAL_POPULATION = 100;
    public static float BIRTHRATE = 1f;
    public static int LIFE_EXPECTANCY = 1;

    @Override
    protected void age() {
        this.yearsLived++;
        if (this.yearsLived == LIFE_EXPECTANCY) {
            this.isAlive = false;
        }
    }
}
