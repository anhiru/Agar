import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;
import java.util.Random;

class BlueCircle extends JComponent {
	Random rn;
	private int x, y, z;

	public BlueCircle() {
		rn = new Random();
		x = rn.nextInt(680) + 1;
		y = rn.nextInt(680) + 1;
		z = rn.nextInt(11) + 15;
	}
	public void paintComponent(Graphics graphics) {
		Graphics2D g = (Graphics2D) graphics;
		Ellipse2D.Double circle = new Ellipse2D.Double(x, y, z, z);
		g.setColor(Color.BLUE);
		g.draw(circle);
		g.fill(circle);
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}