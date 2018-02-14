import java.util.ArrayList;
import javax.swing.Timer;

public class Circles {
	ArrayList<BlueCircle> blues;
	//Timer timer;
	//int seconds;

	public Circles() {
		blues = new ArrayList<BlueCircle>();
		/*
		seconds = 0;
		timer = new Timer(1000, e -> {
			seconds++;
			time.setText(String.format("Time: %.2d:%.2d ", (seconds%3600)/60, (seconds%60)));
		});
		*/
	}
	public void addCircle(BlueCircle b) {
		blues.add(b);
	}
	public void ballBumped() {
		for(int i = 0; i < blues.size(); i++) {
			for(int j = 0; j < blues.size(); j++) {
				BlueCircle a = blues.get(i);
				BlueCircle b = blues.get(j);
				double distance = Math.sqrt(Math.pow(b.x()-a.x(), 2) + Math.pow(b.y()-a.y(), 2));
				double abRadius = a.getRadius() + b.getRadius();
				if(abRadius >= distance || a.getRadius() - b.getRadius() <= distance || b.getRadius() - a.getRadius() <= distance) {
					a.changeVelX();
					b.changeVelX();
					a.changeVelY();
					b.changeVelY(); 
				}
			}
		}
	}
}