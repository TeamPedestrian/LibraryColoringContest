package easterEgg;
/*
 * TCSS360 GabeButton
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;


/**
 * This class is a button that will activate an easter egg with information about
 * Gabriel(me!).
 * 
 * @author Gabriel Houle
 */
public class GabeButton extends JButton {

	/**Needed serialization*/
	private static final long serialVersionUID = 7711521263918528653L;

	public GabeButton() {
		super("Gabriel");
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				JOptionPane.showMessageDialog(null, "I am a Comp Sci Student who likes hiking " + 
													"and reading science-fiction.",
													"Gabe", JOptionPane.PLAIN_MESSAGE);
			}
		});
	}
}
