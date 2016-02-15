import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * This class represents a button that will display information about
 * myself (Antonio) as part of the EasterEgg Assignment for TCSS360.
 * 
 * @author Antonio V. Alvillar
 */
public class AntonioButton extends JButton {

	/**Needed serialization*/
	private static final long serialVersionUID = -3792865140287035679L;

	public AntonioButton() {
		super("Antonio");
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				JOptionPane.showMessageDialog(null, "I am a Senior at UWT majoring in CSS.\n"
													+ "When not studying I like to spend time with "
													+ "my wife and our Chihuahua \"Tiki\"", "About",JOptionPane.PLAIN_MESSAGE);
			}
		});
	}
}
