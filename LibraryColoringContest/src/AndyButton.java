import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class AndyButton extends JButton {
	
	
	private static final long serialVersionUID = -8011008408518810649L;

	public AndyButton() {
		super("Andy");
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				JOptionPane.showMessageDialog(null, "I am Andy, " +
						"I like playing games and watching esports", 
						"Andy", JOptionPane.PLAIN_MESSAGE);
			}
			
		});
	}
	
}
