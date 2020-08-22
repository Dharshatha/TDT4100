package encapsulation;

import java.util.ArrayList;
import java.util.List;

public class StopWatch {
	private boolean isStarted = false;
	private boolean isStopped = false;
	private static int ticks =0;
	private int time =0;
	private int laptime;
	private List<Integer> LapTime = new ArrayList<Integer>();

	
	
	public StopWatch() {
	}
	
	public boolean isStarted() {
		return this.isStarted;
	}
	
	public boolean isStopped() {
		return this.isStopped;	
	}
	
	public int getTicks() {
		return StopWatch.ticks;
	}
	
	public int getTime() {
		if(!this.isStarted()) {
			return -1;
		}
		else {
			return this.time;
		}
		
	}
	
	public int getLapTime() {
		if(!this.isStarted()) {
			return -1;
		}
		else {
			int rundetidstart = this.LapTime.get(this.LapTime.size()-1);
			int tidnu = this.getTime();
			int nurundetid = tidnu - rundetidstart;
			return nurundetid;
		}
	}
	
	public int getLastLapTime() {
		if(this.LapTime.size() <2) {
			return -1;
		}
		
		else {
			int sistetid = this.LapTime.get(this.LapTime.size()-1);
			int nestsiste = this.LapTime.get(this.LapTime.size()-2);
			int nu = sistetid-nestsiste;
			return nu;
		}
		
	}
	
	public void tick(int ticks) {
		if((isStopped() == false) && ticks > 0) {
			StopWatch.ticks += ticks;
			this.time += ticks;
		}	
	}
	
	public void start() {
		this.isStarted = true;
		this.tick(0);
		this.laptime = 0;
		this.LapTime.add(this.laptime);
	}
	
	public void lap() {
		if(isStarted() == true && isStopped() == false) {
			int time = this.getTime();
			this.LapTime.add(time);	
		}
		else {
			throw new IllegalArgumentException("Du kan ikke ta rundtider, nå klokka har blitt slått av.");
		}
	}
	
	public void stop() {
		this.isStopped = true;
	}
	
	
	
	

}


