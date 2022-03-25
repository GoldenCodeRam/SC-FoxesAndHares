package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import eventManager.EventManager;

public class PanelMain extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String C_JB_SIMULATE = "C_JB_SIMULATE";
	
	private JLabel jLTitle;
	private JLabel jLYearsSimulate;
	private JLabel jLInitialPoblationFoxes;
	private JLabel jLInitialPoblationHare;
	private JLabel jLBirthdateFoxes;
	private JLabel jLBirthdateHare;
	private JLabel jLLifeExpectationFoxes;
	private JLabel jLLifeExpectationHare;
	private JLabel jLHareIntakePerYear;
	
	private JTextField jTFYearsSimulate;
	private JTextField jTFInitialPoblationFoxes;
	private JTextField jTFInitialPoblationHare;
	private JTextField jTFBirthdateFoxes;
	private JTextField jTFBirthdateHare;
	private JTextField jTFLifeExpectationFoxes;
	private JTextField jTFLifeExpectationHare;
	private JTextField jTFHareIntakePerYear;
	
	private JButton jBSimulate;
	
	private EventManager eventManager;
	
	public PanelMain(EventManager eventManager) {
		
		this.eventManager = eventManager;
		
		this.jLTitle = new JLabel();
		this.jLYearsSimulate = new JLabel();
		this.jLInitialPoblationFoxes = new JLabel();
		this.jLInitialPoblationHare = new JLabel();
		this.jLBirthdateFoxes = new JLabel();
		this.jLBirthdateHare = new JLabel();
		this.jLLifeExpectationFoxes = new JLabel();
		this.jLLifeExpectationHare = new JLabel();
		this.jLHareIntakePerYear = new JLabel();
		
		this.jTFYearsSimulate = new JTextField();
		this.jTFInitialPoblationFoxes = new JTextField();
		this.jTFInitialPoblationHare = new JTextField();
		this.jTFBirthdateFoxes = new JTextField();
		this.jTFBirthdateHare = new JTextField();
		this.jTFLifeExpectationFoxes = new JTextField();
		this.jTFLifeExpectationHare = new JTextField();
		this.jTFHareIntakePerYear = new JTextField();
		
		this.jBSimulate = new JButton();
		
		init();
	}
	
	public void init() {
		
        this.setBounds(50, 50, 870, 530);
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        
        this.jLTitle.setText("Simulacion de población de Zorros y Liebres");
        this.jLTitle.setBounds(70, 0, 750, 60);
        this.jLTitle.setFont(new Font("Arial", 0, 36));
        this.add(jLTitle);
        
        this.jLYearsSimulate.setText("Años a Simular:");
        this.jLYearsSimulate.setBounds(20, 110, 200, 30);
        this.jLYearsSimulate.setFont(new Font("Arial", 0, 16));
        this.add(jLYearsSimulate);
        
        this.jTFYearsSimulate.setBounds(210, 110, 200, 40);
        this.add(jTFYearsSimulate);
        
        this.jLInitialPoblationFoxes.setText("Poblacion inicial Zorros:");
        this.jLInitialPoblationFoxes.setBounds(20, 180, 200, 30);
        this.jLInitialPoblationFoxes.setFont(new Font("Arial", 0, 16));
        this.add(jLInitialPoblationFoxes);
        
        this.jTFInitialPoblationFoxes.setBounds(210, 180, 200, 40);
        this.add(jTFInitialPoblationFoxes);
        
        this.jLBirthdateFoxes.setText("Tasa natalidad de Zorros:");
        this.jLBirthdateFoxes.setBounds(20, 230, 200, 30);
        this.jLBirthdateFoxes.setFont(new Font("Arial", 0, 16));
        this.add(jLBirthdateFoxes);
        
        this.jTFBirthdateFoxes.setBounds(210, 230, 200, 40);
        this.add(jTFBirthdateFoxes);
        
        this.jLLifeExpectationFoxes.setText("Tiempo de vida Zorros:");
        this.jLLifeExpectationFoxes.setBounds(20, 280, 200, 30);
        this.jLLifeExpectationFoxes.setFont(new Font("Arial", 0, 16));
        this.add(jLLifeExpectationFoxes);
        
        this.jTFLifeExpectationFoxes.setBounds(210, 280, 200, 40);
        this.add(jTFLifeExpectationFoxes);
        
        this.jLHareIntakePerYear.setText("Consumo liebres por año:");
        this.jLHareIntakePerYear.setBounds(20, 330, 200, 30);
        this.jLHareIntakePerYear.setFont(new Font("Arial", 0, 16));
        this.add(jLHareIntakePerYear);
        
        this.jTFHareIntakePerYear.setBounds(210, 330, 200, 40);
        this.add(jTFHareIntakePerYear);
        
        
        this.jLInitialPoblationHare.setText("Poblacion inicial Liebres:");
        this.jLInitialPoblationHare.setBounds(430, 180, 200, 30);
        this.jLInitialPoblationHare.setFont(new Font("Arial", 0, 16));
        this.add(jLInitialPoblationHare);
        
        this.jTFInitialPoblationHare.setBounds(640, 180, 200, 40);
        this.add(jTFInitialPoblationHare);
        
        this.jLBirthdateHare.setText("Tasa natalidad de Liebres:");
        this.jLBirthdateHare.setBounds(430, 230, 200, 30);
        this.jLBirthdateHare.setFont(new Font("Arial", 0, 16));
        this.add(jLBirthdateHare);
        
        this.jTFBirthdateHare.setBounds(640, 230, 200, 40);
        this.add(jTFBirthdateHare);
        
        this.jLLifeExpectationHare.setText("Tiempo de vida Liebres:");
        this.jLLifeExpectationHare.setBounds(430, 280, 200, 30);
        this.jLLifeExpectationHare.setFont(new Font("Arial", 0, 16));
        this.add(jLLifeExpectationHare);
        
        this.jTFLifeExpectationHare.setBounds(640, 280, 200, 40);
        this.add(jTFLifeExpectationHare);
        
        this.jBSimulate.setText("Simular");
        this.jBSimulate.setBounds(640, 450, 200, 40);
        this.jBSimulate.setBackground(Color.WHITE);
        this.jBSimulate.setFont(new Font("Arial", 0, 16));	
        this.jBSimulate.setActionCommand(C_JB_SIMULATE);
        this.jBSimulate.addActionListener(eventManager);
        
        this.jBSimulate.setFocusable(false);
        this.add(jBSimulate);
	}


	public JTextField getjTFYearsSimulate() {
		return jTFYearsSimulate;
	}

	public void setjTFYearsSimulate(JTextField jTFYearsSimulate) {
		this.jTFYearsSimulate = jTFYearsSimulate;
	}

	public JTextField getjTFInitialPoblationFoxes() {
		return jTFInitialPoblationFoxes;
	}

	public void setjTFInitialPoblationFoxes(JTextField jTFInitialPoblationFoxes) {
		this.jTFInitialPoblationFoxes = jTFInitialPoblationFoxes;
	}

	public JTextField getjTFInitialPoblationHare() {
		return jTFInitialPoblationHare;
	}

	public void setjTFInitialPoblationHare(JTextField jTFInitialPoblationHare) {
		this.jTFInitialPoblationHare = jTFInitialPoblationHare;
	}

	public JTextField getjTFBirthdateFoxes() {
		return jTFBirthdateFoxes;
	}

	public void setjTFBirthdateFoxes(JTextField jTFBirthdateFoxes) {
		this.jTFBirthdateFoxes = jTFBirthdateFoxes;
	}

	public JTextField getjTFBirthdateHare() {
		return jTFBirthdateHare;
	}

	public void setjTFBirthdateHare(JTextField jTFBirthdateHare) {
		this.jTFBirthdateHare = jTFBirthdateHare;
	}

	public JTextField getjTFLifeExpectationFoxes() {
		return jTFLifeExpectationFoxes;
	}

	public void setjTFLifeExpectationFoxes(JTextField jTFLifeExpectationFoxes) {
		this.jTFLifeExpectationFoxes = jTFLifeExpectationFoxes;
	}

	public JTextField getjTFLifeExpectationHare() {
		return jTFLifeExpectationHare;
	}

	public void setjTFLifeExpectationHare(JTextField jTFLifeExpectationHare) {
		this.jTFLifeExpectationHare = jTFLifeExpectationHare;
	}

	public JTextField getjTFHareIntakePerYear() {
		return jTFHareIntakePerYear;
	}

	public void setjTFHareIntakePerYear(JTextField jTFHareIntakePerYear) {
		this.jTFHareIntakePerYear = jTFHareIntakePerYear;
	}

	public JButton getjBSimulate() {
		return jBSimulate;
	}

	public void setjBSimulate(JButton jBSimulate) {
		this.jBSimulate = jBSimulate;
	}

	public EventManager getEventManager() {
		return eventManager;
	}

	public void setEventManager(EventManager eventManager) {
		this.eventManager = eventManager;
	}
	
}
