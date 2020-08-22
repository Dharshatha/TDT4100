package objectstructures;

import java.util.ArrayList;
import java.util.List;

public class CardHand {
	List <Card> Kortihanda = new ArrayList<Card>();
	
	public int getCardCount() {
		return this.Kortihanda.size();
	}
	
	public Card getCard(int n) {
		if(!(this.validN(n))){
			throw new IllegalArgumentException("Kortnummeret du spør om eksisterer ikke!");
		}
		else {
			return this.Kortihanda.get(n);
		}
	}
	
	public boolean validN(int n) {
		if (n < 0) {
			return false;
		}
		else if (this.Kortihanda.size() < n) {
			return false;
		}
		else { 
			return true;
		}
	}
	
	public boolean Notduplicate(Card Kort) {
		if (this.Kortihanda.contains(Kort)) {
			return false;
		}
		else {
			return true;
		}
	}
	public void addCard(Card kort) {
		if(this.Notduplicate(kort)) {
			this.Kortihanda.add(kort);	
		}
		else {
			System.out.println("Kortet ble ikke lagt til i hånda.");
		}	
	}
	

	public Integer play(int n) {
		Integer tall = n;
		if(this.Kortihanda.get(n) != null && this.validN(n)) {
			this.Kortihanda.remove(n);
			return tall;
		}
		else {
			throw new IllegalArgumentException("Du kan ikke gjerne et kort som ikke finnes i hånda");
		}
		
		
	}
	
	
}
