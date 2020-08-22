package inheritance;

public class DebitAccount extends AbstractAccount {
	
	public DebitAccount() {
		super();
	}
	protected void internalWithdraw(double uttaksbeløp) {
		if(uttaksbeløp > super.balance) {
			throw new IllegalStateException("Du kan ikke ta ut mer penger enn det som finnes");
		}
		else {
			super.balance -= uttaksbeløp;
		}
	}

}
