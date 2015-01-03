import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * Testira Circle1 klasu, kreira frame i na njega lijepi Circle1 panel.
 * 
 * @author Haris
 *
 */
public class Circle1Test {

	public static void main(String[] args) {
		JFrame window = new JFrame("Moving Circle");
		window.setSize(800, 600);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocation(600, 300);
		Circle1 panel = new Circle1();
		window.setContentPane(panel);
		panel.setFocusable(true);
		panel.requestFocusInWindow();
		window.setVisible(true);
		Timer timer = new Timer(15, panel);
		timer.start();

	}

}
