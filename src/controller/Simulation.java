package controller;

import model.Fox;
import model.Hare;

import java.util.LinkedList;
import java.util.List;

public class Simulation {
    private List<Fox> foxes = new LinkedList<>();
    private List<Hare> hares = new LinkedList<>();

    private int currentSimulationYear = 0;

    public Simulation() {
        this.startFoxes();
        this.startHares();
    }

    public void simulateOneYear() {
        this.hares.forEach(hare -> hare.yearPassed(this.currentSimulationYear));
        this.foxes.forEach(fox -> fox.yearPassed(this.currentSimulationYear));

        currentSimulationYear++;
    }

    private void startFoxes() {
        for (int i = 0; i < Fox.INITIAL_POPULATION; i++) {
            this.foxes.add(new Fox());
        }
    }

    private void startHares() {
        for (int i = 0; i < Hare.INITIAL_POPULATION; i++) {
            this.hares.add(new Hare());
        }
    }

}
