package interfaces.twitter;

import java.util.Comparator;

public class TweetsCountComparator implements Comparator<TwitterAccount> {

	@Override
	public int compare(TwitterAccount o1, TwitterAccount o2) {
		int followers1 = o1.getTweetCount();
		int followers2 = o2.getTweetCount();
		int diff = followers2 - followers1;
		return diff;
	}

}
