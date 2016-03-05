/*
 * TCSS360 LibraryColoringContest Team Pedestrian
 */

package model;

public class Judge {

	private final String userName;
	
	private final String password;
	
	private final String name;
	
	private ListOfContestants contestantList;
	
	public Judge(String theUser, String thePass) {
		userName = theUser;
		password = thePass;
		name = "";
		contestantList = new ListOfContestants();
	}
}
