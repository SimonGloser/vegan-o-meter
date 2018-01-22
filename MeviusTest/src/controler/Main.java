package controler;
import model.*;

import org.jfree.data.category.DefaultCategoryDataset;

import gui.*;


/**
 * 
 * @author simongloser
 * @brief This class is the controler. It receives the data
 *  form the GUI and send them to the model.
 *
 */
public class Main implements Calculator {
	// DBConnect verbindet sich mit der Datenbank und hat die Anfragebefehle
	private static final DBConnect connect = new DBConnect();
	private static User user = new User();
	public static void main(String[] args) {
		
		
		//DBConnect connect = new DBConnect(); 
		//connect.newCustomer("Hans", "Lenz", "ssddssa@dfd", "DE533", "Password");
		//connect.getData();
		
		// Öffnet die GUI
		Anmeldung neuesFenster = new Anmeldung("Anmeldung");
		
	}
	/**
	 * @brief Receives all date from the GUI and forward it to DBConnect
	 * @param name Name of the user.
	 * @param surname Surname of the user.
	 * @param email Email of the user.
	 * @param iban Iban of the user.
	 * @param password Password of the user.
	 */
	public static void controlerNewCustomer(String name, String surname,
			String email, String iban, String password) {
		connect.newCustomer(name, surname, email, iban, password);
	}
	/**
	 * @brief Checks if the user is in the database.
	 * @param email
	 * @param passwordGUI
	 * @return Returns true if the user is in the database
	 */
	public static boolean controlerCheckCustomer(String email, String passwordGUI) {
		
		String passwordData = connect.getPassword(email);
		if(passwordData.equals(passwordGUI)) {
			user.setId(connect.getUserID(email));
			return true;
			//System.out.println("Nutzer bestätigt");
			
		}
		else {
		System.out.println("Nutzer nicht im System");
		return false;
		}
	}
	// ab hier sind die Methoden, die DBconnect anweisen
	//neue eintäge in der Datenbank anzulegen
	
	/**
	 * @brief Calls the DBConnect class
	 * @param value Get the BMI value form the GUI
	 */
	public static void controlerSaveBMI(int value) {
		//System.out.println("BMI = " + value + "id = " + user.getId());
		connect.addBMIValue(value, user.getId());
		
	}
	/**
	 * @breif Calls the DBConnect class
	 * @param value Get the pulse value from the GUI
	 */
	public static void controlerSavePulse(int value) {
		connect.addPulseValue(value, user.getId());
	}
	/**
	 * @brief Calls the DBConnect class
	 * @param value Get the co value from the GUI
	 */
	public static void controlerSaveCO(double value) {
		connect.addCOValue(value, user.getId());
	}
	/**
	 * @brief Calls the DBConnect class
	 * @param value Get the new metabolism value form the GUI.
	 */
	public static void controlerSaveMetabolism(int value) {
		
		connect.addMetabolismValue(value, user.getId());
	}
	/**
	 * @brief Calls the DBConnect class
	 * @param value Receives the user`s liquid needs from the GUI
	 */
	public static void contolerSaveLiquid(int value) {
		connect.addLiquidNeedsValue(value, user.getId());
	}
	/**
	 * @brief Calls the DBConnect class
	 * @param value Receives the user`s co2 value from the GUI
	 */
	public static void controlerSaveCoValue(int value) {
		connect.addCOValue(value, user.getId());
	}
	
	//hier beginnen die returns zu GUI
	/**
	 * 
	 * @return Returns the BMI dataset to the GUI
	 */
	public static DefaultCategoryDataset controlerGetBMISet() {
		return connect.getAllBMI(user.getId());
	}
	/**
	 * 
	 * @return Returns the Liquid needs dataset to the GUI
	 */
	public static DefaultCategoryDataset controlerGetLiquid() {
		return connect.getAllLiquis(user.getId());
	}
	/**
	 * 
	 * @return Returns the basal metabolism dataset to the GUI
	 */
	public static DefaultCategoryDataset controlerGetMetabol() {
		return connect.getAllMetabol(user.getId());
	}
	/**
	 * 
	 * @return Returns the pulse dataset to the GUI.
	 */
	public static DefaultCategoryDataset controlerGetPulse() {
		return connect.getAllPulse(user.getId());
	}
	/**
	 * 
	 * @return Returns co dataset tho the GUI.
	 */
	public static DefaultCategoryDataset controlerGetCo() {
		return connect.getCOVallues(user.getId());
	}

}

