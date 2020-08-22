package encapsulation;

public class Rolle2Klasse {
	// 1-1 koblinger mellom objekter hvor ett objekt av EN TYPE 
	//BARE KAN HA EN NAVNGITT KOBLING til ett annet objekt av en annen eller samme type. 
	
	
	// Legger til motsatt klasse som en variabel og legger itl gettere og settere
	private Rolle1Klasse rolle1;
	
	public Rolle1Klasse getRolle1() {
		return this.rolle1;}
	
//	public void setRolle1(Rolle1Klasse rolle1) {
//		this.rolle1 = rolle1;}
//	
//	
//	//For å sette opp en gjensidig kobling, 
//	//så må en opprette ett objekt av hver type og kalle deres
//	//respektive set-metoder med det andre objektet som argument
//	
//	public static void main(String args[]) {
//		Rolle1Klasse r1 = new Rolle1Klasse();
//		Rolle2Klasse r2 = new Rolle2Klasse();
//		r1.setRolle2(r2);
//		r2.setRolle1(r1);
//		
//	}
//	//I koden ovenfor må vi sørge for konsistens SELV, det ønsker vi ikke.
//	// Vi ønsker at dersom vi bruker 1 set metode, så skal konsistens oppnås
//	

	
	public void setRolle1(Rolle1Klasse rolle1) {
		//sjekker om koblingen er riktig allerede
		if(this.rolle1 == rolle1) {
			return;
		}
		// lagerer den gamle rollen
		Rolle1Klasse oldrolle1 = this.rolle1;
		// koble fra gammel rolle
		if (oldrolle1 != null && oldrolle1.getRolle1() ==this) {
			oldrolle1.setRolle2(null);
		}
		// hvis dette er en ny kobling, oppdatere hos rolle1
		if(this.rolle1 != null) {
			this.rolle1.setRolle2(this);
		}
		
	}
}
