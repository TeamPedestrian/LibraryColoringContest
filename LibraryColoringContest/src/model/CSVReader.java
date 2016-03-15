package model;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class containing methods to populate the List of Contestants 
 * from a csv file. 
 * @author Andy Bleich
 *
 */
public class CSVReader {
	
	private static final String DELIMITER = ",";
	
	private ListOfContestants myList;
	
	//Statics to get values from split array
	private static final int FNAME_IDX = 0;
	private static final int LNAME_IDX = 1;
	private static final int MINIT_IDX = 2;
	private static final int AGE_IDX = 3;
	private static final int PHONENO_IDX = 4;
	private static final int EMAIL_IDX = 5;
	private static final int IMG_IDX = 6;
	private static final int IMG_RATING_IDX = 7;
	
	/**
	 * Constructor for the CSV reader. Populates a list of 
	 * Contestants. 
	 * @param theList List of Contestants to be populated. 
	 */
	public CSVReader (ListOfContestants theList) {
		myList = theList;
	}
	
	/**
	 * Reads in from CSV file given in filePath. 
	 * @param filePath Path to file being read. 
	 */
	public void readCSV(String filePath) {
		
		BufferedReader r = null;
		
		try {
			
			String line = "";
			r = new BufferedReader(new FileReader(filePath));
			
			//skips header line
			r.readLine();
			
			while ((line = r.readLine()) != null) {
				String[] tokens = line.split(DELIMITER);
				if (tokens.length > 0) {
					Contestant c = new Contestant();
					c.setFName(tokens[FNAME_IDX]);
					c.setLName(tokens[LNAME_IDX]);
					//if Middle initial exists, add it
					if (!tokens[MINIT_IDX].equals("")) {
						c.setMInit(tokens[MINIT_IDX]);
					}
					//changes string of age into int array
					int[] age = new int[2];
					String ageRange = tokens[AGE_IDX];
					String[] a = ageRange.split("-");
					age[0] = Integer.parseInt(a[0]);
					age[1] = Integer.parseInt(a[1]);
					c.setAgeRange(age);
					c.setPhoneNo(tokens[PHONENO_IDX]);
					c.setEmail(tokens[EMAIL_IDX]);
					c.setImgURL(tokens[IMG_IDX]);
					c.rateImage(Integer.parseInt(tokens[IMG_RATING_IDX]));
					myList.addContestant(c);
				}
			}
			System.out.println("CSV read in");
		} catch (Exception e) {
			System.out.println("Error in CSV read!");
			e.printStackTrace();
		} finally {
			try {
				r.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
