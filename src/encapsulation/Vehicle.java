package encapsulation;

public class Vehicle {
	private char kjoretoytype;
	private char drivstofftype;
	private String reginr;
	
	
	public Vehicle(char kjoretoytype, char drivstofftype, String reginr){
		this.setkjoretoytype(kjoretoytype);
		this.setFuelType(drivstofftype);
		this.setRegistrationNumber(reginr);
	}
	
	public boolean ValidType(char kjoretoytype) {
		if ((kjoretoytype == 'C' || kjoretoytype == 'M')) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void setkjoretoytype(char kjoretoytype) {
		if (!(this.ValidType(kjoretoytype))) {
			throw new IllegalArgumentException("Du har satt inn feil kjøretøystype");
		}
		else {
			this.kjoretoytype = kjoretoytype;
		}
	}
	
	public char getVehicleType() {
		return this.kjoretoytype;
	}
	
	public char getFuelType() {
		return this.drivstofftype;
	}
	
	public boolean validFuelType(char drivtype) {
		if(!(drivtype == 'H' || drivtype == 'E' || drivtype == 'D' || drivtype == 'G')) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
	public boolean validFuelandVehicle(char drivtype) {
		char transporttype = this.getVehicleType();
		if (transporttype =='M' && drivtype == 'H') {
			return false;
		}
		else {
			return true;
		}	
	}
	
	
	public void setFuelType(char drivtype) {
		if (!(this.validFuelType(drivtype))){
			throw new IllegalArgumentException("Du har satt feil i drivstoffbokstav");
		}
		if (!(this.validFuelandVehicle(drivtype))) {
			throw new IllegalArgumentException("Det finnes ikke motorsykkel som kjører på hydrogen");
		}
		else {
			this.drivstofftype = drivtype;
		}
	}
	
	
	public String getRegistrationNumber() {
		return this.reginr;
	}
	
	

	
	public boolean validRegistrationNumberFormat(String reginr) {
		String bokstav = reginr.substring(0, 2);
		String tall = reginr.substring(2);
		if (!((bokstav.length() ==2) && (bokstav.matches("^[A-Z]+$")))){
			return false;	
		}
		if(!(tall.matches("^[0-9]*$"))) {
			return false;
			}
		else {
			return true;
		}		
	}
	
		
	public boolean matchreginrfueltype(String reginr) {
		char fuel = this.getFuelType();
		String letters = reginr.substring(0, 2);
		if (fuel == 'H' && (!letters.matches("HY"))) {
			return false;}
		if (fuel == 'E' && !(letters.matches("EL") || letters.matches("EK"))) {
			return false;}
		if ((fuel == 'D' || fuel == 'G') && (letters.matches("EL") || letters.matches("EK") || letters.matches("HY")))
			{return false;}
		else {
			return true;
		}

	}
	
	public boolean Alfavehicle(String reginr) {
		char vehicle = this.getVehicleType();
		String tall = reginr.substring(2);	
		if((vehicle == 'M' && tall.length() == 4) || (vehicle == 'C' && tall.length() == 5)) {
			return true;	
		}
		else {
			return false;
		}
	}
	
	public void setRegistrationNumber(String reginr) {
		if(!(this.validRegistrationNumberFormat(reginr))) {
			throw new IllegalArgumentException("Du har feil format på registreringsnummeret, pass på at du bruker store bokstaver");
		}
		if(!(this.Alfavehicle(reginr))) {
			throw new IllegalArgumentException("Pass på at du har riktig antall tall på registreringsnummeret");
		}
		if (!(this.matchreginrfueltype(reginr))) {
			throw new IllegalArgumentException("Drivstofftypen matcher ikke med registreringsnummer");
		}
		else {
			this.reginr = reginr;
		}
		
		
	}

}
