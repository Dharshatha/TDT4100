package encapsulation;

public class Digit {
	
	private int tallsystem;
	private int verdi;
	
	public Digit(int tallsystem) throws IllegalArgumentException {
		if (tallsystem < 0) {
			throw new IllegalArgumentException("Du kan ikke ha et negativt tallsystem");
		}
		
		else {
			this.tallsystem = tallsystem;
			this.verdi =0;
			
		}
		
	}
	
	public int getValue() {
		return this.verdi;
	}
	
	public boolean increment() {
		int nyverdi = this.verdi +1;
		if (nyverdi == this.tallsystem) {
			this.verdi = 0;
			return true;
		}
		else {
			this.verdi = nyverdi;
			return false;
			}
			
		}

	public int getBase() {
		return this.tallsystem;
	}
	
	public String toString() {
		return String.valueOf("0123456789ABCDEFGHIJKLMNOPGQRSTUVWXYZ".charAt(verdi));
		}
		
	
}


