package encapsulation;

public class Account {
	private double balance;
	private double interestRate;
	
	public Account(double balance, double interestRate) throws IllegalArgumentException{
		if(balance < 0) {
			throw new IllegalArgumentException("Du kan ikke ha negativ verdi i bankkonto");
		}
		
		else if (interestRate < 0) {
			throw new IllegalArgumentException("Du kan ikke ha negative renter");
		}
		
		else {
			this.balance = balance;
			this.interestRate = interestRate;
		}
	}
	public void deposit(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Du kan ikke ha negative amount");
		}
		else {
			this.balance += amount;
		}}
	
	public void withdraw(int penger) {
		if (penger<0) {
			throw new IllegalArgumentException("Du kan ikke ta ut negative penger");
		}
		else if (penger>100) {
			throw new IllegalArgumentException("Du kan ikke ta ut mer enn 150 kroner");
		}
		else {
			double balanse = this.balance;
			this.balance = balanse - penger;
		}
		
	}
	
	public void addInterest() {
		double Pengerikonto = balance;
		double Renteprosent = this.interestRate;
		double rentepenger = Pengerikonto*(Renteprosent/100);
		this.balance = Pengerikonto + rentepenger; 
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public double getInterestRate() {
		return this.interestRate;
	}
	
	public void setInterestRate(double nyrente) {
		if (nyrente < 0) {
			throw new IllegalArgumentException("Du kan ikke ha negative renter");
		}
		
		else {
		this.interestRate = nyrente;}
	}
	
	public static void main(String[] args) {
		Account account = new Account(2, 5);
		System.out.println(account.getBalance());
		account.deposit(100.00);
		account.setInterestRate(9.0);
		System.out.println(account.getInterestRate());
		account.addInterest();		
		System.out.println(account.getBalance());

		
	}
	

}
