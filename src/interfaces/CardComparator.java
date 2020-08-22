package interfaces;

import java.util.Comparator;

public class CardComparator implements Comparator<Card>{
	private boolean esshighest;
	private char trumph;
	private String rekkefølge = "CDHS";
	
	
	public CardComparator(boolean sant, char trumph) {
		this.esshighest = sant;
		this.trumph = trumph;
	}
	
		
	@Override
	public int compare(Card o1, Card o2) {
		// Finner hvilket "tall" de egt har i orginal rekkefølgen. 
		int suit1 = rekkefølge.indexOf(o1.getSuit());
		int suit2 = rekkefølge.indexOf(o2.getSuit());
		if(o1.getSuit() == this.trumph) {
			suit1 = rekkefølge.length();
		}
		if(o1.getSuit() == this.trumph) {
			suit2= rekkefølge.length();
		}
		int diff = suit1-suit2;
		if (diff ==0) {
			int face1 = o1.getFace();
			int face2 = o2.getFace();
			if (esshighest) {
				if(face1 == 1) {
					face1 =14;
				}
				if(face2 == 1) {
					face2 =14;
				}
				diff = face1-face2;
			}
		}
		return diff;
	}

	
	
	 public static void main(String[] args) {
			Card a = new Card('S',1);
			Card b = new Card('S',13);
			Card c = new Card('H',13);
			Card d = new Card('D',1);
			Card e = new Card('C',13);
			CardComparator halla = new CardComparator(false, ' ');
			System.out.println(halla.compare(a, b));
			System.out.println(halla.compare(b, c));
			System.out.println(halla.compare(d, c));
			System.out.println(halla.compare(b, a));
			System.out.println(halla.compare(e, a));
			System.out.println(halla.compare(a, b));
			
		}
}
