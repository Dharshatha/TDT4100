package inheritance;

public class CreditAccount extends AbstractAccount{
	private double creditLine;
	
	public CreditAccount(double creditline) {
		super();
		this.setCreditLine(creditline);
	}

	
	
	protected void internalWithdraw(double uttaksbeløp) {
		if(uttaksbeløp < 0) {
			throw new IllegalArgumentException("Du kan ikke ta ut negativ penger");
		}
		else if(super.getBalance() < 0) {
			throw new IllegalStateException("Du har ikke nok penger");
		}
		else {
			super.balance -= uttaksbeløp;
		}
		
	}
	
	public double getCreditLine() {
		return this.creditLine;
	}
	
	protected void setCreditLine(double creditLine) {
		if(creditLine < 0 ) {
			throw new IllegalArgumentException("Du kan ikke sette negativ credit");
		}
		else if(creditLine > 0 - super.getBalance()){
			this.creditLine = creditLine;
		}
		else {
			throw new IllegalStateException("Du kan ikke legge til kreditt, dersom det ikke dekker det du har gått i minus.");
		}
	}
}
