import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JFrame;

public class Main extends JFrame {
	public static void main(String[] args) {
		new Main("GUI");
	}
	
	Main(String title) {
		super(title);
		setSize(500, 500);
		setVisible(true);
	}

	public static int random(int low, int high) {
		return ThreadLocalRandom.current().nextInt(low, high);
	}
}