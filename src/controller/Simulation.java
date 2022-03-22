package controller;

import model.Fox;
import model.Hare;

import java.util.LinkedList;
import java.util.List;

public class Simulation {
    public List<Fox> foxes = new LinkedList<>();
    public List<Hare> hares = new LinkedList<>();

    private int currentSimulationYear = 0;

    public Simulation() {
        this.startEntities();
    }

    public void simulateOneYear() {
        // Remove dead entities from the year prior
        this.hares.removeIf(hare -> !hare.isAlive());
        this.foxes.removeIf(fox -> !fox.isAlive());

        // Make one year pass for every entity
        this.hares.forEach(hare -> hare.yearPassed(this.currentSimulationYear));
        this.foxes.forEach(fox -> fox.yearPassed(this.currentSimulationYear));

        // TODO: Make the foxes eat the hares, before the birthrate

        // The birthrate from this year
        addEntityBirthrate();

        currentSimulationYear++;
    }

    private void addEntityBirthrate() {
        int foxesThisYear = (int) (Fox.BIRTHRATE * this.foxes.size());
        int haresThisYear = (int) (Hare.BIRTHRATE * this.hares.size());

        for (int i = 0; i < foxesThisYear; i++) {
            this.foxes.add(new Fox());
        }
        for (int i = 0; i < haresThisYear; i++) {
            this.hares.add(new Hare());
        }
    }

    private void startEntities() {
        for (int i = 0; i < Fox.INITIAL_POPULATION; i++) {
            this.foxes.add(new Fox());
        }

        for (int i = 0; i < Hare.INITIAL_POPULATION; i++) {
            this.hares.add(new Hare());
        }
    }
}
