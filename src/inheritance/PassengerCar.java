package inheritance;

public class PassengerCar extends TrainCar{
	private int passenger;

	public PassengerCar(int n, int passenger) {
		super(n);
		this.setPassengerCount(passenger);
	}
	
	public int getPassengerCount() {
		return this.passenger;	
	}
	
	public void setPassengerCount(int n) {
		if(n<0) {
			throw new IllegalArgumentException("Du kan ikke ha negativ antall pasaggerer!");
		}
		else {
			this.passenger = n;
			totalweight = (n*80) + super.getDeadWeight();
		}
	}
}
