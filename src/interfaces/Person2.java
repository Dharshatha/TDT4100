package interfaces;

public class Person2 implements Named{
	private String fullname;
	
	public Person2(String Fullname) {
		this.setFullName(Fullname);
	}

	@Override
	public void setGivenName(String navn){
		String etternavn = this.getFamilyName();
		String fullname = navn + " " + etternavn;
		this.setFullName(fullname);
	}

	@Override
	public String getGivenName() {
		String navn = this.getFullName();
		String [] dele = navn.split("\\s");
		String givenname = dele[0];
		return givenname;
	}

	@Override
	public void setFamilyName(String navn){
		String fornavn = this.getGivenName();
		String fullname = fornavn + " " + navn;
		this.setFullName(fullname);
		
		
		

	}

	@Override
	public String getFamilyName() {
		String navn = this.getFullName();
		String [] dele = navn.split("\\s");
		String familyname = dele[1];
		return familyname;
	}
	
	public void setFullName(String navn) {
		this.fullname = navn;
	}

	@Override
	public String getFullName() {
		return this.fullname;
	}
	
	public static void main(String[] args) {
		Person1 Dharshini = new Person1("Dharshini","Tharmarajan");
		System.out.println(Dharshini.getFamilyName());
		System.out.println(Dharshini.getGivenName());
		System.out.println(Dharshini.getFullName());
	}

}