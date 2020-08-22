package inheritance;

public abstract class AbstractAccount {
	protected double balance;
	
	public AbstractAccount() {
		this.balance = 0;
	}
	public void deposit(double beløp) {
		if(beløp < 0) {
			throw new IllegalArgumentException("Du kan ikke sette inn negativt beløp");
		}
		else {
			this.balance += beløp;
		}
	}
	
	public void withdraw(double tall) {
		if(tall < 0) {
			throw new IllegalArgumentException("Du kan ikke ta ut et negativt beløp");
		}
		else {
			this.internalWithdraw(tall);
		}
	}
	
	protected abstract void internalWithdraw(double uttaksbeløp);
	
	public double getBalance() {
		return this.balance;
		
	}
	

}
