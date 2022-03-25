package controller;

public class SimulationStartValues {
    public int initialFoxPopulation;
    public int initialHarePopulation;
    public float birthrateFoxes;
    public float birthrateHare;
    public int foxLifeExpectancy;
    public int hareLifeExpectancy;
    public int hareIntakePerYear;

    public SimulationStartValues (
            int initialFoxPopulation,
            int initialHarePopulation,
            float birthrateFoxes,
            float birthrateHare,
            int foxLifeExpectancy,
            int hareLifeExpectancy,
            int hareIntakePerYear
    ) {
        this.initialFoxPopulation = initialFoxPopulation;
        this.initialHarePopulation = initialHarePopulation;
        this.birthrateFoxes = birthrateFoxes;
        this.birthrateHare = birthrateHare;
        this.foxLifeExpectancy = foxLifeExpectancy;
        this.hareLifeExpectancy = hareLifeExpectancy;
        this.hareIntakePerYear = hareIntakePerYear;
    }
}