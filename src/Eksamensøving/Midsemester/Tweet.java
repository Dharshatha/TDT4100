package Midsemester;


public class Tweet {
	private TwitterAccount account; //Den som eier tweeten
	private String text; // Tweeten i tekstform
	private int retweetcount = 0; // antallganger tweeten har blitt retweeta
	private Tweet orginalTweet; 
	
	//lage en ny tweet
	//En tweet h�rer til den kontoen den ble sendt fra.
	// Merk at i en kjede av retweets, s� vil alle referere til samme original-tweet
	public Tweet(TwitterAccount Konto, String nytweet) {
		this.account = Konto;
		this.text = nytweet;
		this.orginalTweet = null; // st�r i oppgavetekst
		
	}
	
	//sette inn en mulig retweet, sjekker f�rst om retweeten tilh�rer min konto
	public Tweet(TwitterAccount Konto, Tweet retweet) {
		if(Konto == retweet.getOwner()) {
			throw new IllegalArgumentException("Du kan ikke retweete din egen tweet.");
		}
		else {
			this.account = Konto;
			this.text = retweet.getText();
			this.orginalTweet = retweet; //n�r du retweeter s� kopierer du bare en annen sin tekst
			retweet.addRetweetCount(); // plusser p� retweet count for objektet. 
					
		}	
	}
	
	public String getText() {
		return this.text;
	}
	
	public TwitterAccount getOwner() {
		return this.account;
	}
	
	public Tweet getOriginalTweet() {
		return this.orginalTweet;		
	}
	
	public int getRetweetCount() {
		return this.retweetcount;	
	}
	
	public void addRetweetCount() {
		this.retweetcount++;
	}
	
	
	
	
}
