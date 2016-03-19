/*
 * TCSS360 LibraryColoringContest Team Pedestrian
 */

package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.CSVReader;
import model.CSVWriter;
import model.Contestant;
import model.Judge;
import model.ListOfContestants;

/**
 * 
 * 
 * @author Gabriel Houle
 */
@SuppressWarnings("serial")
public class JudgeSignInPanel extends JPanel {
	
	private List<Judge> listOfJudges;
	
	/**
	 * Used for user name input.
	 */
	private JTextField username;
	
	/**
	 * Used for password input.
	 */
	private JTextField password;
	
	/**
	 * Enter Button.
	 */
	private JButton enter;
	
	/**
	 * Used to display next image.
	 */
	private JButton next;
	
	/**
	 * Used to indicate that invalid login info was submitted.
	 */
	private JLabel invalid;
	
	/**
	 * The currently logged in judge.
	 */
	private Judge myJudge = null;
	
	/**
	 * Holds all current contestants to be judged.
	 */
	private ArrayList<Contestant> myContestants;
	
	/**
	 * Holds the current index being displayed.
	 */
	private int currentContestantIndex;
	
	private Contestant currentContestant;
	
	/**
	 * Stores the panel along the bottom of the judge sign in.
	 */
	private JPanel southPanel;
	
	/**
	 * Stores the panel in the center of the judge sign in.
	 */
	private JPanel centerPanel;
	
	/**
	 * Stores the panel along the top of the judge sign in.
	 */
	private JPanel northPanel;
	
	/**
	 * String that stores the user name.
	 */
	private String userString = "";
	
	/**
	 * String that stores the password.
	 */
	private String passString = "";
	
	/**
	 * Displays the image that has been submitted.
	 */
	private JLabel image;
	
	/**
	 * Displays the label for the rating input field.
	 */
	private JLabel ratingLabel;
	
	/**
	 * The text field where the judge will input a rating for the image.
	 */
	private JTextField rating;
	
	/**
	 * Stores the string input by the user.
	 */
	private String rateStr;
	
	private int rateCount;
	
	public JudgeSignInPanel() {
		super();
		rateCount = 0;
		setLayout(new BorderLayout());
		listOfJudges = loadJudges();
		loadContestants();
		setSize(800, 800);
		
		setup();
	}
	
	/**
	 * Loads all registered judges.
	 * 
	 * @return A List containing all judges.
	 */
	private List<Judge> loadJudges() {
		ArrayList<Judge> result = new ArrayList<>();
		
		Judge bob = new Judge("bob1", "1234");
		
		result.add(bob);
		
		return result;
	}
	
	/**
	 * This method will load the contestant info from a file and 
	 * assign them to the judges.
	 */
	private void loadContestants() {
		
		try {
			listOfJudges.get(0).contestantList = 
						(ArrayList<Contestant>) CSVReader.readCSV("contestants.csv").getList();
		} catch (Exception e) {
			
		}
	}
	
	/**
	 * Runs various setup methods and adds button components to the panel.
	 */
	private void setup() {
		
		southPanel = new JPanel();
		southPanel.setBackground(Color.BLACK);
		northPanel = new JPanel();
		northPanel.setBackground(Color.BLACK);
		centerPanel = new JPanel(new GridBagLayout());
		centerPanel.setBackground(Color.BLACK);
		
		invalid = new JLabel("");
		invalid.setForeground(Color.RED);
		southPanel.add(invalid);

		createTextInput();
		
		@SuppressWarnings("unused")
		GhostText userNameGhost = new GhostText(username, "User Name");

		centerPanel.add(username);
		@SuppressWarnings("unused")
		GhostText passGhost = new GhostText(password, "Password");
		centerPanel.add(password);
		centerPanel.add(enter);
		
		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
	}
	
	/**
	 * Creates the text input fields with associated keyListeners for user and password.
	 * Also creates the enter button.
	 */
	private void createTextInput() {
		username = new JTextField(20);
		
		username.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent theEvent) {
				if (theEvent.getKeyCode() != KeyEvent.VK_ENTER) {
					userString = username.getText() + theEvent.getKeyChar();
				}
			}
		});
		
		username.addActionListener(new JudgeLoginListener());
		
		password = new JTextField(20);
		
		password.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent theEvent) {
				if (theEvent.getKeyCode() != KeyEvent.VK_ENTER) {
					passString = password.getText() + theEvent.getKeyChar();
				}
			}
		});
		
		password.addActionListener(new JudgeLoginListener());
		
		enter = new JButton("Enter");
		enter.addActionListener(new JudgeLoginListener());
	}
	
	/**
	 * Checks if there is a judge that has the user supplied log in information.
	 * 
	 * @return True if the correct login information, false otherwise.
	 */
	private boolean verifyUser() {
		boolean result = false;//set this to false in order to actually verify.
		
		for (int i = 0; i < listOfJudges.size(); i++) {
			if (listOfJudges.get(i).logOn(userString, passString)) {
				result = true;
				myJudge = listOfJudges.get(i);
			} else {
				result &= true;
			}
		}
		return result;
	}
	
	/**
	 * Logs judge in and displays all current entries to be judged.
	 */
	private void logon() {
		removeAll();
		setLayout(new BorderLayout());
		invalid.setVisible(false);
		myContestants = myJudge.contestantList;
		displayContestantsFields();
		repaint();
	}
	
	private void displayNextContestant() {
		if (myContestants.size()  > 0 && rateCount < myContestants.size()) {
			if (currentContestantIndex < myContestants.size()) {
				currentContestant  = myContestants.get(currentContestantIndex);
				if (currentContestant.getRating() < 0) {

					ImageIcon frameIcon = new ImageIcon(currentContestant.getImg());
					image.setIcon(frameIcon);
					currentContestantIndex++;
				} else {
					rateCount++;
					currentContestantIndex++;
					displayNextContestant();
				}
				
			} else {
				currentContestantIndex = 0;
				displayNextContestant();
			}
		} else {
			image.setIcon(null);
			next.setEnabled(false);
			ratingLabel.setVisible(false);
			rating.setVisible(false);
			image.setText("No more contestants!");
			image.setForeground(Color.RED);
		}
	}
	
	private void displayContestantsFields() {
		image = new JLabel();
		
		currentContestantIndex = 0;
		
		next = new JButton("Next");
		next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent theEvent) {
				displayNextContestant();
			}
		});
		
		ratingLabel = new JLabel("Rating: ");
		ratingLabel.setForeground(Color.WHITE);
		
		rating = new JTextField(2);
		
		rating.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent theEvent) {
				if (theEvent.getKeyCode() != KeyEvent.VK_ENTER) {
					rateStr = rating.getText() + theEvent.getKeyChar();
				}
			}
		});
		
		rating.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent theEvent) {
				rating.setText("");
				currentContestant.rateImage(convertStr(rateStr));				
				ListOfContestants update = new ListOfContestants(myContestants);
				CSVWriter write = new CSVWriter(update);
				write.writeToFile("contestants.csv");
				rateCount++;
				displayNextContestant();
			}
		});
		
		centerPanel = new JPanel();
		southPanel.setBackground(Color.BLACK);
		northPanel = new JPanel();
		northPanel.setBackground(Color.BLACK);
		centerPanel = new JPanel(new GridBagLayout());
		centerPanel.setBackground(Color.BLACK);
		
		southPanel.add(next);
		northPanel.add(image);
		centerPanel.add(ratingLabel);
		centerPanel.add(rating);
		
		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		
		displayNextContestant();
		revalidate();
	}
	
	private int convertStr(String theNum) {
		int result = 0;
		
		for (char c : theNum.toCharArray()) {
			if (c < 58 || c > 47) {
				result += c - '0';
				result *= 10;
			}
		}
		result /= 10;
		
		return result;
	}
	
	/**
	 * This class will be the listener that will check for valid user login information.
	 * 
	 * @author Gabriel Houle
	 */
	private class JudgeLoginListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent theEvent) {
			if(verifyUser()) {
				logon();
			} else {
				invalid.setText("Invalid Login Information!");
			}
		}
	}
}