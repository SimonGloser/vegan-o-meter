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

/**
 * 
 * 
 * @author Philipp
 *
 */
public class CoValue extends JFrame implements ActionListener {
	
	//Stepp 1 generate komponents
	
    JButton back;
    JButton save;
    JPanel panelAccountButton;
    JPanel panel;
    JButton sport1;
    JButton sport2;
    JButton comp1;
    JButton comp2;
    JButton comp3;
    JButton comp4;
    JButton freeze1;
    JButton freeze2;
    JButton freeze3;
    JButton shop1;
    JButton shop2;
    JButton calculate;
    
    JLabel compLabel;
    JLabel freezeLabel;
    JLabel shopLabel;
    JLabel sportLabel;
    JLabel basalLabel;
    JLabel coLabel;
    
    JTextField basalField;
    JTextField coField;
    
	
	
	public CoValue(String s) {
		super(s);
		
		// for the Labels
		back = new JButton("back");
		save = new JButton("save");
		sport1 = new JButton("yes");
		sport2 = new JButton("no");
		comp1 = new JButton("lots of meat");
		comp2 = new JButton("mixed diet");
		comp3 = new JButton("meat reduced");
		comp4 = new JButton("vegetarian");
		freeze1 = new JButton("sometimes");
		freeze2 = new JButton("1-3 times per week");
		freeze3 = new JButton("daily");
		shop1 = new JButton("supermarket food");
		shop2 = new JButton("regional food");
		calculate = new JButton("calculate");
		
		sportLabel = new JLabel("Do you do sports: ", JLabel.RIGHT);
		freezeLabel = new JLabel("How often do you use frozen food: ", JLabel.RIGHT);
		shopLabel = new JLabel("Which food do you buy: ", JLabel.RIGHT);
		compLabel = new JLabel("Your diet behaviour: ", JLabel.RIGHT);
		coLabel = new JLabel("Your co2 emission: ", JLabel.RIGHT);
		
		basalLabel = new JLabel("Your basal metabolsim rate: ", JLabel.RIGHT);
		basalField = new JTextField(10);
		coField = new JTextField(10);
		
		
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
	     
	    panel.add(basalLabel, gbc);
	    
	    gbc.gridx = 1;
	    gbc.gridy = 0;
	     
	    panel.add(basalField, gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	     
	    panel.add(sportLabel, gbc);
	    
	    gbc.gridx = 1;
	    gbc.gridy = 1;
	     
	    panel.add(sport1, gbc);
	    
	    gbc.gridx = 2;
	    gbc.gridy = 1;
	     
	    panel.add(sport2, gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 2;
	     
	    panel.add(compLabel, gbc);
	    
	    gbc.gridx = 1;
	    gbc.gridy = 2;
	     
	    panel.add(comp1, gbc);
	    
	    gbc.gridx = 2;
	    gbc.gridy = 2;
	     
	    panel.add(comp2, gbc);
	    gbc.gridx = 3;
	    gbc.gridy = 2;
	     
	   
	     
	    panel.add(comp3, gbc);
	    
	    gbc.gridx = 4;
	    gbc.gridy = 2;
	     
	    panel.add(comp4, gbc);
	    gbc.gridx = 0;
	    gbc.gridy = 4;
	    
        panel.add(freezeLabel, gbc);
	    
	    gbc.gridx = 1;
	    gbc.gridy = 4;
	     
	    panel.add(freeze1, gbc);
	    
	    gbc.gridx = 2;
	    gbc.gridy = 4;
	     
	    panel.add(freeze2, gbc);
	    gbc.gridx = 3;
	    gbc.gridy = 4;
	     
	   
	    panel.add(freeze3, gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 5;
	     
	    panel.add(shopLabel, gbc);
	    
	    gbc.gridx = 1;
	    gbc.gridy = 5;
	     
	    panel.add(shop1, gbc);
	    
	    gbc.gridx = 2;
	    gbc.gridy = 5;
	     
	    panel.add(shop2, gbc);
	    
	    
	    gbc.gridx = 1;
	    gbc.gridy = 6;
	     
	    panel.add(calculate, gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 7;
	     
	    panel.add(coLabel, gbc);
	    
	    gbc.gridx = 1;
	    gbc.gridy = 7;
	     
	    panel.add(coField, gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 8;
	     
	    panel.add(back, gbc);
	    
	    gbc.gridx = 1;
	    gbc.gridy = 8;
	     
	    panel.add(save, gbc);
	    
	    
	    
	     
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
			// hier den aufruf an den controler einsetzen
			// controler.Main.saveCoValue(int "Wert vom TExtfield")
		}
		
		if(source == this.back) {
			Veganometer veg = new Veganometer("Veganometer");
			dispose();
		}
	
     }
	
	
}

