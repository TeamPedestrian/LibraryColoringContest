package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import model.Contestant;
import model.ListOfContestants;

public class RegistrationPanel extends JPanel {

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
	
	
	public RegistrationPanel() {
		super();
		this.setLayout(new BorderLayout());
		this.setSize(800, 800);
		buildPanel();
	}
	
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
		GhostText phoneNoGhost = new GhostText(phoneNumberField, "Phone Number");
		JPanel namePanel = new JPanel();
		JPanel emailPhoneAgePanel = new JPanel();
		emailPhoneAgePanel.setLayout(new GridLayout(0, 3));
		emailPhoneAgePanel.setSize(new Dimension(400, 25));
		emailPhoneAgePanel.setMaximumSize(new Dimension(400, 25));
		registerButton = new JButton("Register & Upload");
		registerButton.addActionListener(new registerButtonAction());
		uploadButton = new JButton("Upload Photo");
		namePanel.add(fNameField);
		namePanel.add(lNameField);
		namePanel.add(mInitField);
		emailPhoneAgePanel.add(emailField);
		emailPhoneAgePanel.add(phoneNumberField);
		emailPhoneAgePanel.add(ageField);
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(uploadButton);
		buttonPanel.add(registerButton);
		this.add(namePanel, BorderLayout.NORTH);
		this.add(emailPhoneAgePanel, BorderLayout.CENTER);	
		this.add(buttonPanel, BorderLayout.SOUTH);	}
	
	private void addContestantToList() {
		Contestant toAdd = new Contestant();
		toAdd.setFName(fNameField.getText());
		toAdd.setLName(lNameField.getText());
		if (mInitField.getText().length() != 0) {
			toAdd.setMInit(mInitField.getText());
		}
		toAdd.setPhoneNo(phoneNumberField.getText());
		toAdd.setEmail(emailField.getText());
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
		myList.addContestant(toAdd);
	}
	
	private class registerButtonAction implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			addContestantToList();
		}
	}
}
