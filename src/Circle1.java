import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

/**
 * Klasa Circle1 koja kreira panel na kojem je nacrtan krug, te je implementiran
 * EventHandler koji skrece loptu u odgovarajucu stranu
 * 
 * @author Haris
 *
 */
public class Circle1 extends JPanel implements ActionListener {
	private int x = 400;
	private int y = 300;
	private int frameX = 0;
	private int frameY = 0;

	/**
	 * myKeyListener override-a keyPressed od extendanog KayAdaptera gdje su
	 * implementirane komande za arrow keys
	 * 
	 * @author Haris
	 *
	 */
	public static class myKeyListener extends KeyAdapter {

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

	}

	/**
	 * U konstruktoru panelu Circle1 je dodan myKeyListener
	 */
	public Circle1() {
		this.addKeyListener(new myKeyListener());
	}

	/**
	 * Crtanje kruga
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillOval(x, y, 50, 50);
	}

	/**
	 * Pomjeranje kruga
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		x += frameX;
		y += frameY;
		repaint();

	}
}
