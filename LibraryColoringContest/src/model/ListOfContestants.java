/*
 * TCSS360 LibraryColoringContest Team Pedestrian
 */

package model;

import java.util.ArrayList;
import java.util.List;

public class ListOfContestants {

	private List<Contestant> contestants;
	
	public ListOfContestants() {
		contestants = new ArrayList<Contestant>();
	}
	
	/**
	 * This method will return true if the person was successfully added, but false
	 * if they already exist in the list.
	 * 
	 * @param theContest The new Contestant being added.
	 * @return True if parameter is added to list and false otherwise.
	 */
	public boolean addContestant(Contestant theContest) {
		boolean result = verifyEmail(theContest);
		
		if (result) {
			contestants.add(theContest);
		}
		
		return result;
	}
	
	/**
	 * This method will check to see if this contestant has already registered.
	 * 
	 * @param theContest The contestant being checked.
	 * @return True if this email doesn't exist yet. False if this email has already been used.
	 */
	public boolean verifyEmail(Contestant theContest) {
		boolean result = true;
		
		for(Contestant c : contestants) {
			if (theContest.getEmail().equals(c.getEmail())) {
				result = false;
			}
		}
		
		return result;
	}
	
	public List<Contestant> getList() {
		return contestants;
	}
}