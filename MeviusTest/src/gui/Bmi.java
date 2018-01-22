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
 * @author Philipp
 * @date 12.12.2017
 * @brief This method calculates the BMI of the user. The user has also the
 *  possibility to save its values in the database
 */
public class Bmi extends JFrame implements ActionListener {
	
	 
 
	
	//Stepp 1 generate komponents
	
    JButton back;
    JButton save;
    JButton plot;
    JPanel panelAccountButton;
    JPanel panel;
    JLabel weightLabel;
	JLabel heightLabel;	
	JLabel def;	
	JTextField weightField;
	JTextField heightField;
	JButton submit;
	JLabel bmiLabel;
	JTextField bmiField;

	
	
	public Bmi(String s) {
		super(s);
		
		
		
		// for the Labels
		back = new JButton("back");
		def = new JLabel("");
		plot = new JButton("Plot");
		bmiLabel = new JLabel("Your BMI: ", JLabel.RIGHT);
		heightLabel = new JLabel("Your height in cm: ", JLabel.RIGHT);
		weightLabel = new JLabel("Your weight in kg: ", JLabel.RIGHT);
		save = new JButton("save");
		
		submit = new JButton("calculate");
		 submit.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                calculate();
	            }
	        });
		
		weightField = new JTextField(10);
		heightField = new JTextField(10);
		bmiField = new JTextField(10);
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
	    
	    panel.add(heightLabel, gbc);
	     
	    gbc.gridx = 1;
	    gbc.gridy = 0;	
	    
	    panel.add(heightField,gbc);
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	     
	    panel.add(weightLabel,gbc);
	    gbc.gridx = 1;
	    gbc.gridy = 1;
	    
	    panel.add(weightField,gbc);
	    
	    
	    gbc.gridx = 0;
	    gbc.gridy = 5;
	    
	    panel.add(back,gbc);
	    
	    
	    
	    gbc.gridx = 1;
	    gbc.gridy = 2;
	    
	    panel.add(submit,gbc);
	   
	    gbc.gridx = 0;
	    gbc.gridy = 3;
	  
	    panel.add(def,gbc);
	    
	    
	    gbc.gridx = 0;
	    gbc.gridy = 4;
	  
	    panel.add(bmiLabel,gbc);
	    
	    gbc.gridx = 1;
	    gbc.gridy = 4;
	    
	    panel.add(bmiField,gbc);
	    
	    gbc.gridx = 1;
	    gbc.gridy = 5;
	    
	    panel.add(save,gbc);
	    
	    gbc.gridx = 1;
	    gbc.gridy = 6;
	    
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
			float val = Float.parseFloat(bmiField.getText().replace(',', '.'));
			
			controler.Main.controlerSaveBMI((int)val);
			 
			   }
		if(source == this.plot) {
			LineChart_AWT chart = new LineChart_AWT(
			         "BMI" ,//Titel im Frame
			         "Your personal BMI chart"); //Titel über der Grafik

			      chart.pack( );
			      RefineryUtilities.centerFrameOnScreen( chart );
			      chart.setVisible( true );
			
		}
		


	
		
		if(source == this.back) {
			Veganometer veg = new Veganometer("Veganometer");
			dispose();
		}
		}
	
     
	
    
    private void calculate() {
        
        float weight;
        int height;
        
        float bmiValue;
        

       
      
        height = Integer.parseInt(heightField.getText());
        weight = Float.parseFloat(weightField.getText().replace(',', '.'));

      
        
        bmiValue = Calculator.getBMI(weight,height);
        

        //Ausgabe
        
       bmiField.setText(Float.toString(bmiValue).replace('.', ','));
        
    }

	
}





