package Eksamen2016;

import java.util.ArrayList;
import java.util.Collection;

public class Parent implements Relation{

	@Override
	public Collection<Person> getRelativesOf(Person person) {
		Collection<Person> foreldre = new ArrayList<Person>();
		Person mother = person.getMother();
		Person father = person.getFather();
		if(mother != null) {
			foreldre.add(mother);
		}
		if(father != null) {
			foreldre.add(father);
		}
		
		return foreldre;


	}

}
