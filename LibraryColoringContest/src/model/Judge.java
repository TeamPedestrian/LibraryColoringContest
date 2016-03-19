/*
 * TCSS360 LibraryColoringContest Team Pedestrian
 */

package model;

import java.util.ArrayList;

/**
 * 
 * @author Gabriel Houle
 *
 */
public class Judge {

	/**
	 * String to store the username of a judge.
	 */
	private final String userName;
	
	/**
	 * String to store a password for a judge
	 */
	private final String password;
	
	/**
	 * String to store the name of a judge.
	 */
	private String name;
	
	/**
	 * List would be used to store contest if multiple judges used. 
	 */
	public ArrayList<Contestant> contestantList;
	
	/**
	 * Constructor for a judge.
	 * @param theUser user name for the judge.
	 * @param thePass password for the judge.
	 */
	public Judge(String theUser, String thePass) {
		userName = theUser;
		password = thePass;
		name = "";
		contestantList = new ArrayList<>();
	}
	
	/**
	 * Method to check if a judge can sign on (exist)
	 * @param theUserName
	 * @param thePassword
	 * @return true if the judge is active and its correct password. 
	 */
	public boolean logOn(String theUser, String thePass) {
		boolean result = false;
		
		if (theUser.equals(userName) && thePass.equals(password)) {
			result = true;
		}

		return result;
	}
	
	/**
	 * Setter for a name
	 * @param theName
	 */
	public void setName(String theName) {
		name = theName;
	}
	
	/**
	 * getter for a name.
	 * @return theName
	 */
	public String getName() {
		return name;
	}
}