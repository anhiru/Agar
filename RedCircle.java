import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;
import java.util.Random;

class RedCircle extends JComponent {
	private Random rn;
	private int x, y;
	//private int xRate, yRate;

	public RedCircle() {
		rn = new Random();
		x = rn.nextInt(1080) + 101;
		y = rn.nextInt(500) + 101;
		//xRate = rn.nextInt(5) + 5;
		//yRate = rn.nextInt(5) + 5;
	}
	public void paintComponent(Graphics graphics) {
		Graphics2D g = (Graphics2D) graphics;
		Ellipse2D.Double circle = new Ellipse2D.Double(x, y, 50, 50);
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
	public int getXCoord() {
		return x;
	}
	public int getYCoord() {
		return y;
	}
}