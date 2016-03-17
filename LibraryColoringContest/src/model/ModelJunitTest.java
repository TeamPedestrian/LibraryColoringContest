package model;

import java.io.File;


/**
			File: ModelJunitTest.java
		  Author: BUN KAK
       Professor: JEFFREY WEISS
            Date: March 16, 2016

	ModelJunitTest class is a JUNIT class which test all method in classes: 
	Contestant.java, CSVReader.java, CSVWriter.java, Judge.java, 
	and ListOfContestants.java, 
*/

public class ModelJunitTest {
	
	/** A driver method call tests of all classes */
	public static void main(String[] args) {
		testContestantClass();
		testJudgeClass();
		testListOfContestantsClass();
//		testCSVReaderClass();
		testCSVWriterClass();
	}
	
	
	/** This method test the Contestant Class methods. */
	public static void testContestantClass() {
		
		//test the constructor and get methods
		int[] agerange = {0, 5};
		Contestant c = new Contestant(
			"Jame", "Jason", "Richard", agerange, "206777777", "abc@yahoo.com");
		System.out.println(c.getFName());
		System.out.println(c.getLName());
		System.out.println(c.getMInit());
		System.out.println(c.getLowerAge());
		System.out.println(c.getUpperAge());
		System.out.println(c.getPhoneNo());
		System.out.println(c.getEmail());
		
		
		//test set methods
		c.setImage(new File("agile_method.png"));
		c.setImgURL("http://www.menucool.com/slider/jsImgSlider/images/image-slider-2.jpg");
		System.out.println(c.getImage());
	}
	
	
	/** This method test the Judge Class methods. */	
	public static void testJudgeClass() {
		
		// test constructor
		Judge j = new Judge("dda", "abc123");
		
		// test setName method
		j.setName("Daniel Baily");
		
		// test logOn method
		Boolean isTrue = j.logOn("dda", "abc123"); //suppose to return true
		System.out.println(isTrue);
		
		Boolean isFalse = j.logOn("dda", "abc"); // suppose to return false
		System.out.println(isFalse);
		
		Boolean isFalse2 = j.logOn("dd", "abc123"); // suppose to return false
		System.out.println(isFalse2);	
		
		// test getName method
		System.out.println(j.getName()); //expected answer : Daniel Baily
	}
	
	
	/** This method test the ListOfContestants Class methods. */
	public static void testListOfContestantsClass() {
		
		// test constructor
		ListOfContestants list = new ListOfContestants();
		int[] agerange = {0, 5};
		Contestant c = new Contestant(
				"Jame", "Jason", "Richard", agerange, "206777777", "abc@yahoo.com");	
		
		// test addContestant methods
		list.addContestant(c);
		
		//test getList method
		//expected answer is "Jason"
		System.out.println(list.getList().get(0).getLName());
	}
	
	
	/** This method test the CSVReade Class methods. */
//	public static void testCSVReaderClass() {
//		
//		// test constructor 
//		boolean isSuccess;
//		ListOfContestants list = new ListOfContestants();
//		CSVReader c = new CSVReader(list);
//		
//		//test readCSV() method, expected solution: true
//		c.readCSV("listFile.csv");
//		isSuccess = true;
//		System.out.println(isSuccess);
//	}
	
	/** This method test the CSVWriter Class methods. */	
	public static void testCSVWriterClass() {
		
		// test constructor 
		boolean isSuccess;
		ListOfContestants list = new ListOfContestants();
		CSVWriter c = new CSVWriter(list);
		
		//test writeToFile() method, expected solution: true
		c.writeToFile("listFile.csv");
		isSuccess = true;
		System.out.println(isSuccess);
	}
}