/*
 * TCSS360 LibraryColoringContest Team Pedestrian
 */

package model;

public class Judge {

	private final String userName;
	
	private final String password;
	
	private String name;
	
	public ListOfContestants contestantList;
	
	public Judge(String theUser, String thePass) {
		userName = theUser;
		password = thePass;
		name = "";
		contestantList = new ListOfContestants();
	}
	
	public boolean logOn(String theUser, String thePass) {
		boolean result = false;
		
		if (theUser.equals(userName) && thePass.equals(password)) {
			System.out.println("hello");
			result = true;
		}
		
		System.out.println(result + " correctUser: " + userName + " CorrectPassword: " +
							password + " inputUser: " + theUser + " inputpassword: " + thePass);
		
		return result;
	}
	
	public void setName(String theName) {
		name = theName;
	}
	
	public String getName() {
		return name;
	}
}