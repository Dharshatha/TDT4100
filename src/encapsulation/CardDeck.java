package encapsulation;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {
	private List <Card> Kortstokk = new ArrayList<Card>();
	
	public CardDeck(int suitsize) {
		this.makeCard(suitsize);
	}
	
	public int getCardCount() {
		return this.Kortstokk.size();
	}
	
	public Card getCard(int n) {
		if(!(this.validN(n))){
			throw new IllegalArgumentException("Kortnummeret du spør om eksisterer ikke!");
		}
		else {
			return this.Kortstokk.get(n);
		}
	}
	
	public boolean validN(int n) {
		if (n < 0) {
			return false;
		}
		else if (this.Kortstokk.size() < n) {
			return false;
		}
		else { 
			return true;
		}
	}
	
	public boolean validInteger(int n) {
		if (n < 0 || n > 13) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean Notduplicate(Card Kort) {
		if (this.Kortstokk.contains(Kort)) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void makeCard(int n) {
		if(!(validInteger(n))) {
			throw new IllegalArgumentException("n kan ikke være negativt.");
		}
		else {
			for(int i=1; i<n+1; i++) {
				Card S = new Card('S', i);
				if(this.Notduplicate(S)) {
					this.Kortstokk.add(S);	
				}
			}
			for(int i=1; i<n+1; i++) {
				Card H = new Card('H', i);
				if(this.Notduplicate(H)) {
					this.Kortstokk.add(H);
				}
			}
			for(int i=1; i<n+1; i++) {
				Card D = new Card('D', i);
				if(this.Notduplicate(D)) {
					this.Kortstokk.add(D);
				}
			}
			for(int i=1; i<n+1; i++) {
				Card C = new Card('C', i);
				if(this.Notduplicate(C)) {
					this.Kortstokk.add(C);
				}
			}
		}
	}
	
	public void shufflePerfectly() {
		int halfSize = Kortstokk.size() / 2;
		for (int i = 0; i < halfSize; i++) {
			Card card = Kortstokk.remove(halfSize + i);
			Kortstokk.add(i * 2 + 1, card);
		}
	}

	
	
	public static void main (String[] args) {
		CardDeck Kortstokk = new CardDeck(4);
		System.out.println(Kortstokk.getCardCount());
		System.out.println(Kortstokk.getCard(0));
	}

}
