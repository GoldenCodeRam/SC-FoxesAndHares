package model;

import controller.SimulationElement;

public abstract class Entity extends SimulationElement {
    protected boolean isAlive = true;
    protected int yearsLived = 0;

    @Override
    public void yearPassed(int currentSimulationYear) {
        this.age();
    }

    public void die() {
        this.isAlive = false;
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    protected abstract void age();
}
