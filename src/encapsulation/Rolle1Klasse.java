package encapsulation;

public class Rolle1Klasse {
	
	
	// Legger til motsatt klasse som en variabel, og legger til gettere og settere
	private Rolle2Klasse rolle2;
	
	public Rolle2Klasse getRolle1() {
		return this.rolle2;}
	
	public void setRolle2(Rolle2Klasse rolle2) {
		// sjekk om koblinegn er riktig allerede
		if (this.rolle2 ==rolle2) {
			return;
		}
		//husk den gamle og sett den nye
		Rolle2Klasse oldRolle2 = this.rolle2;
		this.rolle2 = rolle2;
		
		//hvis det var en kobling fra før, koble den andre fra
		if (oldRolle2 != null && oldRolle2.getRolle1() == this) {
			oldRolle2.setRolle1(null);
		}
		
		// hvis dette er en ny kobling, koble den andre til
		if (this.rolle2 != null) {
			this.rolle2.setRolle1(this);
		}
		
		}

}
