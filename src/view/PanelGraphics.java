package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.math.plot.Plot2DPanel;

import controller.Simulation;
import eventManager.EventManager;

public class PanelGraphics extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EventManager eventManager;
	private Simulation simulation;
	
	private JLabel jLPopulationFoxAndHare;
	private JLabel jLPopulation;
	private JLabel jLBirths;
	private JLabel jLDeaths;
	
	private Plot2DPanel graphicPopulationFoxAndHare;
	private Plot2DPanel graphicPopulationFox;
	private Plot2DPanel graphicPopulationHare;
	private Plot2DPanel graphicBirthsFoxes;
	private Plot2DPanel graphicBirthsHare;
	private Plot2DPanel graphicDeathsFoxes;
	private Plot2DPanel graphicDeathsHare;
	
	private double[] listPointsPopulationFox = {0.0};
	private double[] listPointsPopulationHare = {0.0};
	private double[] listPointsYearSimulation = {0.0};
	private double[] listPointsBirthsFoxes = {0.0};
	private double[] listPointsBirthsHare = {0.0};
	private double[] listPointsDeathsFoxes = {0.0};
	private double[] listPointsDeathsHare = {0.0};
	private double[] listPointsKilledHare = {0.0};

	
	public PanelGraphics(EventManager eventManager, Simulation simulation) {
		
		this.eventManager = eventManager;
		this.simulation = simulation;
		
		this.jLPopulationFoxAndHare = new JLabel();
		this.jLPopulation = new JLabel();
		this.jLBirths = new JLabel();
		this.jLDeaths = new JLabel();
		
		this.graphicPopulationFoxAndHare = new Plot2DPanel();
		this.graphicPopulationFox = new Plot2DPanel();
		this.graphicPopulationHare = new Plot2DPanel();
		this.graphicBirthsFoxes = new Plot2DPanel();
		this.graphicBirthsHare = new Plot2DPanel();
		this.graphicDeathsFoxes = new Plot2DPanel();
		this.graphicDeathsHare = new Plot2DPanel();
		
		init();
	}
	
	public void init() {
		
        this.setBounds(10, 10, 930, 590);
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        
        this.jLPopulationFoxAndHare.setText("Zorros(R) VS Liebres(A)");
        this.jLPopulationFoxAndHare.setBounds(80, 0, 250, 40);
        this.jLPopulationFoxAndHare.setFont(new Font("Arial", 0, 16));
        this.add(jLPopulationFoxAndHare);
        
        this.graphicPopulationFoxAndHare.setBounds(20, 30, 300, 300);
        this.graphicPopulationFoxAndHare.setAxisLabels("Años", "Animales");
        this.graphicPopulationFoxAndHare.addScatterPlot("Datos", listPointsYearSimulation, listPointsPopulationFox);
        this.graphicPopulationFoxAndHare.addLinePlot("Linea",listPointsYearSimulation, listPointsPopulationFox);
        this.graphicPopulationFoxAndHare.addScatterPlot("Datos", listPointsYearSimulation, listPointsPopulationHare);
        this.graphicPopulationFoxAndHare.addLinePlot("Linea",listPointsYearSimulation, listPointsPopulationHare);
        this.add(graphicPopulationFoxAndHare);
        
        this.jLPopulation.setText("Poblacion");
        this.jLPopulation.setBounds(580, 0, 250, 40);
        this.jLPopulation.setFont(new Font("Arial", 0, 16));
        this.add(jLPopulation);
        
        this.graphicPopulationFox.setBounds(640, 30, 280, 150);
        this.graphicPopulationFox.setAxisLabels("Años", "Zorros");
        this.graphicPopulationFox.addScatterPlot("Datos", listPointsYearSimulation, listPointsPopulationFox);
        this.graphicPopulationFox.addLinePlot("Linea",listPointsYearSimulation, listPointsPopulationFox);
        this.add(graphicPopulationFox);
        
        this.graphicPopulationHare.setBounds(330, 30, 280, 150);
        this.graphicPopulationHare.setAxisLabels("A�os", "Liebres");
        this.graphicPopulationHare.addScatterPlot("Datos", listPointsYearSimulation, listPointsPopulationHare);
        this.graphicPopulationHare.addLinePlot("Linea",listPointsYearSimulation, listPointsPopulationHare);
        this.add(graphicPopulationHare);
        
        this.jLBirths.setText("Nacimientos");
        this.jLBirths.setBounds(580, 190, 250, 40);
        this.jLBirths.setFont(new Font("Arial", 0, 16));
        this.add(jLBirths);
        
        this.graphicBirthsFoxes.setBounds(640, 220, 280, 150);
        this.graphicBirthsFoxes.setAxisLabels("A�os", "Zorros");
        this.graphicBirthsFoxes.addScatterPlot("Datos", listPointsYearSimulation, listPointsBirthsFoxes);
        this.graphicBirthsFoxes.addLinePlot("Linea",listPointsYearSimulation, listPointsBirthsFoxes);
        this.add(graphicBirthsFoxes);
        
        this.graphicBirthsHare.setBounds(330, 220, 280, 150);
        this.graphicBirthsHare.setAxisLabels("A�os", "Liebres");
        this.graphicBirthsHare.addScatterPlot("Datos", listPointsYearSimulation, listPointsBirthsHare);
        this.graphicBirthsHare.addLinePlot("Linea",listPointsYearSimulation, listPointsBirthsHare);
        this.add(graphicBirthsHare);
        
        this.jLDeaths.setText("Muertes");
        this.jLDeaths.setBounds(600, 380, 250, 40);
        this.jLDeaths.setFont(new Font("Arial", 0, 16));
        this.add(jLDeaths);
        
        this.graphicDeathsFoxes.setBounds(640, 410, 280, 150);
        this.graphicDeathsFoxes.setAxisLabels("Años", "Zorros");
        this.graphicDeathsFoxes.addScatterPlot("Datos", listPointsYearSimulation, listPointsDeathsFoxes);
        this.graphicDeathsFoxes.addLinePlot("Linea",listPointsYearSimulation, listPointsDeathsFoxes);
        this.add(graphicDeathsFoxes);
        
        this.graphicDeathsHare.setBounds(330, 410, 280, 150);
        this.graphicDeathsHare.setAxisLabels("Años", "Liebres");
        this.graphicDeathsHare.addScatterPlot("Datos", listPointsYearSimulation, listPointsDeathsHare);
        this.graphicDeathsHare.addLinePlot("Linea",listPointsYearSimulation, listPointsDeathsHare);
        this.add(graphicDeathsHare);
	}

    public double[] addPoint(double valores[], double nuevoValor){
        double newX[] = new double[valores.length+1];
        for(int i = 0; i<valores.length; i++){
            newX[i]= valores[i]; 
        }
        newX[newX.length-1] = nuevoValor;
        return newX;
    }
    
    public void refreshGraphicPopulation(Plot2DPanel graphic) {
    	
    	graphic.removeAllPlots();
    	graphic.addScatterPlot("Datos", listPointsYearSimulation, listPointsPopulationFox);
    	graphic.addLinePlot("Linea",listPointsYearSimulation, listPointsPopulationFox);
        
    	graphic.addScatterPlot("Datos", listPointsYearSimulation, listPointsPopulationHare);
    	graphic.addLinePlot("Linea",listPointsYearSimulation, listPointsPopulationHare);
    }
    
    public void refreshGraphic(Plot2DPanel graphic, double x[], double y[]) {
    	
    	graphic.removeAllPlots();
    	graphic.addScatterPlot("Datos", x, y);
    	graphic.addLinePlot("Linea",x, y);
    }
	
	public EventManager getEventManager() {
		return eventManager;
	}

	public void setEventManager(EventManager eventManager) {
		this.eventManager = eventManager;
	}

	public Simulation getSimulation() {
		return simulation;
	}

	public void setSimulation(Simulation simulation) {
		this.simulation = simulation;
	}

	public Plot2DPanel getGraphicPopulationFoxAndHare() {
		return graphicPopulationFoxAndHare;
	}

	public void setGraphicPopulationFoxAndHare(Plot2DPanel graphicPopulationFoxAndHare) {
		this.graphicPopulationFoxAndHare = graphicPopulationFoxAndHare;
	}

	public double[] getListPointsPopulationFox() {
		return listPointsPopulationFox;
	}

	public void setListPointsPopulationFox(double[] listPointsPopulationFox) {
		this.listPointsPopulationFox = listPointsPopulationFox;
	}

	public double[] getListPointsPopulationHare() {
		return listPointsPopulationHare;
	}

	public void setListPointsPopulationHare(double[] listPointsPopulationHare) {
		this.listPointsPopulationHare = listPointsPopulationHare;
	}

	public double[] getListPointsYearSimulation() {
		return listPointsYearSimulation;
	}

	public void setListPointsYearSimulation(double[] listPointsYearSimulation) {
		this.listPointsYearSimulation = listPointsYearSimulation;
	}

	public JLabel getjLPopulationFoxAndHare() {
		return jLPopulationFoxAndHare;
	}

	public void setjLPopulationFoxAndHare(JLabel jLPopulationFoxAndHare) {
		this.jLPopulationFoxAndHare = jLPopulationFoxAndHare;
	}

	public Plot2DPanel getGraphicBirthsFoxes() {
		return graphicBirthsFoxes;
	}

	public void setGraphicBirthsFoxes(Plot2DPanel graphicBirthsFoxes) {
		this.graphicBirthsFoxes = graphicBirthsFoxes;
	}

	public Plot2DPanel getGraphicBirthsHare() {
		return graphicBirthsHare;
	}

	public void setGraphicBirthsHare(Plot2DPanel graphicBirthsHare) {
		this.graphicBirthsHare = graphicBirthsHare;
	}

	public double[] getListPointsBirthsFoxes() {
		return listPointsBirthsFoxes;
	}

	public void setListPointsBirthsFoxes(double[] listPointsBirthsFoxes) {
		this.listPointsBirthsFoxes = listPointsBirthsFoxes;
	}

	public double[] getListPointsBirthsHare() {
		return listPointsBirthsHare;
	}

	public void setListPointsBirthsHare(double[] listPointsBirthsHare) {
		this.listPointsBirthsHare = listPointsBirthsHare;
	}

	public Plot2DPanel getGraphicPopulationFox() {
		return graphicPopulationFox;
	}

	public void setGraphicPopulationFox(Plot2DPanel graphicPopulationFox) {
		this.graphicPopulationFox = graphicPopulationFox;
	}

	public Plot2DPanel getGraphicPopulationHare() {
		return graphicPopulationHare;
	}

	public void setGraphicPopulationHare(Plot2DPanel graphicPopulationHare) {
		this.graphicPopulationHare = graphicPopulationHare;
	}


	public double[] getListPointsDeathsFoxes() {
		return listPointsDeathsFoxes;
	}

	public void setListPointsDeathsFoxes(double[] listPointsDeathsFoxes) {
		this.listPointsDeathsFoxes = listPointsDeathsFoxes;
	}

	public double[] getListPointsDeathsHare() {
		return listPointsDeathsHare;
	}

	public void setListPointsDeathsHare(double[] listPointsDeathsHare) {
		this.listPointsDeathsHare = listPointsDeathsHare;
	}

	public double[] getListPointsKilledHare() {
		return listPointsKilledHare;
	}

	public void setListPointsKilledHare(double[] listPointsKilledHare) {
		this.listPointsKilledHare = listPointsKilledHare;
	}

	public Plot2DPanel getGraphicDeathsFoxes() {
		return graphicDeathsFoxes;
	}

	public Plot2DPanel getGraphicDeathsHare() {
		return graphicDeathsHare;

	}
}
