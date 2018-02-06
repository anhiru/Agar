import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;
import java.util.Random;

class RedCircle extends JComponent {
	private Random rn;
	private int x, y, z;
	private int xRate, yRate;

	public RedCircle() {
		rn = new Random();
		x = rn.nextInt(1080) + 101;
		y = rn.nextInt(500) + 101;
		z = 50;
	}
	public void paintComponent(Graphics graphics) {
		Graphics2D g = (Graphics2D) graphics;
		if(x < 0) {
			x = 0;
		}
		if(x + z > 1280) {
			x = 1280 - z;
		}
		if(y < 0) {
			y = 0;
		}
		if(y + z > 700) {
			y = 700 - z;
		}
		Ellipse2D.Double circle = new Ellipse2D.Double(x, y, z, z);
		g.setColor(Color.RED);
		g.draw(circle);
		g.fill(circle);
	}
	public boolean hitXEdge() {
		return (x < 0 || x + 150 > 700);
	}
	public boolean hitYEdge() {
		return (y < 0 || y + 150 > 700);
	}
	public int x() {
		return x;
	}
	public int y() {
		return y;
	}
	public int z() {
		return z;
	}
	public void moveUp() {
		yRate = -500/z;
		y += yRate;
	}
	public void moveRight() {
		xRate = 500/z;
		x += xRate;
	}
	public void moveDown() {
		yRate = 500/z;
		y += yRate;
	}
	public void moveLeft() {
		xRate = -500/z;
		x += xRate;
	}
}