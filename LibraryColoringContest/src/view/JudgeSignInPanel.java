/*
 * TCSS360 LibraryColoringContest Team Pedestrian
 */

package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * 
 * @author Gabriel Houle
 */
@SuppressWarnings("serial")
public class JudgeSignInPanel extends JPanel {
	
	JTextField username;
	JTextField password;
	JButton enter;
	String userString;
	String passString;
	
	public JudgeSignInPanel() {
		super();
		setSize(800, 800);
		
		setup();
		
	}
	
	private void setup() {
		
		createTextInput();
		
		add(username, BorderLayout.CENTER);
		add(new JLabel("Username"));
		add(password, BorderLayout.CENTER);
		add(new JLabel("Password"));
		add(enter, BorderLayout.SOUTH);
	}
	
	private void createTextInput() {
		username = new JTextField(20);
		
		username.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				userString = username.getText();

			}
		});
		
		password = new JTextField(20);
		
		password.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				passString = password.getText();

			}
		});
		
		enter = new JButton("Enter");
		enter.addActionListener(new JudgeListener());
	}
	
	/**
	 * 
	 * 
	 * @author Gabriel Houle
	 */
	private class JudgeListener implements ActionListener {
		
		public void actionPerformed(ActionEvent theEvent) {
			//add the sign in function here that checks for valid user/pass.
		}
	}
}
