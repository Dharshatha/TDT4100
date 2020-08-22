package app;

public class IbsToKg {
	//Het IBS før
	private double pound;
	private double Kg;
	
	public IbsToKg(double pound) {
		setPound(pound);
	}
	
	public IbsToKg() {
	}

	public double getPound() {
		return pound;
	}

	public void setPound(double pound) {
		this.pound = pound;
	}

	public double getKg() {
		return Kg;
	}

	public void setKg(double kg) {
		Kg = kg;
	}
	
	public double IbstilKg(double pound) {
		Kg = pound*0.45359237;	
		return Kg;
	}
}
