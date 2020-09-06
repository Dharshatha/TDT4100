package Eksamen2016;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Person implements Iterable<Person>{
	private final String name;
	private Gender gender;
	private Person mother;
	private Person father;
	private Collection<Person> Children = new ArrayList<Person>();

	  public Person(String name) {
		  this.name = name;
	  }
	  
	  public void setGender(Gender gender) {
		  this.gender = gender;
	  }
	  
	  public Gender getGender() {
		  return this.gender;
	  }
	  
	  public String getName() {
		  return this.getName();
	  }
	  
	  public Person getMother() {
		  return this.mother;
	  }
	  
	  public Person getFather() {
		  return this.father;
	  }
	  
	 
	  
	 
	   /**
	    * @return the number of children of this Person
	    */
	   public int getChildCount() {
		   return Children.size();
	   }
	 
	   /**
	    * @param child
	    * @return if this Person has the provided Person as a child
	    */
	   public boolean hasChild(Person child) {
		   return Children.contains(child);
	   }
	 
	   /**
	    * Returns all children of this Person with the provided Gender.
	    * If gender is null, all children are returned.
	    * Can be used to get all daughters or sons of a person.
	    * @param gender
	    */
	   public Collection<Person> getChildren(Gender gender) {
		   Collection<Person> genderchildren = new ArrayList<Person>();
		   for(Person c : this.Children) {
			   if(gender.equals(c.getGender())) {
				   genderchildren.add(c);
			   }
			   
		   }
		   if(genderchildren.isEmpty()) {
			   return this.Children;
		   }
		   else {
			   return genderchildren;
		   }
		   
	      
	   }
	 
	   /**
	    * Adds the provided Person as a child of this Person.
	    * Also sets the child's father or mother to this Person,
	    * depending on this Person's gender.
	    * To ensure consistency, if the provided Person already
	    * has a parent of that gender,
	    * it is removed as a child of that parent.
	    * @param child
	    */
	   public void addChild(Person child) {
		   if(!this.Children.contains(child)) {
			   if(this.gender == Gender.FEMALE) {
				   Person exMother = child.getMother();
				   child.mother  = this;
				   if(exMother != null && exMother.hasChild(child)) {
					   exMother.Children.remove(child);
				   }
				   if(!this.hasChild(child)) {
					   this.addChild(child);
				   }
			   }
			   else if(this.gender == Gender.MALE) {
				   Person exFather = child.getFather();
				   child.father = this;
				   if(exFather != null && exFather.hasChild(child)) {
					   exFather.Children.remove(child);
				   }
				   if(!this.hasChild(child)) {
					   this.addChild(child);
				   }
			   }
		   }
	   }

	@Override
	public Iterator<Person> iterator() {
		return this.Children.iterator();
	}
	

}
