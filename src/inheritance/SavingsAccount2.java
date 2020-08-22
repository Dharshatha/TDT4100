package inheritance;

public class SavingsAccount2 extends AbstractAccount{
	private int withdraws;
	private double fee;
	private int withdrawcount;
	
	public SavingsAccount2(int withdraws, double fee) {
		this.withdraws = withdraws;
		this.fee = fee;
		
	}

	
	public void deposit(double bel�p) {
		if(bel�p < 0) {
			throw new IllegalArgumentException("Du kan ikke sette inn negativt bel�p");
		}
		else {
			this.balance += bel�p;
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
	public void internalWithdraw(double uttaksbel�p) {
		if(uttaksbel�p < 0) {
			throw new IllegalArgumentException("Du kan ikke ta ut et negativt bel�p");
		}
		else if(uttaksbel�p > super.getBalance()) {
			throw new IllegalStateException("Du kan ikke ta ut mer penger enn det du har");
		}
		else if(this.getmaxwitthdraws() <= this.getWithdrawsCount()) {
			double nybel�p = uttaksbel�p + this.getFee();
			if(nybel�p > super.getBalance()) {
				throw new IllegalStateException("Du har ikke r�d");
			}
			else {
				super.balance -= nybel�p;
				this.addWithdrawsCount();
			}
		}
		else {
			super.balance -= uttaksbel�p;
			this.addWithdrawsCount();
		}
	}
	
	

}
