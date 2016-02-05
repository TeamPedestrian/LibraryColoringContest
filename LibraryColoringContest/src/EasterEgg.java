import javax.swing.JFrame;


public class EasterEgg {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		System.out.println("Go hawks!");
		JFrame testFrame = new JFrame();
		testFrame.add(new GabeButton());
		testFrame.setSize(200, 200);
		testFrame.setVisible(true);
		
	}
}
