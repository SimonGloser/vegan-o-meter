package controler;
import model.*;
import gui.*;



public class Main implements Calculator {
	// DBConnect verbindet sich mit der Datenbank und hat die Anfragebefehle
	private static final DBConnect connect = new DBConnect();
	public static void main(String[] args) {
		
		
		//DBConnect connect = new DBConnect(); 
		//connect.newCustomer("Hans", "Lenz", "ssddssa@dfd", "DE533", "Password");
		//connect.getData();
		
		// Öffnet die GUI
		Anmeldung neuesFenster = new Anmeldung("Anmeldung");
		
	}
	
	public static void controlerNewCustomer(String name, String surname, String email, String iban, String password) {
		connect.newCustomer(name, surname, email, iban, password);
	}

}

