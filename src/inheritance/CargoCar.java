package inheritance;

public class CargoCar extends TrainCar{
	private int last;

	public CargoCar(int n, int last) {
		super(n);
		this.setCargoWeight(last);
	}
	
	public int getCargoWeight() {
		return this.last;	
	}
	
	public void setCargoWeight(int n) {
		if(n<0) {
			throw new IllegalArgumentException("Du kan ikke ha negativ tall som vekt!");
		}
		else {
			this.last = n;
			totalweight = n + super.getDeadWeight();
		}
	}
}
