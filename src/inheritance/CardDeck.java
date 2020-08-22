package inheritance;



public class CardDeck extends CardContainerImpl{

	public CardDeck(int n) {
		super(52);
		this.makeCard(n);
	}

	public boolean validInteger(int n) {
		if (n < 0 || n > 13) {
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
				if(super.Notduplicate(S)) {
					super.cards.add(S);	
				}
			}
			for(int i=1; i<n+1; i++) {
				Card H = new Card('H', i);
				if(super.Notduplicate(H)) {
					super.cards.add(H);
				}
			}
			for(int i=1; i<n+1; i++) {
				Card D = new Card('D', i);
				if(super.Notduplicate(D)) {
					super.cards.add(D);
				}
			}
			for(int i=1; i<n+1; i++) {
				Card C = new Card('C', i);
				if(super.Notduplicate(C)) {
					super.cards.add(C);
				}
			}
		}
	}
	
	public void shufflePerfectly() {
		int halfSize = cards.size() / 2;
		for (int i = 0; i < halfSize; i++) {
			Card card = cards.remove(halfSize + i);
			cards.add(i * 2 + 1, card);
		}
	}
	

	
	
	public void deal(CardHand hand, int flytteantallkort) {
		if(this.cards.isEmpty()) {
			throw new IllegalArgumentException("Du kan ikke flytte over kort, når kortstokken er tom.");
		}
		else {	
			if(this.validN(flytteantallkort)){
				Integer j = flytteantallkort;
				for(int i = cards.size(); i>-1 && j>0; i--) {
					Card sistekort = cards.get(cards.size() - 1);
					hand.addCard(sistekort);
					cards.remove(sistekort);
					j = j-1;
					}
				}
			}		
	}

	






}
