package Eksamen2016;

import java.util.ArrayList;
import java.util.Collection;

public class Sister implements Relation {

	@Override
	public Collection<Person> getRelativesOf(Person person) {
		Collection<Person> sister = new ArrayList<Person>();
		Collection<Person> sisteramma = person.getMother().getChildren(Gender.FEMALE);
		Collection<Person> sisterappa = person.getFather().getChildren(Gender.FEMALE);
		for(Person p : sisteramma) {
				sister.add(p);
			}
		for(Person p: sisterappa) {
			if(!sister.contains(p)) {
				sister.add(p);
			}	
		}
		sister.remove(person);
		if(sister.isEmpty()) {
			return null;
		}
		else {
			return sister;
		}
	}

}
