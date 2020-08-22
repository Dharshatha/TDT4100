package objectstructures;

public class Card {

	private char kortfarge;
	private int tallverdi;
	
	
	public Card(char kortfarge, int tallverdi) {
		this.setSuit(kortfarge);
		this.setFace(tallverdi);
	}
	
	public char getSuit() {
		return this.kortfarge;
	}
	
	public int getFace() {
		return this.tallverdi;
	}
	
	public boolean validSuit(char kortfarge) {
		if(kortfarge =='S' || kortfarge =='H' || kortfarge == 'D' || kortfarge == 'C') {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void setSuit(char kortfarge) {
		if(!(validSuit(kortfarge))) {
			throw new IllegalArgumentException("You have to set valid Suit.");
		}
		else {
			this.kortfarge = kortfarge;
		}
	}
	
	public boolean validFace(int tallverdi) {
		if ((1 <= tallverdi) && (tallverdi <= 13)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void setFace(int tallverdi) {
		if(!(validFace(tallverdi))) {
			throw new IllegalArgumentException("Interger can only be within 1-13.");
		}
		else {
			this.tallverdi = tallverdi;
		}
	}
	
	public String toString() {
		char kortfarge = this.getSuit();
		int tall = this.getFace();
		String kf = Character.toString(kortfarge);
		String tl = Integer.toString(tall);
		return kf + tl;
	}
	

}
