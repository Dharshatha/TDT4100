package interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// Bruker interfacet som implementeres av de to andre som "Objekt" som i dette tilfellet er Named. 
public class NamedComparator implements Comparator<Named>{
	List<Character> Alfabetet = new ArrayList<Character>();
	
	public NamedComparator() {
		this.Alfabetet.addAll(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
	}
	

	@Override
	public int compare(Named named1, Named named2) {
		Character for1 = named1.getGivenName().toLowerCase().charAt(0);
		Character for2 = named2.getGivenName().toLowerCase().charAt(0);
		Character etter1 = named1.getFamilyName().toLowerCase().charAt(0);
		Character etter2 = named2.getFamilyName().toLowerCase().charAt(0);
		int f1 = this.Alfabetet.indexOf(for1);
		int f2 = this.Alfabetet.indexOf(for2);
		int e1 = this.Alfabetet.indexOf(etter1);
		int e2 = this.Alfabetet.indexOf(etter2);
		int diff = e1-e2;
		if (diff == 0) {
			diff = f1 - f2;		
		}
		return diff;
	}
	
	/* ELLER BARE (fordi string har innebygd metode for å sammenligne alfabetisk): 
	 * 	public int compare(Named named1, Named named2) {
		int diff = named1.getFamilyName().compareTo(named2.getFamilyName());
		if (diff == 0) {
			diff = named1.getGivenName().compareTo(named2.getGivenName());
		}
		return diff;
	}

	 */

}
