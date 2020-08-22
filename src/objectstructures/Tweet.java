package objectstructures;

public class Tweet {
	private TwitterAccount konto;
	private String text;
	private Tweet OrginalTweet;
	private int retweetcount=0;
	
	
	//
	public Tweet(TwitterAccount konto, String text) {
		this.konto = konto;
		this.OrginalTweet = null; // betyr at tweeten kommer fra denne kontoen
		this.text = text;
	}
	
	public Tweet(TwitterAccount konto, Tweet retweet) {
		if(retweet.getOwner() == konto) {
			throw new IllegalArgumentException("Du kan ikke retweete din egen tweet");
		}
		else {
			this.konto = konto;
			this.text = retweet.getText();
			this.OrginalTweet = retweet;
			retweet.addretweetcount();
		}
	}
	
	public void addretweetcount() {
		this.retweetcount++;
	}
	
	public String getText() {
		return this.text;
		
	}
	
	public TwitterAccount getOwner() {
		return this.konto;
	}
	
	public Tweet getOriginalTweet() {
		return this.OrginalTweet;
	}
	
	public int getRetweetCount() {
		return this.retweetcount;
	}
}
