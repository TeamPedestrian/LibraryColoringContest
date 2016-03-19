package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import model.CSVReader;
import model.CSVWriter;
import model.Contestant;
import model.ListOfContestants;

/**
 * GUI class for the Registration panel, used by those looking to register 
 * for the contest and upload a photo. 
 * @author Andy Bleich
 *
 */
public class RegistrationPanel extends JPanel {

	/** File Chooser used multiple times in the panel*/
	private JFileChooser myChooser = new JFileChooser("./src/images");
	
	private JTextField fNameField;
	
	private JTextField lNameField;
	
	private JTextField mInitField;
	
	private JTextField emailField;
	
	private JTextField phoneNumberField;
	
	private final String[] ageRanges = {"Age", "0 - 3", "4 - 7", "8 - 11", "12 - 15", 
										"16 - 18", "19 - 24", "25 - 30", "30+" };
	
	private JComboBox ageField;
	
	private JButton uploadButton;
	
	private JButton registerButton;
	
	private ListOfContestants myList;
	
	private JLabel image;
	
	private String filePath;
	
	
	/**
	 * Creates a new Registration panel. 
	 */
	public RegistrationPanel() {
		super();
		this.setLayout(new BorderLayout());
		this.setSize(800, 800);
		buildPanel();
		try {
			myList = CSVReader.readCSV("contestants.csv");
		} catch (Exception e) {
			myList = new ListOfContestants();
		}
	}
	
	/**
	 * Builds each part of the panel. 
	 */
	// Sorry about the messy code
	@SuppressWarnings("unused")
	private void buildPanel() {
		ageField = new JComboBox(ageRanges);
		fNameField = new JTextField(20);
		GhostText fNameGhost = new GhostText(fNameField, "First Name");
		lNameField = new JTextField(20);
		GhostText lNameGhost = new GhostText(lNameField, "Last Name");
		mInitField = new JTextField(2);
		GhostText mInitGhost = new GhostText(mInitField, "M");
		emailField = new JTextField(20);
		GhostText emailGhost = new GhostText(emailField, "Email");
		phoneNumberField = new JTextField(12);
		image = new JLabel();
		GhostText phoneNoGhost = new GhostText(phoneNumberField, "Phone Number");
		JPanel namePanel = new JPanel();
		JPanel emailPhoneAgePanel = new JPanel();
		JPanel northPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		emailPhoneAgePanel.setLayout(new GridLayout(0, 3));
		emailPhoneAgePanel.setSize(new Dimension(400, 25));
		emailPhoneAgePanel.setMaximumSize(new Dimension(400, 25));
		registerButton = new JButton("Register & Save");
		registerButton.addActionListener(new registerButtonAction());
		registerButton.setEnabled(false);
		uploadButton = new JButton("Upload Photo");
		uploadButton.addActionListener(new uploadListener());
		namePanel.add(fNameField);
		namePanel.add(lNameField);
		namePanel.add(mInitField);
		namePanel.setBackground(Color.BLACK);
		namePanel.setLayout(new GridBagLayout());
		emailPhoneAgePanel.add(emailField);
		emailPhoneAgePanel.add(phoneNumberField);
		emailPhoneAgePanel.add(ageField);
		emailPhoneAgePanel.setBackground(Color.BLACK);
		emailPhoneAgePanel.setLayout(new GridBagLayout());
		centerPanel.add(image);
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(uploadButton);
		buttonPanel.add(registerButton);
		northPanel.add(namePanel, BorderLayout.NORTH);
		northPanel.add(emailPhoneAgePanel, BorderLayout.CENTER);
		northPanel.setBackground(Color.BLACK);
		centerPanel.setBackground(Color.BLACK);
		this.add(northPanel, BorderLayout.NORTH);
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);	
		}
	
	/**
	 * Adds a contestant to the list once all fields are filled in. 
	 */
	private boolean addContestantToList() {
		Contestant toAdd = new Contestant();
		toAdd.setFName(fNameField.getText());
		toAdd.setLName(lNameField.getText());
		if (mInitField.getText().length() != 0) {
			toAdd.setMInit(mInitField.getText());
		}
		toAdd.setPhoneNo(phoneNumberField.getText());
		toAdd.setEmail(emailField.getText());
		toAdd.setImgURL(filePath);
		int[] a = new int[2];
		switch (ageField.getSelectedIndex()) {
			case 0:
				//to print invalid in
				//break;
			case 1: 
				a[0] = 0;
				a[1] = 3;
				toAdd.setAgeRange(a);
				break;
			case 2: 
				a[0] = 4;
				a[1] = 7;
				toAdd.setAgeRange(a);
				break;
			case 3: 
				a[0] = 8;
				a[1] = 11;
				toAdd.setAgeRange(a);
				break;
			case 4: 
				a[0] = 12;
				a[1] = 15;
				toAdd.setAgeRange(a);
				break;
			case 5: 
				a[0] = 16;
				a[1] = 18;
				toAdd.setAgeRange(a);
				break;
			case 6: 
				a[0] = 19;
				a[1] = 24;
				toAdd.setAgeRange(a);
				break;
			case 7: 
				a[0] = 25;
				a[1] = 30;
				toAdd.setAgeRange(a);
				break;
			case 8: 
				a[0] = 31;
				a[1] = Integer.MAX_VALUE;
				toAdd.setAgeRange(a);
				break;
		}
		boolean result = myList.addContestant(toAdd);
		
		return result;
	}
	
	/**
	 * Opens file chooser to preview an image on the panel. 
	 * @author Andy Bleich
	 *
	 */
	private class uploadListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Upload Photo")) {
				int result = myChooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selected = myChooser.getSelectedFile();
					try {
						image.setIcon(new ImageIcon(ImageIO.read(selected)));
						filePath = selected.getPath();
						registerButton.setEnabled(true);
						
					} catch (IOException eX) {
						JOptionPane.showMessageDialog(null, 
								"Selected file not found!", "Error!",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
	}
	
	/**
	 * Registers the user to the list of Contestants. 
	 * @author Andy Bleich
	 *
	 */
	private class registerButtonAction implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (addContestantToList()) {
				CSVWriter output = new CSVWriter(myList);
				
				output.writeToFile("contestants.csv");
				
				removeAll();
				setLayout(new BorderLayout());
				JPanel thankPanel = new JPanel();
				thankPanel.setLayout(new GridBagLayout());
				JLabel thanks = new JLabel("Thank you for registering!");
				thanks.setForeground(Color.WHITE);
				thanks.setFont(thanks.getFont().deriveFont(32.0f));
				thankPanel.add(thanks);
				thankPanel.setBackground(Color.BLACK);
				add(thankPanel);
				revalidate();
				repaint();
			} else {
				image.setText("Email address already registered!");
				image.setForeground(Color.RED);
			}
		}
	}
}
