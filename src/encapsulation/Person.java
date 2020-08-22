package encapsulation;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Person {
	private String name;
	private String fname;
	private String lname;
	private String email;
	private Date faar;
	private char gender;
	private final String [] koder = {"ad", "ae", "af", "ag", "ai", "al", "am", "ao", "aq", "ar", "as", "at", "au", "aw", "ax", "az", "ba", "bb", "bd", "be", "bf", "bg", "bh", "bi", "bj", "bl", "bm", "bn", "bo", "bq", "br", "bs", "bt", "bv", "bw", "by", "bz", "ca", "cc", "cd", "cf", "cg", "ch", "ci", "ck", "cl", "cm", "cn", "co", "cr", "cu", "cv", "cw", "cx", "cy", "cz", "de", "dj", "dk", "dm", "do", "dz", "ec", "ee", "eg", "eh", "er", "es", "et", "fi", "fj", "fk", "fm", "fo", "fr", "ga", "gb", "gd", "ge", "gf", "gg", "gh", "gi", "gl", "gm", "gn", "gp", "gq", "gr", "gs", "gt", "gu", "gw", "gy", "hk", "hm", "hn", "hr", "ht", "hu", "id", "ie", "il", "im", "in", "io", "iq", "ir", "is", "it", "je", "jm", "jo", "jp", "ke", "kg", "kh", "ki", "km", "kn", "kp", "kr", "kw", "ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls", "lt", "lu", "lv", "ly", "ma", "mc", "md", "me", "mf", "mg", "mh", "mk", "ml", "mm", "mn", "mo", "mp", "mq", "mr", "ms", "mt", "mu", "mv", "mw", "mx", "my", "mz", "na", "nc", "ne", "nf", "ng", "ni", "nl", "no", "np", "nr", "nu", "nz", "om", "pa", "pe", "pf", "pg", "ph", "pk", "pl", "pm", "pn", "pr", "ps", "pt", "pw", "py", "qa", "re", "ro", "rs", "ru", "rw", "sa", "sb", "sc", "sd", "se", "sg", "sh", "si", "sj", "sk", "sl", "sm", "sn", "so", "sr", "ss", "st", "sv", "sx", "sy", "sz", "tc", "td", "tf", "tg", "th", "tj", "tk", "tl", "tm", "tn", "to", "tr", "tt", "tv", "tw", "tz", "ua", "ug", "um", "us", "uy", "uz", "va", "vc", "ve", "vg", "vi", "vn", "vu", "wf", "ws", "ye", "yt", "za", "zm", "zw"};
	
	
	
	public Person(String name, String email, Date faar, String gender){
		setName(name);
		setEmail(email);
		
	}
	
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	
	
//	public void setEmail(String email) {
//		String [] dele = email.split(".");
//		String fnavn = dele[0];
//		String enavndomene = dele[1];
//		String landskode = dele[2];
//		String [] dele2 = enavndomene.split("@");
//		String enavn = dele2[0];
//		String domene = dele2[1]; 
//		List<String> list = Arrays.asList(koder);
//		
//		if (!((this.getfName().compareToIgnoreCase(fnavn)) == 0)) {
//			throw new IllegalArgumentException("Fornavnet til eposten stemmer ikke med fornavnet til navnet");			
//		}
//		
//		else if(!((this.getlName().compareToIgnoreCase(enavn)) == 0)) {
//			throw new IllegalArgumentException("Etternavnet til eposten stemmer ikke med etternavnet til navnet");	
//						
//		}
//		
//		else if (!list.contains(landskode)) {
//			throw new IllegalArgumentException("Landskode eksisterer ikke");		
//		}
//		
//		else {
//			this.email = email;
//			
//		}
//		
//	}
	
	public void setEmail(String email){
		if ((!validateEmailName(email) || !validateDomain(email)) && email != null) {
			throw new IllegalArgumentException("Invalid email");
		}
		this.email = email;
	}
	
	private boolean validateEmailName(String email) {
		String[] fullName = email.split("@|\\.");
		String fname = fullName[0];
		String lname = fullName[1];
		if(((this.getfName().compareToIgnoreCase(fname)) == 0) && (this.getlName().compareToIgnoreCase(lname) == 0)) {
			return true;
		}
		else {
			return false;		
			
		}
	}
	private boolean validateDomain(String email) {
		if (!email.contains("@")) {
			return false;
		}
		String[] domain = email.split("\\.");
		if (domain.length != 3) {
			return false;
		}
		for (String dom : koder) {
			if (domain[2].equalsIgnoreCase(dom)) {
				return true;
			}
		}
		return false;
	}
	
	
		
	


	public boolean isEmpty(String s) {
		if (s == null) {
	         return true;
	      }
		else { 
			return false;
		}
		
	}
	
	public boolean AlfaLengde(String s) {
		if (s.matches("[a-zA-Z]+") == true && s.length() >= 2) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void setfornavn(String fnavn) {
		if (!AlfaLengde(fnavn)) {
			throw new IllegalArgumentException("Pass på at fornavnet har kun letters, og har minst 2 av de");
		}
		else if(AlfaLengde(fnavn)) {
			this.fname = fnavn;
		}
	}
	
	public void setetternavn(String enavn) {
		if(!AlfaLengde(enavn)) {
			throw new IllegalArgumentException("Pass på at etternavnet har kun letters, og har minst 2 av de");
		}
		
		else if(AlfaLengde(enavn)) {
			this.lname = enavn;
		}
		
	}
	
	
	public void setName(String navn){
		String [] delt = navn.split("\\s");
		String fornavn = delt[0];
		String etternavn = delt[1];	
		if (isEmpty(navn)){
			throw new IllegalArgumentException("Du kan ikke ha tom navn");
		}
		if(!(delt.length == 2)) {
			throw new IllegalArgumentException("FEIL");
		}
		else {				
			setfornavn(fornavn);
			setetternavn(etternavn);
			this.name = this.fname + " " + this.lname;
		}
	}
	
	public void setGender(char gender) {
		if ((gender == 'M' || gender == 'F' || gender == '\0')) {
			this.gender = gender;
		}
		else {
			throw new IllegalArgumentException("Du har skrevet inn noe feil, i kjønn feltet.");
				}
	}
	
	public void setBirthday(Date dato) {
		Date currentdate = new Date();
		if(dato.after(currentdate)) {
			throw new IllegalArgumentException("Du har satt inn dato som er i fremtid");	
		}
		else {
		this.faar = dato;
		}
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getfName() {
		return this.fname;
	}
	
	public String getlName() {
		return this.lname;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public Date getBirthday() {
		return this.faar;
	}
	
	public char getGender() {
		return this.gender;
	}
	public static void main(String[]args) {
		Person hei = new Person();
		hei.setName("Ola Nordmann");
		System.out.println(hei.getfName());
		System.out.println(hei.getlName());
		System.out.println(hei.getName());
		hei.setEmail("Ola.Nordmann@ntnu.no");
		System.out.println(hei.getEmail());
	}
	
	
}
