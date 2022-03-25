package view;

import java.awt.Color;

import javax.swing.JFrame;

import eventManager.EventManager;

public class FrameMain extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PanelMain panelMain;
	private PanelGraphics panelGraphics;
	private EventManager eventManager;
	
	
	public FrameMain() {
		this.eventManager = new EventManager(this);
		this.panelMain = new PanelMain(eventManager);
		this.panelGraphics = new PanelGraphics(eventManager, null);
		init();
	}
	public void init() {
		
        this.getContentPane().setBackground(Color.WHITE);
        this.setSize(970, 650);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.add(panelMain);
        
        this.panelGraphics.setVisible(false);
        this.add(panelGraphics);
        
		
	}
	public PanelMain getPanelMain() {
		return panelMain;
	}
	public void setPanelMain(PanelMain panelMain) {
		this.panelMain = panelMain;
	}
	public PanelGraphics getPanelGraphics() {
		return panelGraphics;
	}
	public void setPanelGraphics(PanelGraphics panelGraphics) {
		this.panelGraphics = panelGraphics;
	}
	public EventManager getEventManager() {
		return eventManager;
	}
	public void setEventManager(EventManager eventManager) {
		this.eventManager = eventManager;
	}

	
}
