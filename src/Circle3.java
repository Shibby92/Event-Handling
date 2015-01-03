import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Crtanje kruga gdje je event handler napisan kao anonymous klasa koja
 * implementira odgovarajuci interface
 * 
 * @author Haris
 *
 */
public class Circle3 {
	private static int x = 400;
	private static int y = 300;
	private static int frameX = 0;
	private static int frameY = 0;

	/**
	 * Kreiranje frame-a na koji se lijepi i testira myPanel
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame window = new JFrame("Moving Circle");
		window.setSize(800, 600);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocation(600, 300);
		myPanel panel = new myPanel();
		window.setContentPane(panel);
		// implementacija anonimne klase koja implementira KeyListener interface
		panel.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					frameX = -1;
					frameY = 0;
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					frameX = 1;
					frameY = 0;
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					frameY = -1;
					frameX = 0;
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					frameY = 1;
					frameX = 0;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		});
		panel.setFocusable(true);
		panel.requestFocusInWindow();
		window.setVisible(true);
		Timer timer = new Timer(15, panel);
		timer.start();

	}

	/**
	 * Inner klasa myPanel gdje crtamo (paintComponent) i pomjeramo
	 * (actionPerformed) krug
	 * 
	 * @author Haris
	 *
	 */
	public static class myPanel extends JPanel implements ActionListener {
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.fillOval(x, y, 50, 50);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			x += frameX;
			y += frameY;
			repaint();
		}

	}

}
