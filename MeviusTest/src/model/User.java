package model;
/**
 * 
 * @author Armin Beirektsevik
 * @date 2017-12-12
 * @brief The user class cantains the loged in user`s id.
 *  The id is needed to receive the correct data the database
 *
 */
public class User {
	 private int id;
	
	public User() {
		id = 0;
	}
/**
 * 
 * @return Returns the user`s id
 */
	public int getId() {
		return id;
	}
	/**
	 * 
	 * @param id Needs the user`s id.
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	

}
