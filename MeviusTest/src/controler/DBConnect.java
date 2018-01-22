package controler;

import java.sql.*;

import org.jfree.data.category.DefaultCategoryDataset;

/**
 * 
 * @author simon gloser
 * @breif This class connects the application white the Database and is in
 *        charge for updates and queries
 *
 */
public class DBConnect {

	private Connection con;
	private Statement st;
	private ResultSet rs;

	public DBConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vegandata", "root", ""); // test und ""
																									// müssen geändert
																									// werden
			st = con.createStatement();
		} catch (Exception ex) {
			System.out.println("Error: " + ex);

		}

	}

	public void newCustomer(String name, String surname, String email, String iban, String password) {
		try {
			String query = "insert into person (name, surname, email, iban, password)values(\"" + name + "\",\""
					+ surname + "\",\"" + email + "\",\"" + iban + "\",\"" + password + "\");";

			st.executeUpdate(query);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void getData() {
		try {
			String query = "select * from person";
			rs = st.executeQuery(query);
			System.out.println("Records from Database");
			while (rs.next()) {
				String name = rs.getString("name");
				int id = rs.getInt("id");
				String surname = rs.getString("surname");
				String iban = rs.getString("iban");
				System.out.println("Name: " + name + " ID: " + id + "Surname" + surname + "IBAN" + iban);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public int getWeight(int id) {
		int gewicht = 0;
		try {
			String query = "select weight from coBilanz where id = " + id;
			rs = st.executeQuery(query);
			while (rs.next()) {
				gewicht = rs.getInt("weight");
				// System.out.println("Weight = " + gewicht);

			}

		} catch (Exception ex) {

			System.out.println(ex);
			return 0;
		}

		return gewicht;

	}

	public String getPassword(String email) {

		String password = null;
		try {
			String query = "select password from person where email =\"" + email + "\";";

			rs = st.executeQuery(query);
			while (rs.next()) {

				password = rs.getString("password");

				return password;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return password;
	}

	public void addBMIValue(int value, int id) {
		try {
			String query = "insert into bmi (id_person,bmi, date) values (" + id + "," + value + ",curdate());";
			System.out.println(query);
			st.executeUpdate(query);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void addPulseValue(int value, int id) {
		try {
			String query = "insert into pulse (id_person,pulse, date) values (" + id + "," + value + ",curdate());";
			st.executeUpdate(query);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void addCOValue(int value, int id) {
		try {
			// hier noch die richtigen felder eintegen
			// String query = "insert into coBilanz (id_person,co_value) values (" + id+ ","
			// + value +");";
			// st.executeUpdate(query);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void addMetabolismValue(int value, int id) {
		try {
			String query = "insert into metabol (id_person, metabol, date) values (" + id + "," + value
					+ ",curdate());";
			st.executeUpdate(query);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void addLiquidNeedsValue(int value, int id) {
		try {
			String query = "insert into liquid (id_person, liquid_needs, date) values (" + id + "," + value
					+ ",curdate());";
			st.executeUpdate(query);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * 
	 * @param id
	 *            Needs the ID of the user
	 * 
	 */
	public DefaultCategoryDataset getAllBMI(int id) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		try {
			String query = "select bmi, date from bmi where id_person = " + id + ";";

			rs = st.executeQuery(query);

			while (rs.next()) {

				double val = rs.getDouble("bmi");
				String date = rs.getString("date");

				dataset.addValue(val, "BMI", date);

			}
			return dataset;
		}

		catch (Exception e) {
			System.out.println(e);
		}
		return dataset;
	}
	
	public DefaultCategoryDataset getAllPulse(int id) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		try {
			String query = "select pulse, date from pulse where id_person = " + id + ";";

			rs = st.executeQuery(query);

			while (rs.next()) {

				double val = rs.getDouble("pulse");
				String date = rs.getString("date");

				dataset.addValue(val, "Pulse", date);

			}
			return dataset;
		}

		catch (Exception e) {
			System.out.println(e);
		}
		return dataset;
	}
	
	public DefaultCategoryDataset getAllMetabol(int id) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		try {
			String query = "select metabol, date from metabol where id_person = " + id + ";";

			rs = st.executeQuery(query);

			while (rs.next()) {

				double val = rs.getDouble("metabol");
				String date = rs.getString("date");

				dataset.addValue(val, "Metabol", date);

			}
			return dataset;
		}

		catch (Exception e) {
			System.out.println(e);
		}
		return dataset;
	}
	
	public DefaultCategoryDataset getAllLiquis(int id) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		try {
			String query = "select liquid_needs, date from liquid where id_person = " + id + ";";

			rs = st.executeQuery(query);

			while (rs.next()) {

				double val = rs.getDouble("liquid_needs");
				String date = rs.getString("date");

				dataset.addValue(val, "Liquid Needs", date);

			}
			return dataset;
		}

		catch (Exception e) {
			System.out.println(e);
		}
		return dataset;
	}

	/**
	 * @author Simon Gloser
	 * @param email
	 * @return Returns the id from the user
	 * @brief The Main class need the id form user who had logged in
	 */
	public int getUserID(String email) {
		int i = 0;

		try {
			String query = "select id from person where email =\"" + email + "\";";
			rs = st.executeQuery(query);
			while (rs.next()) {
				i = rs.getInt("id");
				return i;
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return i;
	}
	/*
	 * Befehl zum Fremdschlüssel erstellen bitte nicht löschen Simon Wichtig die
	 * Felder id_person dürfen nicht null sein und muss unsigned sein alter table
	 * bmi add CONSTRAINT fk_bmi FOREIGN KEY (id_person) REFERENCES person(id) ON
	 * DELETE RESTRICT ON UPDATE CASCADE;
	 */

}
