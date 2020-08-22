package inheritance;

public class SavingsAccount2 extends AbstractAccount{
	private int withdraws;
	private double fee;
	private int withdrawcount;
	
	public SavingsAccount2(int withdraws, double fee) {
		this.withdraws = withdraws;
		this.fee = fee;
		
	}

	
	public void deposit(double beløp) {
		if(beløp < 0) {
			throw new IllegalArgumentException("Du kan ikke sette inn negativt beløp");
		}
		else {
			this.balance += beløp;
		}
	}

	
	public int getWithdrawsCount() {
		return this.withdrawcount;
	}
	
	private void addWithdrawsCount() {
		this.withdrawcount ++;
	}
	
	private int getmaxwitthdraws() {
		return this.withdraws;
	}
	
	private double getFee() {
		return this.fee;
	}
	
	@Override
	public void internalWithdraw(double uttaksbeløp) {
		if(uttaksbeløp < 0) {
			throw new IllegalArgumentException("Du kan ikke ta ut et negativt beløp");
		}
		else if(uttaksbeløp > super.getBalance()) {
			throw new IllegalStateException("Du kan ikke ta ut mer penger enn det du har");
		}
		else if(this.getmaxwitthdraws() <= this.getWithdrawsCount()) {
			double nybeløp = uttaksbeløp + this.getFee();
			if(nybeløp > super.getBalance()) {
				throw new IllegalStateException("Du har ikke råd");
			}
			else {
				super.balance -= nybeløp;
				this.addWithdrawsCount();
			}
		}
		else {
			super.balance -= uttaksbeløp;
			this.addWithdrawsCount();
		}
	}
	
	

}
