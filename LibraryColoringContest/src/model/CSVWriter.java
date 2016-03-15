package model;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Object containing methods to write the list of Contestants 
 * to a csv file. 
 * @author Andy Bleich
 *
 */
public class CSVWriter {

	private static final String DELIMITER = ",";
	private static final String NEWLINE = "\n";
	
	public static String FILEHEADER = "fName,lName,mInit,ageRange"
			+ ",phoneNo,email,imgURL,imgRating";
	
	private ListOfContestants myList;
		
	/**
	 * Consructor. Populates the list
	 * @param theList List of the contestants
	 */
	public CSVWriter(ListOfContestants theList) {
		myList = theList;
	}
	
	/**
	 * Writes the entire list of Contestants to the csv file for saving between
	 * sessions. 
	 * @param filePath Path to the csv file. 
	 * @author Andy Bleich
	 */
	public void writeToFile(String filePath) {
		
		FileWriter w = null;
		
		try {
			//initialize
			w = new FileWriter(filePath);
			w.append(FILEHEADER);
			w.append(NEWLINE);
			
			//write to file for each contestant
			
			for (Contestant c : myList.getList()) {
				w.append(c.getFName());
				w.append(DELIMITER);
				w.append(c.getLName());
				w.append(DELIMITER);
				String mInit = c.getMInit();
				//Will append mInit if there, and a blank otherwise
				if (mInit == null) {
					w.append("");
				} else {
					w.append(mInit);
				}
				w.append(DELIMITER);
				w.append(c.getLowerAge() +"-" + c.getUpperAge());
				w.append(DELIMITER);
				w.append(c.getPhoneNo());
				w.append(DELIMITER);
				w.append(c.getEmail());
				w.append(DELIMITER);
				w.append(c.getImg());
				w.append(DELIMITER);
				w.append("" + c.getRating());
				w.append(NEWLINE);
			}
			
			System.out.println("CSV printed!");
			
		} catch (Exception e) {
			System.out.println("Error in writing!");
			e.printStackTrace();
		} finally {
			try {
				w.flush();
				w.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
