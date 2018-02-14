import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.TreeSet;

//Tinfoil#2751
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
				pressed.add(e.getKeyCode());
				if(pressed.size() > 1) {
					Integer[] arr = pressed.toArray(new Integer[] {});
					if(arr[0] == KeyEvent.VK_UP && arr[1] == KeyEvent.VK_RIGHT) {
						//r.moveUp();
						//r.moveRight();
						r.setTrue('u');
						r.setTrue('r');
					}
					if(arr[0] == KeyEvent.VK_RIGHT && arr[1] == KeyEvent.VK_DOWN) {
						//r.moveRight();
						//r.moveDown();
						r.setTrue('r');
						r.setTrue('d');
					}
					if(arr[0] == KeyEvent.VK_LEFT && arr[1] == KeyEvent.VK_DOWN) {
						//r.moveDown();
						//r.moveLeft();
						r.setTrue('d');
						r.setTrue('l');
					}
					if(arr[0] == KeyEvent.VK_LEFT && arr[1] == KeyEvent.VK_UP) {
						//r.moveLeft();
						//r.moveUp();
						r.setTrue('l');
						r.setTrue('u');
					}
				} else {
					switch(e.getKeyCode()) {
						case KeyEvent.VK_UP:
							//r.moveUp();
							r.setTrue('u');
							break;
						case KeyEvent.VK_RIGHT:
							//r.moveRight();
							r.setTrue('r');
							break;
						case KeyEvent.VK_DOWN:
							//r.moveDown();
							r.setTrue('d');
							break;
						case KeyEvent.VK_LEFT:
							//r.moveLeft();
							r.setTrue('l');
							break;
					}
				}
				r.update();
			}
			public void keyReleased(KeyEvent e) {
				pressed.remove(Integer.valueOf(e.getKeyCode()));
				switch(e.getKeyCode()) {
					case KeyEvent.VK_UP:
						//r.moveUp();
						r.setFalse('u');
						break;
					case KeyEvent.VK_RIGHT:
						//r.moveRight();
						r.setFalse('r');
						break;
					case KeyEvent.VK_DOWN:
						//r.moveDown();
						r.setFalse('d');
						break;
					case KeyEvent.VK_LEFT:
						//r.moveLeft();
						r.setFalse('l');
						break;
				}
				r.update();
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