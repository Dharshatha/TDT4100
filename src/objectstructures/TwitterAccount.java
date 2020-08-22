package objectstructures;

import java.util.ArrayList;
import java.util.List;

public class TwitterAccount {
	private String username;
	private List<TwitterAccount> Following = new ArrayList<TwitterAccount>();
	private List<Tweet> Tweets = new ArrayList<Tweet>();
	
	
	public TwitterAccount(String username) {
		this.username = username;	
	}
	
	public void follow(TwitterAccount account) {
		if(!this.isFollowing(account)) {
			this.Following.add(account);
		}
		else {
			System.out.println("Du følger denne kontoen allerede!");
		}
	}
	
	public void unfollow(TwitterAccount account) {
		if(this.isFollowing(account)) {
			this.Following.remove(account);
		}
		else {
			System.out.println("Du følger ingen konto fra før med det du har oppgitt.");
		}
	}
	
	public boolean isFollowing(TwitterAccount account) {
		if(this.Following.contains(account)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public boolean isFollowedBy(TwitterAccount account) {
		if(account.isFollowing(this)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void tweet(String nytweet) {
		Tweet tweet = new Tweet(this, nytweet);
		this.Tweets.add(tweet);
	}

	
	// vi skal legge til som orginal tekst
	public void retweet(Tweet retweet) {
		if(retweet.getOriginalTweet()== null) {
			Tweet tweet = new Tweet(this, retweet);
			this.Tweets.add(tweet);
		}
		else {
			this.Tweets.add(new Tweet(this, retweet.getOriginalTweet()));
		}
	}
	
	// må være fra 1 osv videre
	public boolean validInteger(int i) {
		if((i > this.Tweets.size()) && i < 1) {
			return false;
		}
		else {
			return true;
		}
	}
	public Tweet getTweet(int i) {
		if(this.validInteger(i) && (!this.Tweets.isEmpty())) {
			Tweet tweet = this.Tweets.get(this.Tweets.size()-i);
			return tweet;
		}
		else {
			throw new IllegalArgumentException("Fikk ikke tak i tingen");
		}
	}
	
	public String getUserName() {
		return this.username;
	}
	public int getTweetCount() {
		return this.Tweets.size();	
	}
	
	public int getRetweetCount() {
		int count = 0;
		for(Tweet tweet: this.Tweets) {
			count += tweet.getRetweetCount();
		}
		return count;
	}

}
