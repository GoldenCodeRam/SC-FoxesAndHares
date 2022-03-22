package model;

import controller.SimulationElement;

public abstract class Entity extends SimulationElement {
    protected boolean isAlive = true;
    protected int yearsLived = 0;

    @Override
    public void yearPassed(int currentSimulationYear) {
        this.age();
    }

    protected abstract void age();
}
