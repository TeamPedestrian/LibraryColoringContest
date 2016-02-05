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

	private static final long serialVersionUID = 7711521263918528653L;

	public GabeButton() {
		super("Gabriel Houle");
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				JOptionPane.showMessageDialog(null, "I am cool.", "Gabe",JOptionPane.PLAIN_MESSAGE);
			}
		});
	}
}
