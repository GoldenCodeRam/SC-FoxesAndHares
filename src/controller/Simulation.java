package controller;

import model.Fox;
import model.Hare;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class Simulation {
    public Queue<Fox> foxes = new LinkedList<>();
    public Queue<Hare> hares = new LinkedList<>();

    private int currentSimulationYear = 0;
    private int currentFoxes = 0;
    private int currentHares = 0;

    public Simulation(SimulationStartValues simulationStartValues) {
        Fox.INITIAL_POPULATION = simulationStartValues.initialFoxPopulation;
        Fox.BIRTHRATE = simulationStartValues.birthrateFoxes;
        Fox.LIFE_EXPECTANCY = simulationStartValues.foxLifeExpectancy;
        Fox.HARE_INTAKE_PER_YEAR = simulationStartValues.hareIntakePerYear;

        Hare.INITIAL_POPULATION = simulationStartValues.initialHarePopulation;
        Hare.BIRTHRATE = simulationStartValues.birthrateHare;
        Hare.LIFE_EXPECTANCY = simulationStartValues.hareIntakePerYear;

        this.startEntities();
    }

    public void simulateOneYear() {
        System.out.println(this.hares.size());
        System.out.println(this.foxes.size());
        // Remove dead entities from the year prior
        this.hares.removeIf(hare -> !hare.isAlive());
        this.foxes.removeIf(fox -> !fox.isAlive());

        // Make one year pass for every entity
        this.hares.forEach(hare -> hare.yearPassed(this.currentSimulationYear));
        this.foxes.forEach(fox -> fox.yearPassed(this.currentSimulationYear));

        // Make the foxes eat the hares, before the birthrate
        this.foxesEatHares();

        // The birthrate from this year
        addEntityBirthrate();

        currentSimulationYear++;
    }

    private void foxesEatHares() {
        AtomicInteger haresEaten = new AtomicInteger();

        this.foxes.forEach(fox -> {
            for (int i = 0; i < Fox.HARE_INTAKE_PER_YEAR; i++) {
                if (this.hares.isEmpty()) {
                    fox.die();
                    continue;
                }
                // Here we can do something if the hare is dead, for the moment we just remove it from the list
                this.hares.remove();
                haresEaten.getAndIncrement();
            }
        });
    }

    private void addEntityBirthrate() {
        int foxesThisYear = (int) (Fox.BIRTHRATE * this.foxes.size());
        int haresThisYear = (int) (Hare.BIRTHRATE * this.hares.size());

        this.currentFoxes = foxesThisYear;
        this.currentHares = haresThisYear;

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

    public int getCurrentFoxes() {
        return this.currentFoxes;
    }

    public int getCurrentHares() {
        return this.currentHares;
    }
}
