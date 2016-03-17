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
 * 
 * 
 * @author Antonio V. Alvillar
 */
@SuppressWarnings("serial")
public class HomePage extends JFrame {
	private JFrame frame;
	private String myKeyString = "";
	private JPanel center;
	private JButton myHome;
	private JButton mySave;
	private JButton myCancel;
	private JFileChooser homeChooser = new JFileChooser("./src/images");
	private File myImage;
	private JLabel myLabel;
	private JFrame myDisplayFrame;
	private JPanel myDisplayPanel;

	public HomePage() {
		frame = new JFrame("https://Library.gov/Coloring_Contest/home");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(952, 650);
	    frame.setLocationRelativeTo(null);
	    frame.setResizable(false);		
		setupFrame(frame);
	    frame.addKeyListener(new KeyAdapter() {
			@Override
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
		JButton browse = createButton("Browse Designs");
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
        } 
    }
    
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