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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
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
import javax.swing.SwingUtilities;

import easterEgg.EasterEgg;

/**
 * This class will handle all functionality of the main GUI and frame that will
 * contain all panels used throughout the contest. 
 * 
 * Also, will take care of the browse designs functionality. 
 * 
 * @author Antonio V. Alvillar
 */
@SuppressWarnings("serial")
public class HomePage extends JFrame {
	
	/**
	 * Main JFrame
	 */
	private JFrame frame;
	
	/**
	 * String for the easter egg key code.
	 */
	private String myKeyString = "";
	
	/**
	 * Center Panel of the main frame. 
	 */
	private JPanel center;
	
	/**
	 * Home button to be used throughout the program.
	 */
	private JButton myHome;
	
	/**
	 * Save button used when downloading an image. 
	 */
	private JButton mySave;
	
	/**
	 * Cancel button if the image is not going to be saved. 
	 */
	private JButton myCancel;
	
	/**
	 * File chooser to be used for downloaded an image. 
	 */
	private JFileChooser homeChooser = new JFileChooser("images");
	
	/**
	 * File for retrieving an image.
	 */
	private File myImage;
	
	/**
	 * Label used to preview an image before downloading. 
	 */
	private JLabel myLabel;
	
	/**
	 * Display frame for previewing an image. 
	 */
	private JFrame myDisplayFrame;
	
	/**
	 * Display panel that will hold the image in a frame. 
	 */
	private JPanel myDisplayPanel;

	/**
	 * Homepage constructor that will create the JFrame and call other methods 
	 * as needed. This will also create the functionality for the Easter Egg
	 * to be called by a string input read from the frame.
	 */
	public HomePage() {
		frame = new JFrame("https://Library.gov/Coloring_Contest/home");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(952, 650);
	    frame.setLocationRelativeTo(null);
	    frame.setResizable(false);		
		setupFrame(frame);
	    frame.addKeyListener(new KeyAdapter() {
			@Override //  Listener for the easter egg to be called.
			public void keyReleased(final KeyEvent theEvent) {
				if (theEvent.getKeyCode() != KeyEvent.VK_ENTER  && theEvent.getKeyCode() != KeyEvent.VK_SHIFT) {
					myKeyString += theEvent.getKeyChar();
				} else if (theEvent.getKeyCode() == KeyEvent.VK_ENTER) {
					if (myKeyString.contentEquals("Team Pedestrian")) {
						runClient();
						myKeyString = "";
					}
				}
			}
		});
	    frame.setFocusable(true);
		frame.setVisible(true);
	}
	
	/**
	 * Method to help set up the frame by giving it an icon and image
	 * as well as calling helper methods to finish the creation of the 
	 * program.
	 * @param frame
	 */
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
	
	/**
	 * Method to set up the middle of the frame and the needed buttons 
	 * to be placed on it. 
	 * @param frame
	 */
	private void setupCenter(JFrame frame) {
		center = null;
		center = new JPanel();
		center.setBackground(Color.BLACK);
		center.setLayout(new GridBagLayout());
		JButton browse = createButton("Browse Designs");
		JButton register = createButton("Register & Upload");
		JButton judge = createButton("Judge Sign In");
		center.add(browse);
		center.add(register);
		center.add(judge);
		frame.add(center, BorderLayout.CENTER);
	}

	/**
	 * Button method that creates a button by passed in string to be 
	 * displayed on the button then add a listener to the button.
	 * @param string of text to place on the button
	 * @return a JButton that can be placed on a component.
	 */
	private JButton createButton(String string) {
		JButton button = new JButton(string);
		button.addActionListener(new HomeListener());
		return button;
	}

	/**
	 * Method to make the home panel which will contain a single 
	 * button allowing the user to return to the main page of the program. 
	 * @param frame
	 */
	private void setupHome(JFrame frame) {
		myHome = createButton("Return to Contest Home");
		myHome.setEnabled(false);
		JPanel homePanel = new JPanel();
		homePanel.add(myHome);
		frame.add(homePanel, BorderLayout.SOUTH);
	}
	
	/**
	 * Method that will be called if the browse designs button
	 * is pressed. Will open a file chooser that lets a user select 
	 * an image then will call a helper method to display the image 
	 * allowing the user to save it if they choose. 
	 */
    private void browseDesigns() {
        
        URL images = HomePage.class.getResource("./images");
        int result = 0;
        
        try {
            File path = new File(images.toURI());
            homeChooser = new JFileChooser(path);
            


        } catch (Exception e) {
        	
        }
        
        result = homeChooser.showOpenDialog(null);

        
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
            	
//				URL icon = HomePage.class.getResource(currentContestant.getImg());
//				File icon = new File(currentContestant.getImg());
            	
            	myImage = homeChooser.getSelectedFile();
            	myLabel = new JLabel();
            	myLabel.setIcon(new ImageIcon(ImageIO.read(myImage)));
            } catch (final IOException exception) {
            	JOptionPane.showMessageDialog(null, "Selected file not found!", "Error!", 
            								  JOptionPane.ERROR_MESSAGE);
            }
            setUpDisplayFrame();
        } 
    }
    
    /**
     * Method to create a frame that will use a panel 
     * to display an image chosen from a file chooser then 
     * create two buttons, one for saving and the other to cancel. 
     * This is all done on the fly as the button is pressed. 
     */
    private void setUpDisplayFrame() {
    	frame.setFocusable(false);
    	myDisplayFrame = new JFrame();
		URL icon = HomePage.class.getResource("/blueBooks.png");
		ImageIcon frameIcon = new ImageIcon(icon);
		myDisplayFrame.setIconImage(frameIcon.getImage());	
    	JPanel myImagePanel = new JPanel();
    	myImagePanel.add(myLabel);
    	myDisplayFrame.setSize(400, 400);
    	myDisplayFrame.setLocationRelativeTo(null);
    	myDisplayFrame.setResizable(false);
    	myDisplayFrame.add(myImagePanel, BorderLayout.CENTER);
    	mySave = createButton("Save Image");
    	myCancel = createButton("Cancel");
    	myDisplayPanel = new JPanel();
    	myDisplayPanel.setLayout(new GridBagLayout());
    	myDisplayPanel.add(mySave);
    	myDisplayPanel.add(myCancel);
    	myDisplayFrame.add(myDisplayPanel, BorderLayout.SOUTH);
    	myDisplayFrame.pack();
    	myDisplayFrame.setVisible(true);
    }
    
    /**
     * Method to open another chooser if the user decided they 
     * want to save an image. This will allow them to save it in 
     * any directory they choose. 
     */
    private void saveDesign() {
    	int result = homeChooser.showSaveDialog(null);
    	if(result == JFileChooser.APPROVE_OPTION) {
    		File chosenFile = homeChooser.getSelectedFile();
    		BufferedImage image = null;
			try {
				image = ImageIO.read(myImage);
				ImageIO.write(image, "png", new File(chosenFile.getAbsolutePath()));
				JOptionPane.showMessageDialog(null, "Image Saved!");
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
    }

    /**
     * Private Class for a Listener that will call different methods
     * depending on the actions that take place on the frame from button
     * presses. Using a switch to decide on what action to take. 
     * @author Antonio V. Alvillar
     *
     */
	private class HomeListener implements ActionListener {
		public void actionPerformed(ActionEvent theEvent) {
			switch (theEvent.getActionCommand()) {
				case "Browse Designs":
					browseDesigns();
					break;
				case "Save Image":
					saveDesign();
					myDisplayFrame.dispose();
					frame.setFocusable(true);
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
	
	/**
	 * A private runnable that will be used to run the easter egg main method
	 * but only if a correct string is input into a listener attached to the main
	 * frame of this class.
	 */
	private static void runClient() {
	    SwingUtilities.invokeLater(new Runnable() {
	        @Override
	        public void run() {
	            String[] args1={"10"};
	            EasterEgg.main(args1);
	        }
	    });
	}
}