package easterEgg;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This is the main class for the Easter Egg Assignment, TCSS 360
 * The functionality is to create a JFrame that will open on running 
 * and contain within it a picture of each member of Team Pedestrian. 
 * Below each member is a button corresponding to their name and image 
 * when this button is pressed a dialog box will open displaying a bit
 * of personal information about that team member. 
 */
public class EasterEgg {

	public static void main(String[] args) {
        URL image = EasterEgg.class.getResource("TeamPedestrian.jpeg");
        ImageIcon imageIcon = new ImageIcon(image);
		JFrame easterEggFrame = new JFrame();
		easterEggFrame.setTitle("Team Pedestrian");
		JPanel imagePanel = new JPanel();
		imagePanel.add(new JLabel(imageIcon));
		easterEggFrame.add(imagePanel);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout());
		buttonPanel.add(new GabeButton());
		buttonPanel.add(new AntonioButton());
		buttonPanel.add(new BunButton());
		buttonPanel.add(new AndyButton());
		buttonPanel.add(new YikaloButton());
		easterEggFrame.add(buttonPanel, BorderLayout.SOUTH);
		easterEggFrame.setSize(1100, 500);
		easterEggFrame.setLocationRelativeTo(null);
		easterEggFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		easterEggFrame.setResizable(false);
		easterEggFrame.setVisible(true);
		
	}
}
