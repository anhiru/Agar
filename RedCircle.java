import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;
import java.util.Random;

class RedCircle extends JComponent {
	private Random rn;
	private int x, y, diameter;
	private double velX, velY, speed;
	private boolean up, right, down, left;

	public RedCircle() {
		rn = new Random();
		x = rn.nextInt(1080) + 101;
		y = rn.nextInt(500) + 101;
		diameter = 50;
		speed = 500/diameter;
	}
	public void paintComponent(Graphics graphics) {
		Graphics2D g = (Graphics2D) graphics;
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
		Ellipse2D.Double circle = new Ellipse2D.Double(x, y, diameter, diameter);
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
	public int getDiameter() {
		return diameter;
	}
	
	public void moveUp() {
		velY = -500/diameter;
		y += velY;
	}
	public void moveRight() {
		velX = 500/diameter;
		x += velX;
	}
	public void moveDown() {
		velY = 500/diameter;
		y += velY;
	}
	public void moveLeft() {
		velX = -500/diameter;
		x += velX;
	}
	
	public void setVelX(double velX) {
		this.velX = velX;
		x += velX;
	}
	public void setVelY(double velY) {
		this.velY = velY;
		y += velY;
	}
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
	public void setTrue(char direction) {
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
	public void setFalse(char direction) {
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
}