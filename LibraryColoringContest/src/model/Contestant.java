/*
 * TCSS360 LibraryColoringContest Team Pedestrian
 */

package model;

import java.io.File;

public class Contestant {

	private final String contFName;
	
	private final String contLName;
	
	private final String contMInit;
	
	private final int[] contAgeRange = new int[2];
	
	private final String contPhoneNo;
	
	private final String contEmail;
	
	private File contImage;
	
	public Contestant(String fName, String lName, String mInit, int[] ageRange,
						String phoneNo, String email) {
		contFName = fName;
		contLName = lName;
		contMInit = mInit;
		contAgeRange[0] = ageRange[0];
		contAgeRange[1] = ageRange[1];
		contPhoneNo = phoneNo;
		contEmail = email;
		
	}
	
	public String getEmail() {
		return contEmail;
	}
	
	public void setImage(File thePath) {
		contImage = thePath;
	}
	
	public File getImage() {
		return contImage;
	}
	
	public String getName() {
		StringBuilder sb = new StringBuilder();
		sb.append(contFName);
		sb.append(" ");
		if (contMInit != null) {
			sb.append(contMInit);
			sb.append(" ");
		}
		sb.append(contLName);
		return sb.toString();
	}
	
	public String getPhoneNo() {
		return contPhoneNo;
	}
	
}
