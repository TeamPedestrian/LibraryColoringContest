import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class AntonioButton extends JButton {

	/***/
	private static final long serialVersionUID = -3792865140287035679L;

	/***/
	public AntonioButton() {
		super("Antonio");
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				JOptionPane.showMessageDialog(null, "Antonio is a Senior at UWT majoring in CSS.\n"
													+ "When not studying he likes to spend time with"
													+ "his wife and their Chihuahua \"Tiki\"", "About",JOptionPane.PLAIN_MESSAGE);
			}
		});
	}
}
