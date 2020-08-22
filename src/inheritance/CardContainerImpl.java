package inheritance;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CardContainerImpl implements CardContainer {
	protected List<Card> cards = new ArrayList<Card>();
	private int maxCardCount;
	
	public CardContainerImpl(int n) {
		this.maxCardCount = n;
	}

	@Override
	public Iterator<Card> iterator() {
		// TODO Auto-generated method stub
		return cards.iterator();
	}
	
	public int getMaxCardCount() {
		return this.maxCardCount;
	}

	@Override
	public int getCardCount() {
		// TODO Auto-generated method stub
		return cards.size();
	}

	@Override
	public Card getCard(int n) throws IllegalArgumentException {
		if(!(this.validN(n))){
			throw new IllegalArgumentException("Kortnummeret du spør om eksisterer ikke!");
		}
		else {
			return cards.get(n);
		}
	}
	protected boolean validN(int n) {
		if (n < 0) {
			return false;
		}
		else if (this.cards.size() < n) {
			return false;
		}
		else { 
			return true;
		}
	}
	
	protected void AddCard(Card card) {
		if (getCardCount() >= getMaxCardCount()) {
			throw new IllegalStateException("Too many cards");
		}
		cards.add(card);
	}

	
	protected boolean Notduplicate(Card Kort) {
		if (this.cards.contains(Kort)) {
			return false;
		}
		else {
			return true;
		}
	} 
	

}
