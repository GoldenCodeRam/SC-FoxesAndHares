package eventManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controller.Simulation;
import controller.SimulationStartValues;
import view.FrameMain;
import view.PanelMain;

public class EventManager implements ActionListener {

	private FrameMain frameMain;
	
	public EventManager(FrameMain frameMain) {
		
		this.frameMain = frameMain;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand()) {
         case PanelMain.C_JB_SIMULATE:
        	 
        	 try {
        	 Simulation sc = new Simulation(new SimulationStartValues(Integer.parseInt(frameMain.getPanelMain().getjTFInitialPoblationFoxes().getText() + "") ,
        			 Integer.parseInt(frameMain.getPanelMain().getjTFInitialPoblationHare().getText() + ""),
        			 Float.parseFloat(frameMain.getPanelMain().getjTFBirthdateFoxes().getText() + ""),
        			 Float.parseFloat(frameMain.getPanelMain().getjTFBirthdateHare().getText() + ""),
        			 Integer.parseInt(frameMain.getPanelMain().getjTFLifeExpectationFoxes().getText() + ""),
        			 Integer.parseInt(frameMain.getPanelMain().getjTFLifeExpectationHare().getText() + ""),
        			 Integer.parseInt(frameMain.getPanelMain().getjTFHareIntakePerYear().getText() + "")));
        	 this.frameMain.getPanelGraphics().setSimulation(sc);
        	 this.frameMain.getPanelMain().setVisible(false);
        	 this.frameMain.getPanelGraphics().setVisible(true);
        	 frameMain.getPanelGraphics().getListPointsPopulationFox()[0] = Integer.parseInt(frameMain.getPanelMain().getjTFInitialPoblationFoxes().getText() + "");
       		 frameMain.getPanelGraphics().getListPointsPopulationHare()[0] = Integer.parseInt(frameMain.getPanelMain().getjTFInitialPoblationHare().getText() + "");
        	 for (int i = 1; i <= Integer.parseInt(frameMain.getPanelMain().getjTFYearsSimulate().getText() + ""); i++) {
				 System.out.println(i);
        		 frameMain.getPanelGraphics().getSimulation().simulateOneYear();
           		 frameMain.getPanelGraphics().setListPointsYearSimulation(frameMain.getPanelGraphics().addPoint(frameMain.getPanelGraphics().getListPointsYearSimulation(), i));
           		 frameMain.getPanelGraphics().setListPointsPopulationFox(frameMain.getPanelGraphics().addPoint(frameMain.getPanelGraphics().getListPointsPopulationFox(), frameMain.getPanelGraphics().getSimulation().foxes.size()));
           		 frameMain.getPanelGraphics().setListPointsPopulationHare(frameMain.getPanelGraphics().addPoint(frameMain.getPanelGraphics().getListPointsPopulationHare(), frameMain.getPanelGraphics().getSimulation().hares.size()));
           		 frameMain.getPanelGraphics().setListPointsBirthsFoxes(frameMain.getPanelGraphics().addPoint(frameMain.getPanelGraphics().getListPointsBirthsFoxes(), frameMain.getPanelGraphics().getSimulation().getCurrentFoxes()));
           		 frameMain.getPanelGraphics().setListPointsBirthsHare(frameMain.getPanelGraphics().addPoint(frameMain.getPanelGraphics().getListPointsBirthsHare(), frameMain.getPanelGraphics().getSimulation().getCurrentHares()));
			}
        	 
        	 frameMain.getPanelGraphics().refreshGraphicPopulation(frameMain.getPanelGraphics().getGraphicPopulationFoxAndHare());
        	 frameMain.getPanelGraphics().refreshGraphic(frameMain.getPanelGraphics().getGraphicBirthsFoxes(), frameMain.getPanelGraphics().getListPointsYearSimulation(), frameMain.getPanelGraphics().getListPointsBirthsFoxes());
        	 frameMain.getPanelGraphics().refreshGraphic(frameMain.getPanelGraphics().getGraphicBirthsHare(),frameMain.getPanelGraphics().getListPointsYearSimulation(), frameMain.getPanelGraphics().getListPointsBirthsHare());
        	 frameMain.getPanelGraphics().refreshGraphic(frameMain.getPanelGraphics().getGraphicPopulationFox(), frameMain.getPanelGraphics().getListPointsYearSimulation(), frameMain.getPanelGraphics().getListPointsPopulationFox());
        	 frameMain.getPanelGraphics().refreshGraphic(frameMain.getPanelGraphics().getGraphicPopulationHare(), frameMain.getPanelGraphics().getListPointsYearSimulation(), frameMain.getPanelGraphics().getListPointsPopulationHare());
        	 }catch (Exception e2) {
        		 JOptionPane.showMessageDialog(null, "COMPLETE LOS CAMPOS CON VALORES NUMERICOS", "NO SE PUEDE EJECUTAR LA SIMULACION", JOptionPane.WARNING_MESSAGE);
			}

        	break;
		}
		
	}

}
