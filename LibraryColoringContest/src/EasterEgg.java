import java.awt.BorderLayout;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class EasterEgg {

	public static void main(String[] args) {
        URL image = EasterEgg.class.getResource("agile_method.png");
        ImageIcon imageIcon = new ImageIcon(image);
		JFrame easterEggFrame = new JFrame();
		JPanel imagePanel = new JPanel();
		imagePanel.add(new JLabel(imageIcon));
		easterEggFrame.add(imagePanel);
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(new GabeButton());
		buttonPanel.add(new AntonioButton());
		buttonPanel.add(new BunButton());
		buttonPanel.add(new AndyButton());
		buttonPanel.add(new YikaloButton());
		easterEggFrame.add(buttonPanel, BorderLayout.SOUTH);
		easterEggFrame.setSize(500, 500);
		easterEggFrame.setLocationRelativeTo(null);
		easterEggFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		easterEggFrame.setResizable(false);
		easterEggFrame.setVisible(true);
		
	}
}
