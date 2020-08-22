package interfaces;

import java.util.Iterator;

public class CardContainerIterator implements Iterator<Card>{
	private CardContainer cardcontainer;
	private int cardcount;
	
	
	public CardContainerIterator(CardContainer cardcontainer) {
		this.cardcontainer = cardcontainer;
		this.cardcount = 0;
	}
	
	public boolean hasNext() {
		if(this.cardcontainer.getCardCount() >= this.cardcount) {
			return true;
		}
		
		else {
			return false; 
		}
	}
	
	public Card next() {
		Card hei = this.cardcontainer.getCard(cardcount);
		this.cardcount ++;
		return hei;
	}
	
	
	public void remove() {
		System.out.println("Finnes ikke slik metode enda!");
	}
			
}
