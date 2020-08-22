package inheritance;

public abstract class AbstractAccount {
	protected double balance;
	
	public AbstractAccount() {
		this.balance = 0;
	}
	public void deposit(double bel�p) {
		if(bel�p < 0) {
			throw new IllegalArgumentException("Du kan ikke sette inn negativt bel�p");
		}
		else {
			this.balance += bel�p;
		}
	}
	
	public void withdraw(double tall) {
		if(tall < 0) {
			throw new IllegalArgumentException("Du kan ikke ta ut et negativt bel�p");
		}
		else {
			this.internalWithdraw(tall);
		}
	}
	
	protected abstract void internalWithdraw(double uttaksbel�p);
	
	public double getBalance() {
		return this.balance;
		
	}
	

}
