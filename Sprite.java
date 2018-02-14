import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;
import java.util.Random;

class Sprite extends JComponent {
	private Random rn;
	private int x, y, diameter;
	private double velX, velY, speed;
	private boolean up, right, down, left;
	private int bluesEaten;

	public Sprite() {
		rn = new Random();
		x = rn.nextInt(1080) + 101;
		y = rn.nextInt(500) + 101;
		diameter = 50;
		speed = 420/diameter;
		bluesEaten = 0;
	}
	public void paintComponent(Graphics graphics) {
		Graphics2D g = (Graphics2D) graphics;
		setBounds();
		Ellipse2D.Double circle = new Ellipse2D.Double(x, y, diameter, diameter);
		g.setColor(new Color(255, 130, 130));
		g.draw(circle);
		g.fill(circle);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Impact", Font.PLAIN, 24));
		g.drawString(Integer.toString(bluesEaten), 24, 42);
		if(bluesEaten == 15) {
			g.setFont(new Font("Lucida Handwriting", Font.ITALIC, 42));
			g.drawString("GAME!", 560, 340);
		}
	}
	public void setBounds() {
		if(x < 0) {
			x = 0;
		}
		if(x + diameter > 1280) {
			x = 1280 - diameter;
		}
		if(y < 0) {
			y = 0;
		}
		if(y + diameter > 700) {
			y = 700 - diameter;
		}
	}
	public boolean hitXEdge() {
		return (x < 0 || x + 150 > 700);
	}
	public boolean hitYEdge() {
		return (y < 0 || y + 150 > 700);
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
	public void setVelX(double velX) {
		this.velX = velX;
		x += velX;
	}
	public void setVelY(double velY) {
		this.velY = velY;
		y += velY;
	}
	//updates according to boolean variables to prevent lag
	public void update() {
		if(up) {
			setVelY(-speed);
		}
		if(right) {
			setVelX(speed);
		}
		if(down) {
			setVelY(speed);
		}
		if(left) {
			setVelX(-speed);
		}
	}
	public void move(char direction) {
		if(direction == 'u') {
			up = true;
		}
		if(direction == 'r') {
			right = true;
		}
		if(direction == 'd') {
			down = true;
		}
		if(direction == 'l') {
			left = true;
		}
	}
	public void stop(char direction) {
		if(direction == 'u') {
			up = false;
		}
		if(direction == 'r') {
			right = false;
		}
		if(direction == 'd') {
			down = false;
		}
		if(direction == 'l') {
			left = false;
		}
	}
	public void grow(double size) {
		diameter += size;
		speed = 420/diameter;
		bluesEaten++;
	}
}