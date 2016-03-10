/*
 * TCSS360 LibraryColoringContest Team Pedestrian
 */

package model;

import java.io.File;

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
	
	public Contestant() {
		contFName = null;
		contLName = null;
		contMInit = null;
		contPhoneNo = null;
		contEmail = null;
		imgRating = -1;
	}
	
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
	
}
