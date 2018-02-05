import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Agar {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(700, 720);
		f.setTitle("Agar");
		f.setBackground(new Color(180, 180, 180));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		RedCircle r = new RedCircle();
		f.add(r);
		f.setVisible(true);

		for(int i = 0; i < 10; i++) {
			BlueCircle b = new BlueCircle();
			f.add(b);
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
	}
}