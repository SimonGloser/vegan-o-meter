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
	
	public static void controlerNewCustomer(String name, String surname,
			String email, String iban, String password) {
		connect.newCustomer(name, surname, email, iban, password);
	}
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
	
	
	public static void controlerSaveBMI(int value) {
		//System.out.println("BMI = " + value + "id = " + user.getId());
		connect.addBMIValue(value, user.getId());
		
	}
	public static void controlerSavePulse(int value) {
		connect.addPulseValue(value, user.getId());
	}
	public static void controlerSaveCO(double value) {
		connect.addCOValue(value, user.getId());
	}
	
	public static void controlerSaveMetabolism(int value) {
		
		connect.addMetabolismValue(value, user.getId());
	}
	public static void contolerSaveLiquid(int value) {
		connect.addLiquidNeedsValue(value, user.getId());
	}
	public static void controlerSaveCoValue(int value) {
		connect.addCOValue(value, user.getId());
	}
	
	public static DefaultCategoryDataset controlerGetBMISet() {
		return connect.getAllBMI(user.getId());
	}
	
	public static DefaultCategoryDataset controlerGetLiquid() {
		return connect.getAllLiquis(user.getId());
	}
	
	public static DefaultCategoryDataset controlerGetMetabol() {
		return connect.getAllMetabol(user.getId());
	}
	
	public static DefaultCategoryDataset controlerGetPulse() {
		return connect.getAllPulse(user.getId());
	}
	
	public static DefaultCategoryDataset controlerGetCo() {
		return connect.getCOVallues(user.getId());
	}

}

