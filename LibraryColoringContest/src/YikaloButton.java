import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * This class is a button that will activate an easter egg with information about
 * Yikalo.
 * 
 * @author Yikalo
 */
public class YikaloButton extends JButton {

	/**Needed serialization*/
	private static final long serialVersionUID = 7711521263918528653L;

	public YikaloButton() {
		super("Yikalo");
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				JOptionPane.showMessageDialog(null, "I am Yikalo sinor at UWT in computer science. I m big fun of soccer game" + 
													"and Video games.",
													"Yikalo", JOptionPane.PLAIN_MESSAGE);
			}
		});
	}
}


