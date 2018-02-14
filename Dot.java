import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;
import java.util.Random;

class Dot extends JComponent {
	private Random rn;
	private int x, y, diameter;
	private double velX, velY;
	private boolean eaten;

	//rn.nextInt(max - min + 1) + min
	public Dot() {
		rn = new Random();
		x = rn.nextInt(1260) + 1;
		y = rn.nextInt(680) + 1;
		diameter = rn.nextInt(11) + 15;
		velX = (rn.nextInt(3) + 1) * rnPosNeg();
		velY = (rn.nextInt(3) + 1) * rnPosNeg();
		eaten = false;
	}
	public void paintComponent(Graphics graphics) {
		Graphics2D g = (Graphics2D) graphics;
		if(!eaten) {
			Ellipse2D.Double circle = new Ellipse2D.Double(x, y, diameter, diameter);
			g.setColor(new Color(150, 230, 230));
			g.draw(circle);
			g.fill(circle);
			if(hitXEdge()) {
				changeVelX();
			}
			if(hitYEdge()) {
				changeVelY();
			}
			x += velX;
			y += velY;
		}
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
		return (x < 0 || x + diameter > 1280);
	}
	public boolean hitYEdge() {
		return (y < 0 || y + diameter > 700);
	}
	public int x() {
		return x + diameter/2;
	}
	public int y() {
		return y + diameter/2;
	}
	public double getRadius() {
		return diameter/2;
	}
	public void changeVelX() {
		velX *= -1;
	}
	public void changeVelY() {
		velY *= -1;
	}
	public void getEaten() {
		eaten = true;
	}
}