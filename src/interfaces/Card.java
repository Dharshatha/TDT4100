package interfaces;

public class Card implements Comparable<Card>{

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

	

	@Override
	public int compareTo(Card o) {
		int hei = 0;
		if (this.getSuit() == o.getSuit()) {
			if(this.getFace() == o.getFace()) {
				hei = 0;
			}
			else if(this.getFace() > o.getFace()) {
				hei = 1;
			}
			else if(this.getFace() < o.getFace()) {
				hei = -1;
			}
		}
		else {
			if((this.getSuit() == 'C') || (this.getSuit() == 'H' && o.getSuit() == 'S') ||(this.getSuit() == 'D' && ((o.getSuit()=='H')|| (o.getSuit() == 'S')))) {
				hei = -1;
			}
			else {
				hei = 1;
			}
		}
		return hei;
	}
	
 public static void main(String[] args) {
	Card a = new Card('S',1);
	Card b = new Card('S',2);
	Card c = new Card('H',1);
	Card d = new Card('D',1);
	Card e = new Card('C',1);
	a.compareTo(b);
	b.compareTo(a);
	a.compareTo(c);
	a.compareTo(d);
	a.compareTo(e);
	e.compareTo(d);
	System.out.println(a.compareTo(b));
	System.out.println(b.compareTo(a));
	System.out.println(a.compareTo(c));
	System.out.println(a.compareTo(d));
	System.out.println(d.compareTo(e));
	System.out.println(e.compareTo(d));
	
}
}
