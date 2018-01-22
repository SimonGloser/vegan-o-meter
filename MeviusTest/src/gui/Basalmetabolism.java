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
import javax.swing.JToggleButton;

import org.jfree.ui.RefineryUtilities;

import model.Calculator;

/**
 * 
 * 
 * @author Philipp
 *
 */
public class Basalmetabolism extends JFrame implements ActionListener {
	
	//Stepp 1 generate komponents
	    boolean gender =true;
	    JButton back;
	    JButton save;
	    JButton plot;
	    JToggleButton male;
	    JToggleButton female;
	    JPanel panelAccountButton;
	    JPanel panel;
	    JLabel weightLabel;
		JLabel heightLabel;
		JLabel ageLabel;
		JTextField weightField;
		JTextField heightField;
		JTextField ageField;
		JButton submit;
		JLabel basalLabel;
		JTextField basalField;
		
		
	
	
	public Basalmetabolism(String s) {
		super(s);
		
		plot = new JButton("Plot");
		
		// for the Labels
		back = new JButton("back");
		
		basalLabel = new JLabel("Your basal metabolsim rate: ", JLabel.RIGHT);
		heightLabel = new JLabel("Your height in cm: ", JLabel.RIGHT);
		weightLabel = new JLabel("Your weight in kg: ", JLabel.RIGHT);
		ageLabel = new JLabel("Your age: ", JLabel.RIGHT);
		save = new JButton("save");
		
		submit = new JButton("calculate");
		 submit.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                calculate();
	            }
	        });
		 
		 male = new JToggleButton("male", false);
		 male.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                gender=true;
	            }
	        }); 
		 
		 female = new JToggleButton("female",false);
		 female.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                gender=false;
	            }
	        });
		  
		
		weightField = new JTextField(10);
		heightField = new JTextField(10);
		ageField = new JTextField(10);
		basalField = new JTextField(10);
		
		// Step 3: generate containers for the components
		panel = new JPanel();
		panelAccountButton = new JPanel();
				
		Container content = getContentPane();
			     
		// Step 4: determine a layout manager
		panel.setLayout( new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    gbc.insets = new Insets(6, 6, 6, 6);
	      
	    content.setLayout(new GridBagLayout());
	     
	    panelAccountButton.setLayout(new BorderLayout());	 
	    back.addActionListener(this);
	    
	    // Step 5: add the components to the containers and put the containers
	    // into the main window
	   
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    
	    panel.add(male, gbc);
	     
	    gbc.gridx = 1;
	    gbc.gridy = 0;	
	    
	    panel.add(female,gbc);
	    
	    
	    
	    
	    
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    
	    panel.add(heightLabel, gbc);
	     
	    gbc.gridx = 1;
	    gbc.gridy = 1;	
	    
	    panel.add(heightField,gbc);
	    gbc.gridx = 0;
	    gbc.gridy = 2;
	     
	    panel.add(weightLabel,gbc);
	    gbc.gridx = 1;
	    gbc.gridy = 2;
	    
	    panel.add(weightField,gbc);
	    
	    
	  
	    
	    
	    
	    gbc.gridx = 1;
	    gbc.gridy = 4;
	    
	    panel.add(submit,gbc);
	   
	    gbc.gridx = 0;
	    gbc.gridy = 3;
	  
	    panel.add(ageLabel,gbc);
	    
	    gbc.gridx = 1;
	    gbc.gridy = 3;
	  
	    panel.add(ageField,gbc);
	  
	  
	    
	    gbc.gridx = 0;
	    gbc.gridy = 5;
	  
	    panel.add(basalLabel,gbc);
	    
	    gbc.gridx = 1;
	    gbc.gridy = 5;
	    
	    panel.add(basalField,gbc);
	    gbc.gridx = 0;
	    gbc.gridy = 6;
	    
	    panel.add(back,gbc);
	    
	    gbc.gridx = 1;
	    gbc.gridy = 6;
	    
	    panel.add(save,gbc);
	     
	    gbc.gridx = 0;
	    gbc.gridy = 7;
	    
	    panel.add(plot,gbc);
	     
	    gbc.insets.set(10, 10, 50, 10);
		    
	    content.add(panel, gbc);
		
		// Step 6: Event Handling
        addWindowListener(new WindowClosingAdapter());
        save.addActionListener(this);
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
			float value = Float.parseFloat(basalField.getText().replace(',', '.'));
			controler.Main.controlerSaveMetabolism((int)value);
		}
		
		if(source == this.back) {
			Veganometer veg = new Veganometer("Veganometer");
			dispose();
		}
		if(source == this.plot) {
			LineChart_AWT chart = new LineChart_AWT(
			         "Basal Metabolism" ,//Titel im Frame
			         "Your personal metabolism chart"); //Titel über der Grafik

			      chart.pack( );
			      RefineryUtilities.centerFrameOnScreen( chart );
			      chart.setVisible( true );
		}
	
     }
    private void calculate() {
        
        float weight;
        int height;
        int age;
     
        int basalValue;
        

        
        age = Integer.parseInt(ageField.getText());
        height = Integer.parseInt(heightField.getText());
        weight = Float.parseFloat(weightField.getText().replace(',', '.'));

      
        
        basalValue = Calculator.getGrundumsatz(gender,weight,height,age);
        

        //Ausgabe
        
       basalField.setText(Integer.toString(basalValue));
        
    }	
	
}

