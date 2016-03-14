/*
 * TCSS360 LibraryColoringContest Team Pedestrian
 */

package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private JButton myHome;
	private JButton mySave;
	private JButton myCancel;
	private JFileChooser homeChooser = new JFileChooser("./src/images");
	private File myImage;
	private JLabel myLabel;
	private JFrame myDisplayFrame;
	private JPanel myDisplayPanel;
	//private JPanel current;
	
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
		center = null;
		center = new JPanel();
		center.setBackground(Color.BLACK);
		center.setLayout(new GridBagLayout());
		JButton browse = createButton("Browse Design");
		JButton register = createButton("Register & Upload");
		JButton judge = createButton("Judge Sign In");
		
		//browse.addActionListener(new BrowseListener());
		browse.addActionListener(new HomeListener());
		
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
		myHome = createButton("Return to Contest Home");
		myHome.setEnabled(false);
		JPanel homePanel = new JPanel();
		homePanel.add(myHome);
		frame.add(homePanel, BorderLayout.SOUTH);
	}
	
    private void browseDesigns() {
        int result = homeChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
            	myImage = homeChooser.getSelectedFile();
            	myLabel = new JLabel();
            	myLabel.setIcon(new ImageIcon(ImageIO.read(myImage)));
            } catch (final IOException exception) {
            	JOptionPane.showMessageDialog(null, "Selected file not found!", "Error!", 
            								  JOptionPane.ERROR_MESSAGE);
            }
            setUpDisplayFrame();
        } else {
        	homeChooser.cancelSelection();
        	frame.setFocusable(true);
        }
    }
    
    private void setUpDisplayFrame() {
    	frame.setFocusable(false);
    	myDisplayFrame = new JFrame("Image Selection");
    	//myDisplayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	myDisplayFrame.setSize(300, 300);
    	myDisplayFrame.setLocationRelativeTo(null);
    	myDisplayFrame.setResizable(false);
    	myDisplayFrame.add(myLabel, BorderLayout.CENTER);
    	mySave = new JButton("Save Image");
    	mySave.addActionListener(new HomeListener());
    	myCancel = new JButton("Cancel");
    	myCancel.addActionListener(new HomeListener());
    	myDisplayPanel = new JPanel();
    	myDisplayPanel.setLayout(new GridBagLayout());
    	myDisplayPanel.add(mySave);
    	myDisplayPanel.add(myCancel);
    	myDisplayFrame.add(myDisplayPanel, BorderLayout.SOUTH);
    	myDisplayFrame.setSize(300, 300);
    	myDisplayFrame.setVisible(true);
    }
    
    private void saveDesign() {
        int result = homeChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
//            try {
//            	String test = myImage.getAbsolutePath();
//            	ImageIO.write((RenderedImage) myLabel, "jpg", myImage);
//            } catch (final IOException exception) {
//                JOptionPane.showMessageDialog(null, "Unable to save image!", 
//                                              "Alert!", 
//                                              JOptionPane.ERROR_MESSAGE);
//            }
        }
    }

	private class HomeListener implements ActionListener {
		public void actionPerformed(ActionEvent theEvent) {
			//System.out.println(theEvent.getActionCommand());
			switch (theEvent.getActionCommand()) {
				case "Browse Design":
					browseDesigns();
					break;
				case "Save Image":
					saveDesign();
					break;
				case "Cancel":
					myDisplayFrame.dispose();
					myLabel = null;
					break;
				case "Register & Upload":
					myHome.setEnabled(true);
					frame.getContentPane().remove(center);
					center = null;
					center = new RegistrationPanel();
					frame.getContentPane().add(center, BorderLayout.CENTER);
					frame.revalidate();
					break;
				case "Return to Contest Home":
					myHome.setEnabled(false);
					frame.getContentPane().remove(center);
					setupCenter(frame);
					frame.revalidate();
					break;
				case "Judge Sign In":
					myHome.setEnabled(true);
					frame.getContentPane().remove(center);
					center = null;
					center = new JudgeSignInPanel();
				    frame.getContentPane().add(center, BorderLayout.CENTER);
					frame.revalidate();
					break;
			}
		}
	}
}