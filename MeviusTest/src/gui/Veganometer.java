package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


/**
 * 
 * @author Philipp
 * @date 2017-11-19
 * @brief In this frame the user can choose what he want to calculate.
 *
 */
public class Veganometer extends JFrame implements ActionListener {
	
	
		
		//Stepp 1 generate komponents
		
		JButton bmi;
		JButton grundumsatz;
		JButton cowert;
		JButton liquidNeeds;
		JButton trainingPulse;
		JButton back;
		JPanel panelAccountButton;
		JPanel panel;
		
		public Veganometer(String s) {
			super(s);
		// for the Labels
		bmi = new JButton("bmi");
		grundumsatz = new JButton("basal metabolism");
		cowert = new JButton("Co2 calculator");
		trainingPulse = new JButton("Training pulse calculator");
		liquidNeeds = new JButton("liquid needs calculator");
		back = new JButton("back");
		
		// Step 3: generate containers for the components
		 panel = new JPanel();
		 panelAccountButton = new JPanel();
		
	     Container content = getContentPane();
	     
	  // Step 4: determine a layout manager
	     panel.setLayout( new GridBagLayout());
	     GridBagConstraints gbc = new GridBagConstraints();
	     gbc.fill = GridBagConstraints.HORIZONTAL;
	     gbc.insets = new Insets(5, 5, 5, 5);
	      
	     content.setLayout(new GridBagLayout());
	     
	     panelAccountButton.setLayout(new BorderLayout());
	     
	     // Step 5: add the components to the containers and put the containers
	     // into the main window
	     gbc.gridx = 0;
	     gbc.gridy = 0;
	     
	     panel.add(bmi, gbc);
	     gbc.gridx = 0;
	     gbc.gridy = 1;
	     panel.add(grundumsatz,gbc);
	     gbc.gridx = 1;
	     gbc.gridy = 0;
	     panel.add(cowert, gbc);
	     gbc.gridx = 1;
	     gbc.gridy = 1;
	     panel.add(liquidNeeds, gbc);
	     gbc.gridx = 2;
	     gbc.gridy = 0;
	     panel.add(trainingPulse, gbc);
	     gbc.gridx = 2;
	     gbc.gridy = 1;
	     panel.add(back, gbc);
	     
	     gbc.insets.set(10, 5, 50, 5);
	    
	     content.add(panel, gbc);
	     
	     // Step 6: Event Handling
	     addWindowListener(new WindowClosingAdapter());
	     bmi.addActionListener(this);
	     cowert.addActionListener(this);
	     grundumsatz.addActionListener(this);
	     liquidNeeds.addActionListener(this);
	     trainingPulse.addActionListener(this);
	     back.addActionListener(this);
		 // Step 7: display main window
	     
	     pack();
	     setSize(780, 560);
	     setLocationRelativeTo(null);
	     setVisible(true);
	}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Object source=e.getSource();
			
			if(source == this.back) {
				Anmeldung anm = new Anmeldung("Anmeldung");
				dispose();
			}
			
			if(source == this.bmi) {
				Bmi bmi = new Bmi("BMI");
				dispose();
			}
			
			if(source == this.cowert) {
				CoValue co = new CoValue("Co2 Value");
				dispose();
			}
			
			if(source == this.trainingPulse) {
				TrainingPulse basal = new TrainingPulse("training pulse");
				dispose();
			}
			
			if(source == this.liquidNeeds) {
				LiquidNeeds liq = new LiquidNeeds("liquid needs");
				dispose();
			}
			
			if(source == this.grundumsatz) {
				Basalmetabolism basal = new Basalmetabolism("basal metabolism");
				dispose();
			}
			
			
			
		}

}

