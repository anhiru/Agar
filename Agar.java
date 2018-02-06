import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.TreeSet;

public class Agar {
	private static JFrame f;
	private static Circles c;
	private static TreeSet<Integer> pressed;

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
		pressed = new TreeSet<Integer>();
		f.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int i = e.getKeyCode();
				pressed.add(i);
				if(pressed.size() > 1) {
					Integer[] arr = pressed.toArray(new Integer[] {});
					if(arr[0] == KeyEvent.VK_UP && arr[1] == KeyEvent.VK_RIGHT) {
						r.moveUp();
						r.moveRight();
					}
					if(arr[0] == KeyEvent.VK_RIGHT && arr[1] == KeyEvent.VK_DOWN) {
						r.moveRight();
						r.moveDown();
					}
					if(arr[0] == KeyEvent.VK_LEFT && arr[1] == KeyEvent.VK_DOWN) {
						r.moveDown();
						r.moveLeft();
					}
					if(arr[0] == KeyEvent.VK_LEFT && arr[1] == KeyEvent.VK_UP) {
						r.moveLeft();
						r.moveUp();
					}
				} else {
					switch(i) {
						case KeyEvent.VK_UP:
							r.moveUp();
							break;
						case KeyEvent.VK_RIGHT:
							r.moveRight();
							break;
						case KeyEvent.VK_DOWN:
							r.moveDown();
							break;
						case KeyEvent.VK_LEFT:
							r.moveLeft();
							break;
					}
				}
			}
			public void keyReleased(KeyEvent e) {
				pressed.remove(Integer.valueOf(e.getKeyCode()));
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