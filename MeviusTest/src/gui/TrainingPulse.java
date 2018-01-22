package gui;

import controler.*;
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

import org.jfree.ui.RefineryUtilities;

import model.Calculator;

/**
 * 
 * 
 * @author Philipp Manasek
 * @date 2017-12-28
 * @brief This frame calculates the trainings pulse of the user. The user has also the
 *  possibility to save its values in the database
 *
 */
public class TrainingPulse extends JFrame implements ActionListener {
	
	//Stepp 1 generate komponents
	
    JButton back;
    JButton save;
    JButton plot;
    JPanel panelAccountButton;
    JPanel panel;
    JTextField ageField;
	JTextField pulseField;
	JButton submit;	
	JLabel ageLabel;
    JLabel pulseLabel;
    
	
	
	public TrainingPulse(String s) {
		super(s);
		
		// for the Labels
		back = new JButton("back");
		pulseLabel = new JLabel("Your trainings pulse: ", JLabel.RIGHT);
		ageLabel = new JLabel("Your age: ", JLabel.RIGHT);
		ageField = new JTextField(10);
		pulseField = new JTextField(10);
		plot = new JButton("Plot");
		
		save = new JButton("save");
		submit = new JButton("calculate");
		 submit.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                calculate();
	            }
	        });
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
	    back.addActionListener(this);
	    save.addActionListener(this);
	  
	     
	    // Step 5: add the components to the containers and put the containers
	    // into the main window
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	     
	    panel.add(ageLabel,gbc);
	    gbc.gridx = 1;
	    gbc.gridy = 0;
	    
	    panel.add(ageField,gbc);
	    
	    
	    gbc.gridx = 0;
	    gbc.gridy = 3;
	    
	    panel.add(back,gbc);
	    
	    
	    
	    gbc.gridx = 1;
	    gbc.gridy = 1;
	    
	    panel.add(submit,gbc);
	    
	    
	    gbc.gridx = 0;
	    gbc.gridy = 2;
	  
	    panel.add(pulseLabel,gbc);
	    
	    gbc.gridx = 1;
	    gbc.gridy = 2;
	    
	    panel.add(pulseField,gbc);
	     
	    gbc.gridx = 1;
	    gbc.gridy = 3;
	    
	    panel.add(save,gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 4;
	    
	    panel.add(plot,gbc);
	     
	    gbc.insets.set(10, 5, 50, 5);
		    
	    content.add(panel, gbc);
		
		// Step 6: Event Handling
        addWindowListener(new WindowClosingAdapter());
        plot.addActionListener(this);
	
        // Step 7: display main window
    
        pack();
        setSize(780, 560);
        setLocationRelativeTo(null);
        setVisible(true);
	    }
	
    @Override
    public void actionPerformed(ActionEvent e) {
		
		Object source=e.getSource();
		
		if(source == this.save) {
			float value = Float.parseFloat(pulseField.getText().replace(',', '.'));
			controler.Main.controlerSavePulse((int)value);
		}
		
		if(source == this.back) {
			Veganometer veg = new Veganometer("Veganometer");
			dispose();
		}
		if(source == this.plot) {
			LineChart_AWT chart = new LineChart_AWT(
			         "Trainings Pulse" ,//Titel im Frame
			         "Your personal pulse chart"); //Titel über der Grafik

			      chart.pack( );
			      RefineryUtilities.centerFrameOnScreen( chart );
			      chart.setVisible( true );
		}
	
     }
  private void calculate() {
        
        int age; 
        int pulseValue;
        
        age = Integer.parseInt(ageField.getText());
        pulseValue = Calculator.getTrainingsPuls(age);
        

        //Ausgabe
        
       pulseField.setText(Float.toString(pulseValue).replace('.', ','));
        
    }
	
}
