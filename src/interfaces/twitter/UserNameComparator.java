package interfaces.twitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class UserNameComparator implements Comparator<TwitterAccount> {
	List<Character> Alfabetet = new ArrayList<Character>();
		
	public UserNameComparator() {
		this.Alfabetet.addAll(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
		
	}

	//negatvit tall dersom o1 kommer før o2 i sortert rekkefølge. 
	// postitivt tall dersom o1 kommer etter o2 i sortert rekkefølge.
	// 0 om det er like svar
	@Override
	public int compare(TwitterAccount o1, TwitterAccount o2) {
		String Username1 = o1.getUserName().toLowerCase();
		String Username2 = o2.getUserName().toLowerCase();
		Character u1 = Username1.charAt(0);
		Character u2 = Username2.charAt(0);
		int tall1 = this.Alfabetet.indexOf(u1);
		int tall2 = this.Alfabetet.indexOf(u2);
		int diff = tall1- tall2;		
		return diff;
	}
	
	/*
	 * Fordi String har en innebygd som sammenligner alfabetisk.
	public int compare(TwitterAccount a1, TwitterAccount a2) {
		return a1.getUserName().compareTo(a2.getUserName());
		}

	 */

}
