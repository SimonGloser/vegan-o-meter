package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Anmeldung extends JFrame{
	
	//Stepp 1 generate komponents
	
	JButton newAccount;
	JButton submit;
	JPanel panel;
	JLabel emailLabel;
	JLabel passwordLabel;
	
	JTextField emailField;
	JPasswordField password;
	
	public Anmeldung(String s) {
		super(s);
	
	
	// Step 2: determine attributes of the components
	
	newAccount = new JButton("New Account");
	submit = new JButton("Submit");
	
	emailLabel = new JLabel("Email: ");
	emailField = new JTextField(20);
	passwordLabel = new JLabel("Password: ");
	password = new JPasswordField(10);
	
	// Step 3: generate containers for the components
	 panel = new JPanel();
     Container content = getContentPane();
     
  // Step 4: determine a layout manager
     panel.setLayout( new GridLayout(4, 3));
     content.setLayout( new FlowLayout());
     
  // Step 5: add the components to the containers and put the containers
     // into the main window
     panel.add(emailLabel);
     panel.add(emailField);
     panel.add(passwordLabel);
     panel.add(password);
     panel.add(newAccount);
     panel.add(submit);
     
     content.add(panel);
     
  // Step 6: Event Handling
     
  // Step 7: display main window
     
     pack();
     setSize(780, 560);
     setLocationRelativeTo(null);
     setVisible(true);
	
	}

}
