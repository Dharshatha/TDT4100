package stateandbehavior;

public class Stopwatch {
	private int tiktok;
	
	
	public Stopwatch() {
		tick();
	}
	
	public Stopwatch(int y) {
		tick(y);
	}
	
	public void tick() {
		setTicktok(0);
	}
	
	public void tick(int x) {
		int tall = this.getTicktok() + x;
		setTicktok(tall);
	}
	
	public int getTicktok() {
		return this.tiktok;
	}
	
	public void setTicktok(int x) {
		this.tiktok=x;
	}
	
	public boolean isStarted() {
		if(this.getTicktok() > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	
}
