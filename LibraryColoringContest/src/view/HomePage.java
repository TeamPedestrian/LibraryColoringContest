/*
 * TCSS360 LibraryColoringContest Team Pedestrian
 */

package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * 
 * @author Antonio V. Alvillar
 */
@SuppressWarnings("serial")
public class HomePage extends JFrame {
	private JFrame frame;
	private JPanel center;
	private JPanel judge;
	private JPanel register;
	private JPanel current;
	
	public HomePage() {
		frame = new JFrame("https://Library.gov/Coloring_Contest/home");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(952, 650);
	    frame.setLocationRelativeTo(null);
	    frame.setResizable(false);
		setupFrame(frame);
		frame.setVisible(true);
	}
	
	private void setupFrame(JFrame frame) {
		URL icon = HomePage.class.getResource("/libraryIcon.png");
		ImageIcon frameIcon = new ImageIcon(icon);
		frame.setIconImage(frameIcon.getImage());
		setupCenter(frame);
		setupHome(frame);
		URL image = HomePage.class.getResource("/coloringContest.png");
		ImageIcon imageIcon = new ImageIcon(image);
		JPanel imagePanel = new JPanel(new GridLayout());
		imagePanel.add(new JLabel(imageIcon));
		frame.add(imagePanel, BorderLayout.NORTH);	
	}
	
	private void setupCenter(JFrame frame) {
		center = new JPanel();
		JButton browse = createButton("Browse Design");
		JButton register = createButton("Register & Upload");
		JButton judge = createButton("Judge Sign In");
		center.add(browse);
		center.add(register);
		center.add(judge);
		frame.add(center, BorderLayout.CENTER);
	}

	private JButton createButton(String string) {
		JButton button = new JButton(string);
		button.addActionListener(new HomeListener());
		return button;
	}

	private void setupHome(JFrame frame) {
		JButton home = createButton("Return to Contest Home");
		JPanel homePanel = new JPanel();
		homePanel.add(home);
		frame.add(homePanel, BorderLayout.SOUTH);
	}
	
	private class HomeListener implements ActionListener {
		public void actionPerformed(ActionEvent theEvent) {
			//System.out.println(theEvent.getActionCommand());
			switch (theEvent.getActionCommand()) {
//				case "Browse Design":
//					BrowseDesign browse = new BrowseDesign();
					//break;
				case "Register & Upload":
					register = new RegistrationPanel();
					frame.getContentPane().remove(center);
					frame.getContentPane().add(register, BorderLayout.CENTER);
					frame.revalidate();
					break;
				case "Return to Contest Home":
					frame.getContentPane().remove(judge);
					setupCenter(frame);
					frame.revalidate();
					break;
				case "Judge Sign In":
					judge = new JudgeSignInPanel();
					frame.getContentPane().remove(center);
				    frame.getContentPane().add(judge, BorderLayout.CENTER);
					frame.revalidate();
					break;
			}
		}
	}

}