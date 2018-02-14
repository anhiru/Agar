import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.TreeSet;

public class Agar {
	private static Game g;
	private static JFrame f;

	public static void main(String[] args) {
		g = new Game();
		f = new JFrame();
		//fullscreen
		f.setSize(1280, 720);
		f.setTitle("Agar");
		f.getContentPane().setBackground(new Color(25, 25, 25));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Sprite s = new Sprite();
		f.add(s);
		f.setVisible(true);

		for(int i = 0; i < 15; i++) {
			Dot d = new Dot();
			g.addDot(d);
			f.add(d);
			f.setVisible(true);
		}
		
		//keyboard listener
		TreeSet<Integer> pressed = new TreeSet<Integer>();
		f.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				pressed.add(e.getKeyCode());
				if(pressed.size() > 1) {
					Integer[] arr = pressed.toArray(new Integer[] {});
					if(arr[0] == KeyEvent.VK_UP && arr[1] == KeyEvent.VK_RIGHT) {
						s.move('u');
						s.move('r');
					}
					if(arr[0] == KeyEvent.VK_RIGHT && arr[1] == KeyEvent.VK_DOWN) {
						s.move('r');
						s.move('d');
					}
					if(arr[0] == KeyEvent.VK_LEFT && arr[1] == KeyEvent.VK_DOWN) {
						s.move('d');
						s.move('l');
					}
					if(arr[0] == KeyEvent.VK_LEFT && arr[1] == KeyEvent.VK_UP) {
						s.move('l');
						s.move('u');
					}
				} else {
					switch(e.getKeyCode()) {
						case KeyEvent.VK_UP:
							s.move('u');
							break;
						case KeyEvent.VK_RIGHT:
							s.move('r');
							break;
						case KeyEvent.VK_DOWN:
							s.move('d');
							break;
						case KeyEvent.VK_LEFT:
							s.move('l');
							break;
					}
				}
			}
			//updates boolean variables each key press/release
			public void keyReleased(KeyEvent e) {
				pressed.remove(Integer.valueOf(e.getKeyCode()));
				switch(e.getKeyCode()) {
					case KeyEvent.VK_UP:
						s.stop('u');
						break;
					case KeyEvent.VK_RIGHT:
						s.stop('r');
						break;
					case KeyEvent.VK_DOWN:
						s.stop('d');
						break;
					case KeyEvent.VK_LEFT:
						s.stop('l');
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
			g.eat(s);
			g.bump();
			s.update();
			f.repaint();
		}
	}
}
