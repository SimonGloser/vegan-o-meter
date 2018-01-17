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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Registration extends JFrame implements ActionListener  {
	
	//Step 1 generate komponents
	JTextField name;
	JTextField surname;
	JTextField email;
	JTextField iban;
	JTextField password1;
	JTextField passwordControl;
	
	JLabel labelName;
	JLabel labelSurname;
	JLabel labelEmail;
	JLabel labelIban;
	JLabel labelPassword1;
	JLabel labelPasswordControl;
	
	JButton submit;
	JPanel panelAccountButton;
	JPanel panel;
	
	public Registration(String s) {
		super(s);
		
		// Step 2: determine attributes of the components
		
		// for the JTextFields
		name = new JTextField("Please enter yout name",22);
		surname = new JTextField("Please enter your surname",22);
		email = new JTextField("Please enter your email",22);
		iban = new JTextField("Please enter your IBAN",22);
		password1 = new JTextField("Please enter a password",22);
		passwordControl = new JTextField("Please reenter your password",22);
		
		
		// for the Labels
		submit = new JButton("Submit");
		labelName = new JLabel("Name:",JLabel.RIGHT);
		labelSurname = new JLabel("Surname:",JLabel.RIGHT);
		labelEmail = new JLabel("Email:",JLabel.RIGHT);
		labelIban = new JLabel("IBAN:",JLabel.RIGHT);
		labelPassword1 = new JLabel("Password:",JLabel.RIGHT);
		labelPasswordControl = new JLabel("Reenter yout Password:",JLabel.RIGHT);
		
		
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
	     //gbc.gridx = 0;
	     //gbc.gridy = 0;

	     
	     
	     gbc.gridx = 1;
	     gbc.gridy = 0;
	     panel.add(name, gbc);
	     gbc.gridx = 0;
	     gbc.gridy = 0;
	     panel.add(labelName,gbc);
	     gbc.gridx = 1;
	     gbc.gridy = 1;
	     panel.add(surname, gbc);
	     gbc.gridx = 0;
	     gbc.gridy = 1;
	     panel.add(labelSurname, gbc);
	     gbc.gridx = 1;
	     gbc.gridy = 2;
	     panel.add(email, gbc);
	    
	     gbc.gridx = 0;
	     gbc.gridy = 2;
	     panel.add(labelEmail, gbc);
	     
	     gbc.gridx = 1;
	     gbc.gridy = 3;
	     panel.add(iban, gbc);
	    
	     gbc.gridx = 0;
	     gbc.gridy = 3;
	     panel.add(labelIban, gbc);
	     
	     gbc.gridx = 1;
	     gbc.gridy = 4;
	     panel.add(password1, gbc);
	    
	     gbc.gridx = 0;
	     gbc.gridy = 4;
	     panel.add(labelPassword1, gbc);
	     
	     gbc.gridx = 1;
	     gbc.gridy = 5;
	     panel.add(passwordControl, gbc);
	    
	     gbc.gridx = 0;
	     gbc.gridy = 5;
	     panel.add(labelPasswordControl, gbc);
	     
	     
	     gbc.gridx = 1;
	     gbc.gridy = 6;
	     
	     
	     panel.add(submit, gbc);
	     gbc.gridx = 1;
	     gbc.gridy = 6;
	     
	     gbc.insets.set(10, 5, 50, 5);
	     content.add(panelAccountButton, gbc);
	     gbc.gridx = 1;
	     gbc.gridy = 6;
	     content.add(panel, gbc); 
	     
	     
	     
	     
	  // Step 6: Event Handling
	     addWindowListener(new WindowClosingAdapter());
	     submit.addActionListener(this);
	     
	  // Step 7: display main window
	     
	     pack();
	     setSize(780, 560);
	     setLocationRelativeTo(null);
	     setVisible(true);
		
	     
	     
	     
	     
	  }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source=e.getSource();
		
		
		
		if(source == this.submit) {
			if((password1.getText().equals("Please enter a password"))||
					(passwordControl.getText().equals("Please reenter your password"))) {
				JOptionPane.showMessageDialog(null, "Please enter or reenter a password",
                        "Dear User", JOptionPane.PLAIN_MESSAGE);
			}
			
			if(password1.getText().equals(passwordControl.getText())	) {
			controler.Main.controlerNewCustomer(name.getText(),
					surname.getText(), email.getText(), iban.getText(), password1.getText());
			Veganometer neuesFenster1 = new Veganometer("Veganometer");
			dispose();
			}
			else {
				JOptionPane.showMessageDialog(null, "Password does not confirm",
                        "Dear User", JOptionPane.PLAIN_MESSAGE);
			}
		}
	}

}
