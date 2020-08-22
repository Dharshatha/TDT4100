package inheritance;

public class CardHand extends CardContainerImpl{

	

	public CardHand(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}

	public Integer play(int n) {
		Integer tall = n;
		if(super.getCard(n) != null && super.validN(n)) {
			cards.remove(n);
			return tall;
		}
		else {
			throw new IllegalArgumentException("Du kan ikke fjerne et kort som ikke finnes i hånda");
		}
	}

	public void addCard(Card sistekort) {
		super.AddCard(sistekort);
	}
	
}

