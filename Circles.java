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
			for(int j = i; j < blues.size(); j++) {
				BlueCircle a = blues.get(i);
				BlueCircle b = blues.get(j);
				if((a.x()+a.z() <= b.x()) || (b.x()+b.z() <= a.x())) {
					a.changeXRate();
					b.changeXRate();
				}
				if((a.y()+a.z() <= b.y()) || (b.y()+b.z() <= a.y())) {
					a.changeYRate();
					b.changeYRate(); 
				}
			}
		}
	}
}