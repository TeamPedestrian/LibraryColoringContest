package view;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class RegistrationPanel extends JPanel {

	private JTextField fNameField;
	
	private JTextField lNameField;
	
	private JTextField mInitField;
	
	private JTextField emailField;
	
	private JTextField phoneNumberField;
	
	private final String[] ageRanges = {"Age", "0 - 3", "4 - 7", "8 - 11", "12 - 15", 
										"16 - 18", "19 - 24", "25 - 30", "30+" };
	
	private JComboBox ageField;
	
	
	
	public RegistrationPanel() {
		super();
		buildPanel();
	}
	
	private void buildPanel() {
		ageField = new JComboBox(ageRanges);
		fNameField = new JTextField();
		GhostText fNameGhost = new GhostText(fNameField, "First Name");
		lNameField = new JTextField();
		GhostText lNameGhost = new GhostText(lNameField, "Last Name");
		mInitField = new JTextField();
		GhostText mInitGhost = new GhostText(mInitField, "M");
		emailField = new JTextField();
		GhostText emailGhost = new GhostText(emailField, "Email");
		phoneNumberField = new JTextField();
		GhostText phoneNoGhost = new GhostText(phoneNumberField, "Phone Number");
		this.add(fNameField);
		this.add(lNameField);
	}
	
	private class GhostText implements FocusListener, DocumentListener, PropertyChangeListener {
		 
		private JTextField myTextField;
		
		private boolean isEmpty;
		
		private Color myGhostColor;
		
		private Color myForegroundColor;
		
		private final String myGhostText;
		
		public GhostText (final JTextField theTextField, final String theGhostText) {
			super();
			myTextField = theTextField;
			myGhostText = theGhostText;
			myGhostColor = Color.LIGHT_GRAY;
			myTextField.addFocusListener(this);
			
		}
		
		private void registerListeners() {
			myTextField.getDocument().addDocumentListener(this);
			myTextField.addPropertyChangeListener("foreground", this);
		}
		
		private void unregisterListeners() {
			myTextField.getDocument().removeDocumentListener(this);
			myTextField.removePropertyChangeListener("foreground", this);
		}
		
		private void updateState() {
			isEmpty = myTextField.getText().length() == 0;
			myForegroundColor = myTextField.getForeground();
		}
		
		@Override
		public void focusGained(FocusEvent e) {
			if (isEmpty) {
				unregisterListeners();
				try {
					myTextField.setText("");
					myTextField.setForeground(myForegroundColor);
				} finally { 
					registerListeners();
				}
			}
		}
		
		@Override
		public void focusLost(FocusEvent e) {
			if (isEmpty) {
				unregisterListeners();
				try {
					myTextField.setText(myGhostText);
					myTextField.setForeground(myGhostColor);
				} finally { 
					registerListeners();
				}
			}
		}
		
		@Override 
		public void propertyChange(PropertyChangeEvent e) {
			updateState();
		}
		
		@Override 
		public void changedUpdate(DocumentEvent e) {
			updateState();
		}
		
		@Override 
		public void insertUpdate(DocumentEvent e) {
			updateState();
		}
		
		@Override 
		public void removeUpdate(DocumentEvent e) {
			updateState();
		}
	}
}
