package controler;
import model.*;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//DBConnect connect = new DBConnect(); 
		
		//System.out.println("Gewicht = " +connect.getWeight(1));
		//boolean gender,float mass, float height, int age 
		//connect.getData();
		System.out.println("Grundumsatz = " + CoRechner.getGrundumsatz(false, (float) 55.6, 166, 32));
		
		//System.out.println("Hat wohl funktioniert");
		// Ich bin auf dem richtigen branch
	}

}
