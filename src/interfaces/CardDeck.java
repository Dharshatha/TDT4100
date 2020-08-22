package interfaces;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CardDeck implements CardContainer{
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
	

	
	
	public void deal(CardHand hand, int flytteantallkort) {
		if(this.Kortstokk.isEmpty()) {
			throw new IllegalArgumentException("Du kan ikke flytte over kort, når kortstokken er tom.");
		}
		else {	
			if(this.validN(flytteantallkort)){
				Integer j = flytteantallkort;
				for(int i = Kortstokk.size(); i>-1 && j>0; i--) {
					Card sistekort = Kortstokk.get(Kortstokk.size() - 1);
					hand.addCard(sistekort);
					Kortstokk.remove(sistekort);
					j = j-1;
					}
				}
			}		
	}

	@Override
	public Iterator<Card> iterator() {
		return Kortstokk.iterator();
	}
	
	
	
	public boolean hasCard(Predicate<Card> predicate) {
		return (Kortstokk.stream().anyMatch(predicate));
	}
	
	public int getCardCount(Predicate<Card> predicate) {
		long total = Kortstokk.stream().filter(predicate).count();
		String total1 = Long.toString(total);
		int total2 = Integer.parseInt(total1);
		return total2;
		
	}
	
	public List<Card> getCards(Predicate<Card> predicate){
		return(Kortstokk.stream().filter(predicate).collect(Collectors.toList()));
		
	}
	
	/*
	 * 	public boolean hasCard(Predicate<Card> p) {
		for (Card card: cards) {
			if (p.test(card)) {
				return true; 
			}
		}
		return false; 
	}
	
	public int getCardCount(Predicate<Card> p) {
		int count = 0; 
		for (Card card : cards) {
			if (p.test(card)) {
				count++;
			}
		}
		return count; 
	}
	
	public List<Card> getCards(Predicate<Card> p) {
		List<Card> matchingCards = new ArrayList<Card>();
		for (Card card : cards) {
			if (p.test(card)) {
				matchingCards.add(card);
			}
		}
		return matchingCards; 	
	}

	 */


	public static void main (String[] args) {
		CardDeck Kortstokk = new CardDeck(4);
		CardContainerIterator halla = new CardContainerIterator(Kortstokk);
		System.out.println(Kortstokk.getCardCount());
		System.out.println(Kortstokk.getCard(0));
		System.out.println(halla.hasNext());
		while(halla.hasNext()) {
			System.out.println(halla.next());
		}
	}

}
