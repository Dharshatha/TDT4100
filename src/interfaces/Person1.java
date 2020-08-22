package interfaces;



public class Person1 implements Named {
	private String givenname;
	private String familyname;
	
	public Person1(String Givenname, String Familyname) {
		this.setGivenName(Givenname);
		this.setFamilyName(Familyname);
	}

	@Override
	public void setGivenName(String navn){
			this.givenname = navn;
	}

	@Override
	public String getGivenName() {
		return this.givenname;
	}

	@Override
	public void setFamilyName(String navn){
			this.familyname = navn;
	}

	@Override
	public String getFamilyName() {
		return this.familyname;
	}
	
	public void setFullName(String navn) {
		int pos = navn.indexOf(" ");
		this.givenname = navn.substring(0, pos);
		this.familyname = navn.substring(pos +1);
	}

	@Override
	public String getFullName() {
		String fullname = this.getGivenName() + " " + this.getFamilyName();
		return fullname;
	}
	
	
	public static void main(String[] args) {
		Person1 Dharshini = new Person1("Dharshini","Tharmarajan");
		System.out.println(Dharshini.getFamilyName());
		System.out.println(Dharshini.getGivenName());
		System.out.println(Dharshini.getFullName());
	}

}
