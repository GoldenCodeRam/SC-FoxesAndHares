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

    private int currentFoxesDeaths = 0;
    private int currentHaresDeaths = 0;
    private int currentHaresEaten = 0;

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
        this.currentFoxesDeaths = 0;
        this.currentHaresDeaths = 0;
        this.currentHaresEaten = 0;
        // Remove dead entities from the year prior
        int haresBefore = this.hares.size();
        this.hares.removeIf(hare -> !hare.isAlive());
        this.currentHaresDeaths = haresBefore - this.hares.size();

        int foxesBefore = this.foxes.size();
        this.foxes.removeIf(fox -> !fox.isAlive());
        this.currentFoxesDeaths = foxesBefore - this.foxes.size();

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
        this.currentHaresEaten = haresEaten.get();
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

    public int getCurrentFoxesDeaths() {
        return currentFoxesDeaths;
    }

    public int getCurrentHaresDeaths() {
        return currentHaresDeaths;
    }

    public int getCurrentHaresEaten() {
        return currentHaresEaten;
    }
}
