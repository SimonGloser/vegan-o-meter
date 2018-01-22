package gui;

import controler.*;
import model.Calculator;

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
import javax.swing.JToggleButton;

import org.jfree.ui.RefineryUtilities;

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
	 float factorSport;      
   
     float factorComp;
     float factorFreeze;
     float factorShop;
	
	
	JButton back;
	JButton save;
	JButton plot;
    JPanel panelAccountButton;
    JPanel panel;
    JToggleButton sport1;
    JToggleButton sport2;
    JToggleButton comp1;
    JToggleButton comp2;
    JToggleButton comp3;
    JToggleButton comp4;
    JToggleButton freeze1;
    JToggleButton freeze2;
    JToggleButton freeze3;
    JToggleButton shop1;
    JToggleButton shop2;
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
		plot = new JButton("plot");
		
		sport1 = new JToggleButton("yes",false);
		sport1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                factorSport=1.1f;
            }
        }); 
		
		
		sport2 = new JToggleButton("no",false);
		sport2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                factorSport=1.0f;
            }
        }); 
		
		comp1 = new JToggleButton("lots of meat",false);
		comp1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                factorComp=1.3f;
            }
        }); 
		
		
		comp2 = new JToggleButton("mixed diet",false);
		comp2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                factorComp=1.0f;
            }
        }); 
		
		comp3 = new JToggleButton("meat reduced",false);
		comp3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                factorComp=0.8f;
            }
        }); 
		
		comp4 = new JToggleButton("vegetarian",false);
		comp4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                factorComp=0.7f;
            }
        }); 
		
		
		freeze1 = new JToggleButton("sometimes",false);
		freeze1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                factorFreeze=1.0f;
            }
        }); 
		
		freeze2 = new JToggleButton("1-3 times per week",false);
		freeze2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                factorFreeze=1.1f;
            }
        }); 
		
		
		freeze3 = new JToggleButton("daily",false);
		freeze3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                factorFreeze=1.2f;
            }
        }); 
		
		
		
		shop1 = new JToggleButton("supermarket food",false);
		shop1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                factorShop=1.0f;
            }
        }); 
		
		shop2 = new JToggleButton("regional food",false);
		shop2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                factorShop=0.9f;
            }
        }); 
		
		
		calculate = new JButton("calculate");
		 calculate.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                calculate();
	            }
		 });
		
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
	    
	    gbc.gridx = 0;
	    gbc.gridy = 9;
	     
	    panel.add(plot, gbc);
	    
	     
	    gbc.insets.set(10, 5, 50, 5);
		    
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
			// hier den aufruf an den controler einsetzen
			controler.Main.controlerSaveCO(Double.parseDouble(coField.getText()));
			
		}
		
		if(source == this.back) {
			Veganometer veg = new Veganometer("Veganometer");
			dispose();
		}
		if(source == this.plot) {
			LineChart_AWT chart = new LineChart_AWT(
			         "co2 FootPrint" ,//Titel im Frame
			         "Your personal co2 - Footprint chart"); //Titel über der Grafik

			      chart.pack( );
			      RefineryUtilities.centerFrameOnScreen( chart );
			      chart.setVisible( true );
		}
	
     }
 private void calculate() {
        
       
        int basal;
       
        float coValue;

        
        basal = Integer.parseInt(basalField.getText());
      

      
        
        coValue = Calculator.getCoWert(basal,factorSport, factorComp, factorFreeze, factorShop);
        

        //Ausgabe
        
       coField.setText(Float.toString(coValue));
        
    }	
	
}
