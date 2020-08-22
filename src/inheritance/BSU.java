package inheritance;

public class BSU extends SavingsAccount{
	private double maxgrense;
	private double availablebalance;

	public BSU(double rentefot, double maxgrense) {
		super(rentefot);
		this.maxgrense = maxgrense;
		this.availablebalance = 0;
	}
	
	public double getGrense() {
		return this.maxgrense;
	}
	
	public void deposit(double amount) {
		if(availablebalance + amount > this.getGrense()) {
			throw new IllegalStateException("Du kan ikke sette inn mer penger, siden det går over maksgrensen");
		}
		else {
			super.deposit(amount);
			this.availablebalance += amount;
		}
	}
	
	public void withdraw(double amount) {
		if(this.availablebalance < amount) {
			throw new IllegalStateException("Du kan ikke ta inn negativ verdi med penger");
		}
		else {
			super.withdraw(amount);
			this.availablebalance -= amount;
		}
	}
	
	public void endYearUpdate() {
		super.endYearUpdate();
		this.availablebalance = 0;
	}

	
	public double getTaxDeduction() {
		return this.availablebalance*0.20;
	}
	
	

}
