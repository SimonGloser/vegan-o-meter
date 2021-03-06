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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 * 
 * @author Chris N`Cho
 * @date 2017-11-21
 * @brief In this frame the user has the ability to log in or register
 *
 */
public class Anmeldung extends JFrame implements ActionListener {
	
	//Stepp 1 generate komponents
	
	JButton newAccount;
	JButton submit;
	JPanel panel;
	JLabel emailLabel;
	JLabel passwordLabel;
	JLabel registerJLabel;
	JLabel loginJLabel;
	
	
	//Panel für den Account Button
	JPanel panelAccountButton;
	
	JTextField emailField;
	JPasswordField password;
	
	public Anmeldung(String s) {
		super(s);
	
	
	// Step 2: determine attributes of the components
		
	registerJLabel = new JLabel("Register here:");
	registerJLabel.setHorizontalAlignment(0);
	
	loginJLabel = new JLabel("Or log in here: ");
	
	newAccount = new JButton("create a new account");
	submit = new JButton("Submit");
	
	emailLabel = new JLabel("Email: ", JLabel.RIGHT);
	
	emailField = new JTextField("Please enter your email",20);
	passwordLabel = new JLabel("Password: ", JLabel.RIGHT);
	password = new JPasswordField(10);
	
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
     panelAccountButton.add(registerJLabel, BorderLayout.NORTH);
     panelAccountButton.add(newAccount, BorderLayout.CENTER);
     
     gbc.gridx = 1;
     gbc.gridy = 0;
     
     panel.add(loginJLabel, gbc);
     gbc.gridx = 0;
     gbc.gridy = 1;
     panel.add(emailLabel,gbc);
     gbc.gridx = 1;
     gbc.gridy = 1;
     panel.add(emailField, gbc);
     gbc.gridx = 0;
     gbc.gridy = 2;
     panel.add(passwordLabel, gbc);
     gbc.gridx = 1;
     gbc.gridy = 2;
     panel.add(password, gbc);
    
     gbc.gridx = 1;
     gbc.gridy = 3;
     panel.add(submit, gbc);
     
     gbc.gridx = 1;
     gbc.gridy = 0;
     gbc.insets.set(10, 5, 50, 5);
     content.add(panelAccountButton, gbc);
     gbc.gridx = 1;
     gbc.gridy = 3;
     content.add(panel, gbc);
     
  // Step 6: Event Handling
     addWindowListener(new WindowClosingAdapter());
     newAccount.addActionListener(this);
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
		
		if(source == this.newAccount) {
			Registration neuesFenster1 = new Registration("Registration");
			dispose();
		}
		if(source == this.submit) {
			if(true == controler.Main.controlerCheckCustomer(emailField.getText(),
					String.valueOf(password.getPassword()))){
			Veganometer neuesFenster1 = new Veganometer("Veganometer");
			dispose();
			}else {
				JOptionPane.showMessageDialog(null, "Sorry, wrong password or email",
                        "Dear User", JOptionPane.PLAIN_MESSAGE);
			}
		}
	}

}
