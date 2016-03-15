/*
 * TCSS360 LibraryColoringContest Team Pedestrian
 */

package model;

import java.io.File;

/**
 * Holds all the fields needed for a Contestant object. 
 * @author Andy Bleich
 *
 */
public class Contestant {

	private String contFName;
	
	private String contLName;
	
	private String contMInit;
	
	private int[] contAgeRange = new int[2];
	
	private String contPhoneNo;
	
	private String contEmail;
	
	private String imgURL;
	
	private File contImage;
	
	private int imgRating;
	
	/**
	 * Constructor to populate a Contestant if all fields are given. 
	 * @param fName First name
	 * @param lName Last name
	 * @param mInit Middle initial
	 * @param ageRange Age range for the contestant
	 * @param phoneNo Phone Number
	 * @param email Contestant email 
	 */
	public Contestant(String fName, String lName, String mInit, int[] ageRange,
						String phoneNo, String email) {
		contFName = fName;
		contLName = lName;
		contMInit = mInit;
		contAgeRange[0] = ageRange[0];
		contAgeRange[1] = ageRange[1];
		contPhoneNo = phoneNo;
		contEmail = email;
		imgRating = -1;
		
	}
	
	/**
	 * Blank constructor to create a blank contestant. 
	 */
	public Contestant() {
		contFName = null;
		contLName = null;
		contMInit = null;
		contPhoneNo = null;
		contEmail = null;
		imgRating = -1;
	}
	//Getters and setters for each field. 
	public void setFName(String fName) {
		contFName = fName;
	}
	
	public void setLName(String lName) {
		contLName = lName;
	}
	
	public void setMInit(String mInit) {
		contMInit = mInit;
	}
	
	public void setPhoneNo (String phoneNo) {
		contPhoneNo = phoneNo;
	}
	
	public void setEmail(String email) {
		contEmail = email;
	}
	
	public void setAgeRange(int[] aR) {
		contAgeRange[0] = aR[0];
		contAgeRange[1] = aR[1];
	}
	
	public void setImgURL(String theURL) {
		imgURL = theURL;
	}
	
	public String getImg() {
		return imgURL;
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
	
	public void rateImage(int rating) {
		imgRating = rating;
	}
	
	public int getRating() {
		return imgRating;
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
	
	public String getFName() {
		return contFName;
	}
	
	public String getLName() {
		return contLName;
	}
	
	public String getMInit() {
		return contMInit;
	}
	
	public int getLowerAge() {
		return contAgeRange[0];
	}
	
	public int getUpperAge() {
		return contAgeRange[1];
	}
	
}
