package model;
/**
 * 
 * @author Simon Gloser
 * @date 12.12.2017
 * @brief This class contains all calculation methods.
 *
 */
public interface Calculator {
	
	public static float getCoWert( int grundumsatz,float factorSport, 
			float factorEssen, float facktorTiefkuel, float factorEinkauf) {
		
		
		
		return (float) ((1.13)*(grundumsatz/2400.0)*factorSport*factorEssen*facktorTiefkuel*factorEinkauf);
	}
	
	/**
	 * @brief This method calculates the basal metabolic rate.
	 *  There are two seperate formula for male and female.
	 * @param gender 
	 * @param mass
	 * @param height
	 * @param age
	 * @return The formula calculates a float value, but we change the result to an int value.
	 */
	public static int getGrundumsatz(boolean gender,float mass, int height, int age ) {
		// gender = 1 = true bedeutet Mann
		// gender = 0 = false bedeutet Frau
		// Grundumsatzbeim Mann(m.h,a)= 66.5+13.7*m+5*l-6.8*a
		// Grundumsatz bei Frau (m, h, a) = 655 + 9.6*m+ 1.8*h + -4.7 *a
		if(gender== false) {
			//für eine Frau
			return (int)(655 + 9.6*mass+ 1.8*height + -4.7 *age);
		}
		else {
			return (int)(66.5+13.7*mass+5*height-6.8*age);
		}
		
		
	}
	/**
	 * @brief This method calculates the BMI.
	 * @param mass
	 * @param height
	 * @return
	 */
	public static float getBMI(float mass, int height) {
		
		
		return(float)(Math.round(10.0*(10000*mass/(height*height)))/10.0);
	}
	/**
	 * @biref This method calculates the liquid needs of  the customer.
	 * @param mass
	 * @return
	 */
	public static int getLiquidNeeds(float mass) {
		//die Methode gibt den Flüssigkeitsbedarf in ml (Milliliter ) zurück
		return (int)(1500+15*(mass-20));
	}
	/**
	 * @autor Simon Gloser
	 * @date 05.11.2017
	 * @brief This methode calculates the users training pulse.
	 * @param age Need the age form the user.
	 * @return Returns the pulse of the user.
	 */
	public static int getTrainingsPuls(int age) {
		// wird durch die Karvonen-Formel aus der Wikipedia berechnet
		return (int)(((220-age)-70)*0.5+70);
	}

}
