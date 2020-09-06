package Eksamen2016;

import java.util.ArrayList;
import java.util.Collection;

public class Relation2 implements Relation {
	private Relation rel1;
	private Relation rel2;
	 
	   public Relation2(Relation rel1, Relation rel2) {
		   this.rel1 = rel1;
		   this.rel2 = rel2;   
	   }
	 
	   @Override
	   public Collection<Person> getRelativesOf(Person person) {
		   Collection<Person> tante= new ArrayList<Person>();
		   Collection<Person> parents = rel1.getRelativesOf(person);
		   for(Person p: parents) {
			   tante.addAll(rel2.getRelativesOf(p)); 
		   }
		   return tante;
	   }
	   
	  public static void main(String[] args) {
		  // Får opp 3 nivåer med foreldre
		  Relation parent = new Parent();
		  Relation grandParent = new Relation2(parent, parent);
		  Relation grandGrandParent = new Relation2(grandParent, parent);
	}
}