package interfaces.twitter;

import java.util.Comparator;

public class FollowersCountComparator implements Comparator<TwitterAccount>{
	
	public FollowersCountComparator() {
	}
	
	//negatvit tall dersom o1 kommer før o2 i sortert rekkefølge. 
	// postitivt tall dersom o1 kommer etter o2 i sortert rekkefølge.
	// 0 om det er like svar

	@Override
	public int compare(TwitterAccount o1, TwitterAccount o2) {
		int followers1 = o1.getFollowerCount();
		int followers2 = o2.getFollowerCount();
		int diff = followers2 - followers1;
		return diff;
	}

}
