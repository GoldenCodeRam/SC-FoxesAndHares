package controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimulationTest {
    @Test
    void simulationSimulatesOneYear() {
        Simulation simulation = new Simulation(new SimulationStartValues(
                10, 200, 0.3f, 0.6f, 2, 4, 4
        ));

        assertEquals(10, simulation.foxes.size());
        assertEquals(200, simulation.hares.size());

        simulation.simulateOneYear();

        assertEquals(13, simulation.foxes.size());
        assertEquals(256, simulation.hares.size());
    }
}
