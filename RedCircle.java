import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;
import java.util.Random;

class RedCircle extends JComponent {
	Random rn;
	private int x, y;

	public RedCircle() {
		rn = new Random();
		x = rn.nextInt(500) + 101;
		y = rn.nextInt(500) + 101;
	}
	public void paintComponent(Graphics graphics) {
		Graphics2D g = (Graphics2D) graphics;
		Ellipse2D.Double circle = new Ellipse2D.Double(x, y, 75, 75);
		g.setColor(Color.RED);
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