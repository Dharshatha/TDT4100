package inheritance;

public class DebitAccount extends AbstractAccount {
	
	public DebitAccount() {
		super();
	}
	protected void internalWithdraw(double uttaksbel�p) {
		if(uttaksbel�p > super.balance) {
			throw new IllegalStateException("Du kan ikke ta ut mer penger enn det som finnes");
		}
		else {
			super.balance -= uttaksbel�p;
		}
	}

}
