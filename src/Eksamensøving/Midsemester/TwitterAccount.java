package Midsemester;

import java.util.ArrayList;
import java.util.List;



public class TwitterAccount {
	private String username;
	List <TwitterAccount> Follows = new ArrayList<TwitterAccount>();
	List <Tweet> Tweet = new ArrayList <Tweet>();
	
	
	
	public TwitterAccount(String username) {
		this.username = username;
	}
	
	public String getUserName() {
		return this.username;
	}
	
	public void follow(TwitterAccount account) {
		if(!this.Follows.contains(account) && account != null) {
			this.Follows.add(account);	
		}
		else {
			throw new IllegalArgumentException("Du kan ikke følge en konto du allerede følger fra før.");
		}
	}
	
	public void unfollow(TwitterAccount account) {
		if(this.isFollowing(account)) {
			this.Follows.remove(account);
			//System.out.println("Du følger ikke lenger " + account.getUserName() + "." );
		}
	}
	
	public boolean isFollowing(TwitterAccount account) {
		if(this.Follows.contains(account) && account != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isFollowedBy(TwitterAccount account) {
		if(account.Follows.contains(this) && account != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void tweet(String nytweetfordennekonto) {
		Tweet tweet = new Tweet(this, nytweetfordennekonto);
		this.Tweet.add(tweet);
	}
	
	
	
	//vi husker at retweet skulle lagres med orginalteksten.
	public void retweet(Tweet tweet) {
		if (tweet.getOriginalTweet() == null) {
			Tweet.add(new Tweet(this, tweet));
		} else {
			Tweet.add(new Tweet(this, tweet.getOriginalTweet()));
		}
		
		
	}
	
	public boolean validIndex(int n) {
		if (n < 1 && n > this.Tweet.size()) {
			return false;
		}
		else {
			return true;
		}
	}
	
	

	
	
	// får ut tweet nr. fra nyeste twwet.
	public Tweet getTweet(int i) {
		return this.Tweet.get(this.Tweet.size()-i);
	}
	
	
		
		
	// antall tweets	
	public int getTweetCount() {
		return this.Tweet.size();
		
	}
	
	// retunerer antall retweets fra denne kontoen 
	  public int getRetweetCount() {
		    int count = 0;
		    for (Tweet tweet : Tweet) {
		      count += tweet.getRetweetCount();
		    }
		    return count;
		  }
	

}
