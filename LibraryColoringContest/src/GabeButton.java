import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;


public class GabeButton extends JButton {

	public GabeButton() {
		System.out.println("Gabe_Button");
	}

	public GabeButton(Icon icon) {
		super(icon);
		// TODO Auto-generated constructor stub
	}

	public GabeButton(String text) {
		super(text);
		// TODO Auto-generated constructor stub
	}

	public GabeButton(Action a) {
		super(a);
		// TODO Auto-generated constructor stub
	}

	public GabeButton(String text, Icon icon) {
		super(text, icon);
		// TODO Auto-generated constructor stub
	}

}
