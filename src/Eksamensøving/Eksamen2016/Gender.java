package Eksamen2016;

public class Gender {
	   private final String label;
	   
	   private Gender(String label) {
	      this.label = label;
	   }
	 
	   @Override
	   public String toString() {
	      return label;
	   }
	 
	   public static Gender
	      MALE = new Gender("male"),
	      FEMALE = new Gender("female");
	 
	   /**
	    * Returns a pre-existing Gender instance for the provided label, or
	    * null of there is no such instance.
	    * @param label
	    * @return a pre-existing Gender instance
	    */
	   public static Gender valueOf(String label) {
		   Gender gender = null;
		   if(label.equals(MALE.label)) {
			   gender = MALE;
		   }
		   else if(label.equals(FEMALE.label)) {
			   gender = FEMALE;
		   }
		   return gender;  
	   }

}
