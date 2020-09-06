package Eksamen2016;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Family {
	private Collection<Person> familymembers = new ArrayList<Person>();

	   /**
	    * Adds a Person as a new family member
	    * @param person the Person to add
	    */
	   public void addMember(Person person) {
		   if(!this.familymembers.contains(person)) {
			   familymembers.add(person);
		   }
		   else {
			   throw new IllegalArgumentException("Du kan ikke legge til et familiemedlem flere ganger");
		   }
	   }
	 
	   /**
	    * Finds a member with the given name
	    * @param name
	    * @return the Person in this Family with the provided name
	    */
	 
	   public Person findMember(String name) {
		   for(Person q : this.familymembers) {
			   if(q.getName().equals(name)) {
				   return q;
			   }
		   }
		   return null;
	   }
	 
	   //
	 
	   /**
	    * Writes the contents of this Family to the OutputStream,
	    * so it can be reconstructed using load.
	    * @param out
	    */
	   private void outputQuotedName(Person person, PrintWriter pw) {
		   pw.print("\"" + person.getName() + "\"");      
		}
		 
		public void save(OutputStream out) throws IOException {
		   PrintWriter pw = new PrintWriter(out);
		   pw.println("# all persons");
		   for (Person person : this.familymembers) {
		      pw.print(person.getGender());
		      pw.print(" ");
		      outputQuotedName(person, pw);
		      pw.println();
		   }
		   pw.println();
		   pw.println("# all mother/father-child relations");
		   for (Person person : this.familymembers) {
		      if (person.iterator().hasNext()) {
		         outputQuotedName(person, pw);
		         for (Person child : person) {
		            pw.print(" ");
		            outputQuotedName(child, pw);
		         }
		         pw.println();
		      }
		   }
		   pw.flush();
		}
		 
		public void load(InputStream in) throws IOException {
		   Scanner scanner = new Scanner(in);
		   while (scanner.hasNextLine()) {
		      String line = scanner.nextLine();
		      if (line.trim().length() == 0 || line.startsWith("#")) {
		         continue;
		      }
		      List<String> tokens = tokenize(line);
		      Gender gender = Gender.valueOf(tokens.get(0));
		      if (gender != null) {
		         // type 1 line
		         Person person = new Person(tokens.get(1));
		         person.setGender(gender);
		         addMember(person);
		      } else {
		         // type 2 line
		         Person person = findMember(tokens.get(0));
		         for (int i = 1; i < tokens.size(); i++) {
		            Person child = findMember(tokens.get(i));
		            person.addChild(child);
		         }
		      }
		   }
		   scanner.close();
		}
	}
	 
