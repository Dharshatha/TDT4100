package objectstructures;

public class Partner {
	private String name;
	private Partner partner;
	
	public Partner(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Partner getPartner() {
		return this.partner;
	}
	
	public String toString() {
		Partner Partner = this.getPartner();
		return this.getName() + "sin partner er" + Partner.getName();
	}
	
	//tenk at to skal jeg skal skille meg og gifte meg med en ny en
	public void setPartner(Partner partner) {
		//sjekker om denne relasjonen allerede eksisterer
		if(this.getPartner() == partner) {
			return;
		}
		
		//Setter min nåværende partner som min ex
		Partner Expartner = this.partner;
		//Setter min nye partner, som min nåværende partner
		this.partner = partner;
		
		// må fjerne meg som partner hos min ex. Dersom min ex sin partner ikke er null og er meg:
		if (Expartner != null && Expartner.getPartner() == this ) {
			Expartner.setPartner(null);
		}
		
		// dersom min nye partner ikke er null

		if(partner != null) {
			partner.setPartner(this);
		}
		
	}
	

	

}
