import java.util.ArrayList;

public class Circles {
	ArrayList<BlueCircle> blues;

	public Circles() {
		blues = new ArrayList<BlueCircle>();
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