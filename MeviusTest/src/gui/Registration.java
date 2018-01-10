package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Registration extends JFrame{
	
	//Stepp 1 generate komponents
	JTextField name;
	JTextField surname;
	JTextField email;
	JTextField iban;
	JTextField passwort1;
	JTextField passwordControl;
	
	JLabel labelName;
	JLabel labelSurname;
	JLabel labelEmail;
	JLabel labelIban;
	JLabel labelpassword1;
	JLabel labelpasswordControl;
	
	JButton submit;
	
	JPanel panel;
	
	public Registration(String s) {
		super(s);
		
		// Step 2: determine attributes of the components
		
		// for the JTextFields
		name = new JTextField(22);
		surname = new JTextField(22);
		email = new JTextField(22);
		iban = new JTextField(22);
		passwordControl = new JTextField(22);
		passwordControl = new JTextField(22);
		
		
		// for the Labels
		
		labelName = new JLabel("Name");
		labelSurname = new JLabel("Surname");
		labelEmail = new JLabel("Email");
		labelIban = new JLabel("IBAN");
		labelpassword1 = new JLabel("Password");
		labelpasswordControl = new JLabel("Reenter yout Password");
		
	}

}
