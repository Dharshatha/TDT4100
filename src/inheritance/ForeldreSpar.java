package inheritance;

public class ForeldreSpar extends SavingsAccount{
	private int restriction;
	private int withdrawcount;

	public ForeldreSpar(double rentefot, int restriction) {
		super(rentefot);
		this.restriction = restriction;
	}
	
	public void deposit(double amount) {
		super.deposit(amount);
	}
	
	public void withdraw(double amount) {
		if(this.restriction == this.withdrawcount) {
			throw new IllegalStateException("Du kan ikke ta ut mer for i år.");
		}
		else {
			super.withdraw(amount);
			this.withdrawcount++;
		}
	}
	
	public void endYearUpdate() {
		super.endYearUpdate();
		this.withdrawcount = 0 ;
	}
	
	public int getRemainingWithdrawals() {
		return this.restriction - this.withdrawcount;
	}
	
	
	

}
	
	


