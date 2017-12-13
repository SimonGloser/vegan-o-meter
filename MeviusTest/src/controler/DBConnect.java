package controler;
import java.sql.*;

public class DBConnect {
	
	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	public DBConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vegandata", "root", ""); // test und "" müssen geändert werden
		     st = con.createStatement();
		 } catch (Exception ex) {
		     System.out.println("Error: " + ex);
		     
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
		  String iban= rs.getString("iban");
		  System.out.println("Name: " + name + " ID: " + id + "Surname" + surname + "IBAN"+ iban);
		     }
		 } catch(Exception ex) {
		     System.out.println(ex);
		 }
		    }
	 
	 public int getWeight(int id) {
		 int gewicht = 0;
		 try {
			 String query = "select weight from coBilanz where id = " +id;
		     rs = st.executeQuery(query);
			 while(rs.next()) {
				  gewicht = rs.getInt("weight");
				 //System.out.println("Weight = " + gewicht);
				
			 }
			 
			
		} catch (Exception ex) {
			
			System.out.println(ex);
			return 0;
		}
		 
		return gewicht;
		
	 }
		

}
