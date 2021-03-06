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
			w.write(FILEHEADER);
			w.write(NEWLINE);
			
			//write to file for each contestant
			
			for (Contestant c : myList.getList()) {
				w.write(c.getFName());
				w.write(DELIMITER);
				w.write(c.getLName());
				w.write(DELIMITER);
				String mInit = c.getMInit();
				//Will append mInit if there, and a blank otherwise
				if (mInit == null) {
					w.write("");
				} else {
					w.write(mInit);
				}
				w.write(DELIMITER);
				w.write(c.getLowerAge() +"-" + c.getUpperAge());
				w.write(DELIMITER);
				w.write(c.getPhoneNo());
				w.write(DELIMITER);
				w.write(c.getEmail());
				w.write(DELIMITER);
				w.write(c.getImg());
				w.write(DELIMITER);
				w.write("" + c.getRating());
				w.write(NEWLINE);
			}
						
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