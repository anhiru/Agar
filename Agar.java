import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Agar {
	private static JFrame f;
	private static Circles c;

	public static void main(String[] args) {
		f = new JFrame();
		//fullscreen
		f.setSize(1280, 720);
		f.setTitle("Agar");
		//f.setBackground(new Color(180, 180, 180));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		c = new Circles();
		RedCircle r = new RedCircle();
		f.getContentPane().add(r);
		f.setVisible(true);

		for(int i = 0; i < 12; i++) {
			BlueCircle b = new BlueCircle();
			c.addCircle(b);
			f.getContentPane().add(b);
			f.setVisible(true);
		}

		//keyboard listener
		f.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
					case KeyEvent.VK_UP:
						//handle VK_UP
						break;
					case KeyEvent.VK_RIGHT:
						//handle right
						break;
					case KeyEvent.VK_DOWN:
						//handle down
						break;
					case KeyEvent.VK_LEFT:
						//handle left
						break;
				}
			}
		});

		while(true) {
			//60 fps
			try {
				Thread.sleep(17);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			f.repaint();
		}
	}
}