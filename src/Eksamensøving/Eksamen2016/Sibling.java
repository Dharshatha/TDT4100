package Eksamen2016;

import java.util.ArrayList;
import java.util.Collection;

public class Sibling implements Relation{
	private Gender gender;
	
	public Sibling(Gender gender) {
		this.gender = gender;
	}

	@Override
	public Collection<Person> getRelativesOf(Person person) {
		Collection<Person> sibling = new ArrayList<Person>();
		Collection<Person> siblingamma = person.getMother().getChildren(gender);
		Collection<Person> siblingappa = person.getFather().getChildren(gender);
		for(Person p : siblingamma) {
				sibling.add(p);
			}
		for(Person p: siblingappa) {
			if(!sibling.contains(p)) {
				sibling.add(p);
			}	
		}
		sibling.remove(person);
		if(sibling.isEmpty()) {
			return null;
		}
		else {
			return sibling;
		}
	}
	
	

}
