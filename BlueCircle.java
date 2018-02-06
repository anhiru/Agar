import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;
import java.util.Random;

class BlueCircle extends JComponent {
	private Random rn;
	private Circles c;
	private int x, y, z;
	private int xRate, yRate;

	//rn.nextInt(max - min + 1) + min
	public BlueCircle() {
		rn = new Random();
		c = new Circles();
		x = rn.nextInt(1260) + 1;
		y = rn.nextInt(680) + 1;
		z = rn.nextInt(11) + 15;
		xRate = (rn.nextInt(4) + 2) * rnPosNeg();
		yRate = (rn.nextInt(4) + 2) * rnPosNeg();
	}
	public void paintComponent(Graphics graphics) {
		Graphics2D g = (Graphics2D) graphics;
		Ellipse2D.Double circle = new Ellipse2D.Double(x, y, z, z);
		g.setColor(Color.BLUE);
		g.draw(circle);
		g.fill(circle);
		if(hitXEdge()) {
			changeXRate();
		}
		if(hitYEdge()) {
			changeYRate();
		}
		c.ballBumped();
		x += xRate;
		y += yRate;
	}
	public int rnPosNeg() {
		int i = rn.nextInt(3) - 1;
		if(i == 0) {
			return 1;
		} else {
			return i;
		}
	}
	public boolean hitXEdge() {
		return (x < 0 || x + z() > 1280);
	}
	public boolean hitYEdge() {
		return (y < 0 || y + z() > 700);
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
	public void changeXRate() {
		xRate *= -1;
	}
	public void changeYRate() {
		yRate *= -1;
	}
}