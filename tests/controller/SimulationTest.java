package controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimulationTest {
    @Test
    void simulationSimulatesOneYear() {
        Simulation simulation = new Simulation();

        assertEquals(100, simulation.foxes.size());
        assertEquals(100, simulation.hares.size());

        simulation.simulateOneYear();

        assertEquals(200, simulation.foxes.size());
        assertEquals(200, simulation.hares.size());
    }
}
