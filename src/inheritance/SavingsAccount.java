package inheritance;

public class SavingsAccount implements Account{
	private double amount;
	private double rentefot;
	
	public SavingsAccount(double rentefot) {
		this.deposit(0);
		this.rentefot = rentefot;
	}
	
	
	@Override
	public void deposit(double amount) {
		double gjeldene_amount = this.amount;
		if(amount < 0) {
			throw new IllegalArgumentException("Du kan ikke ha negativ mengde med penger");
		}
		else {
			this.amount = gjeldene_amount + amount;
		}
	}

	@Override
	public void withdraw(double amount) {
		double gjeldene_amount = this.amount;
		if(amount < 0) {
			throw new IllegalArgumentException("Du kan ikke ta ut negative penger");
		}
		else if(amount > gjeldene_amount) {
			throw new IllegalStateException("Mengden penger du spør om finnes ikke på konto");
		}
		else {
			this.amount = gjeldene_amount - amount;
		}
	}

	@Override
	public double getBalance() {
		return this.amount;
	}
	
	public double getInterest() {
		return this.rentefot;
	}
	
	protected void endYearUpdate() {
		double gjeldene_amount = this.amount;
		double ekstra_beløp = gjeldene_amount * this.getInterest();
		this.deposit(ekstra_beløp);
	}
	

}
