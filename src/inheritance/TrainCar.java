package inheritance;

public class TrainCar {
	private int deadweight;
	protected int totalweight;
	
	
	public TrainCar(int n) {
		this.setDeadWeight(n);
	}
	
	public int getTotalWeight() {
		return this.totalweight;
	}
	
	protected void setDeadWeight(int n) {
		if(0>n) {
			throw new IllegalArgumentException("Du kan ikke ha negativ vekt!");
		}
		else {
			this.deadweight = n;
		}
	}
	
	public int getDeadWeight() {
		return this.deadweight;
	}
	
	
	

}
