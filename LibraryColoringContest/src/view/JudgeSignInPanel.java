/*
 * TCSS360 LibraryColoringContest Team Pedestrian
 */

package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Judge;

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
	JTextField username;
	
	/**
	 * Used for password input.
	 */
	JTextField password;
	
	/**
	 * Enter Button.
	 */
	JButton enter;
	
	/**
	 * The currently logged in judge.
	 */
	Judge myJudge = null;
	
	/**
	 * Stores the panel along the bottom of the judge sign in.
	 */
	JPanel southPanel;
	
	/**
	 * Stores the panel in the center of the judge sign in.
	 */
	JPanel centerPanel;
	
	/**
	 * Stores the panel along the top of the judge sign in.
	 */
	JPanel northPanel;
	
	/**
	 * String that stores the user name.
	 */
	String userString = "";
	
	/**
	 * String that stores the password.
	 */
	String passString = "";
	
	public JudgeSignInPanel() {
		super();
		setLayout(new BorderLayout());
		listOfJudges = loadJudges();
		setSize(800, 800);
		
		setup();
	}
	
	/**
	 * Loads all registered judges.
	 * 
	 * @return A List containing all judges.
	 */
	public List<Judge> loadJudges() {
		ArrayList<Judge> result = new ArrayList<>();
		
		Judge bob = new Judge("bob1", "1234");
		
		result.add(bob);
		
		return result;
	}
	
	/**
	 * Runs various setup methods and adds button components to the panel.
	 */
	private void setup() {
		
		southPanel = new JPanel();
		northPanel = new JPanel();
		centerPanel = new JPanel(new GridBagLayout());

		createTextInput();
		
		centerPanel.add(new JLabel("Username"));
		centerPanel.add(username);
		centerPanel.add(new JLabel("Password"));
		centerPanel.add(password);
		centerPanel.add(enter);
		centerPanel.add(new JLabel("Invalid Login!"));
		
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
				userString = username.getText() + theEvent.getKeyChar();
//				System.out.println(userString);
			}
		});
		
		username.addActionListener(new JudgeListener());
		
		password = new JTextField(20);
		
		password.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent theEvent) {
				passString = password.getText() + theEvent.getKeyChar();
//				System.out.println(passString);
			}
		});
		
		password.addActionListener(new JudgeListener());
		
		enter = new JButton("Enter");
		enter.addActionListener(new JudgeListener());
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
		
		repaint();
		
	}
	
	/**
	 * 
	 * 
	 * @author Gabriel Houle
	 */
	private class JudgeListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent theEvent) {
			if(verifyUser()) {
				logon();
			}
		}
	}
}