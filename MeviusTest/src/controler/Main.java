package controler;
import model.*;
import gui.*;



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
	
	public static void controlerSaveBMI(int value) {
		//System.out.println("BMI = " + value + "id = " + user.getId());
		connect.addBMIValue(value, user.getId());
		
	}
	public static void controlerSavePulse(int value) {
		connect.addPulseValue(value, user.getId());
	}

}

