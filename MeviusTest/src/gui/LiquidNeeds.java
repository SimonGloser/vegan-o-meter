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

import model.Calculator;

/**
 * 
 * 
 * @author Philipp
 *
 */
public class LiquidNeeds extends JFrame implements ActionListener {
	
	//Stepp 1 generate komponents
	
    JButton back;
    JPanel panelAccountButton;
    JPanel panel;
    JLabel weightLabel;
    JLabel liqLabel;
    JButton submit;
    JButton save;
	JTextField weightField;
	JTextField liqField;
	
	
	public LiquidNeeds(String s) {
		super(s);
		
		// for the Labels
		back = new JButton("back");
		weightLabel = new JLabel("Your weight in kg: ", JLabel.RIGHT);
		liqLabel = new JLabel("Your liquid needs in ml: ", JLabel.RIGHT);
		weightField = new JTextField(10);
		liqField = new JTextField(10);
		
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
	     
	    // Step 5: add the components to the containers and put the containers
	    // into the main window
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	     
	    panel.add(weightLabel,gbc);
	    gbc.gridx = 1;
	    gbc.gridy = 0;
	    
	    panel.add(weightField,gbc);
	    
	    
	    gbc.gridx = 0;
	    gbc.gridy = 3;
	    
	    panel.add(back,gbc);
	    
	    
	    
	    gbc.gridx = 1;
	    gbc.gridy = 1;
	    
	    panel.add(submit,gbc);
	    
	    
	    gbc.gridx = 0;
	    gbc.gridy = 2;
	  
	    panel.add(liqLabel,gbc);
	    
	    gbc.gridx = 1;
	    gbc.gridy = 2;
	    
	    panel.add(liqField,gbc);
	    
	    gbc.gridx = 1;
	    gbc.gridy = 3;
	    
	    panel.add(save,gbc);
	     
	    gbc.insets.set(10, 5, 50, 5);
		    
	    content.add(panel, gbc);
		
		// Step 6: Event Handling
        addWindowListener(new WindowClosingAdapter());
        save.addActionListener(this);
    
	
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
			float value = Float.parseFloat(liqField.getText().replace(',', '.'));
			controler.Main.contolerSaveLiquid((int)value);
		}
		
		if(source == this.back) {
			Veganometer veg = new Veganometer("Veganometer");
			dispose();
		}
	
     }
	
  private void calculate() {
        
        float weight; 
        float liqValue;
        
        weight = Float.parseFloat(weightField.getText().replace(',', '.'));
        liqValue = Calculator.getLiquidNeeds(weight);
        

        //Ausgabe
        
       liqField.setText(Float.toString(liqValue).replace('.', ','));
        
    }

	
}




