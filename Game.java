import java.util.ArrayList;
//import javax.swing.Timer;

class Game {
	private ArrayList<Dot> dots;
	private boolean gameOver;

	public Game() {
		dots = new ArrayList<Dot>();
		gameOver = false;
	}
	public void addDot(Dot d) {
		dots.add(d);
	}
	public void eat(Sprite s) {
		for(int i = 0; i < dots.size(); i++) {
			Dot d = dots.get(i);
			double distance = Math.sqrt(Math.pow(s.x()-d.x(), 2) + Math.pow(s.y()-d.y(), 2));
			double brRadius = s.getRadius() + d.getRadius();
			if(!(brRadius < distance || Math.abs(s.getRadius() - d.getRadius()) >= distance)) {
				d.getEaten();
				s.grow(d.getRadius());
				dots.remove(d);
			}
		}
		if(dots.size() == 0) {
			gameOver = true;
		}
	}
	public void bump() {
		for(Dot a : dots) {
			for(Dot b : dots) {
				double distance = Math.sqrt(Math.pow(a.x()-b.x(), 2) + Math.pow(a.y()-b.y(), 2));
				double abRadius = a.getRadius() + b.getRadius();
				if(!(abRadius < distance || Math.abs(a.getRadius()-b.getRadius()) >= distance)) {
					a.changeVelX();
					a.changeVelY();
				}
			}
		}
	}
	public boolean isGameOver() {
		return gameOver;
	}
	/*
	public void newGame() {
		gameOver = false;
		dots.clear();
	}
	*/
}