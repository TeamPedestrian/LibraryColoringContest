/*
 *  TCSS 360 Software Engineering
 *  BUN KAK
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;


/**
 * This class is a button that will activate an easter egg with 
 * information about BUN KAK.
 * 
 * @author BUN KAK
 */
public class BunButton extends JButton {

	/**Needed serialization*/
	private static final long serialVersionUID = 7711521263918528653L;

	public BunButton() {
		super("Bun");
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				JOptionPane.showMessageDialog(null, "I am a senior computer science student, " + 
													"love to code, and will graduate soon.",
													"BUN KAK", JOptionPane.PLAIN_MESSAGE);
			}
		});
	}
}