import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class YikaloButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public YikaloButton() {
		super("Yikalo");
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				JOptionPane.showMessageDialog(null, "Information goes here", "Yikalo",JOptionPane.PLAIN_MESSAGE);
			}
		});
	}

}
