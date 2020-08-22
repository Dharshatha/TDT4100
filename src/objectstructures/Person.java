package objectstructures;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private String navn;
	private char gender;
	private Person mother;
	private Person father;
	private List<Person> Children = new ArrayList<Person>();
	
	
	public Person(String name, char gender) {
		if((this.validName(name)) && (this.validChar(gender))) {
			this.navn = name;	
			this.gender = gender;
			this.mother = null;
			this.father = null;
		}
		else {
			throw new IllegalArgumentException("Du har satt inn noe feil");
		}
	}
	
	public boolean validChar(char hei) {
		if (hei== 'F' || hei=='M') {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean validName(String navn) {
		return navn.matches("[a-zA-Z]+");
	}
	
	public String getName() {
		return this.navn;
	}

	public Character getGender() {
		return this.gender;
	}
	
	public Person getMother() {
		return this.mother;
	}
	
	public Person getFather() {
		return this.father;
	}
	
	public int getChildCount() {
		return this.Children.size();
	}
	
	public boolean validinteger(int n) {
		if(n<0 && n> this.Children.size()-1) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public Person getChild(int n) {
		if(this.validinteger(n)) {
			Person barn = this.Children.get(n);
			System.out.println(barn.getName());
			return barn;
		}
		else {
			throw new IllegalArgumentException("Indeksen du oppgit er utenfor listen");
		}
	}
	
	public boolean notduplicatechild(Person barn) {
		if(this.Children.contains(barn)) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void addChild(Person barn){
		char mittkjonn = this.gender;
		if(mittkjonn == 'M') {
			if(this.notduplicatechild(barn) && barn != null){
				if(barn.getFather() != null) {
					this.Children.add(barn);
					Person exfar = barn.getFather(); // burde egt gjøre i metoden under
					exfar.Children.remove(barn); // burde eg gjøre i metoden under
					barn.setpappa(this);
					}
				else {
					this.Children.add(barn);
					barn.setpappa(this);					
				}
			}
		}
		if(mittkjonn == 'F') {
			if(this.notduplicatechild(barn) && barn != null){
				if(barn.getMother() != null) {
					this.Children.add(barn);
					Person exmor = barn.getMother();
					exmor.Children.remove(barn);
					barn.setmamma(this);
				}
				else {
					this.Children.add(barn);
					barn.setmamma(this);	
				}
			}
		}
		
	}
	
	private void setpappa(Person pappa) {
		this.father = pappa;
	}
	
	private void setmamma(Person mamma) {
		this.mother= mamma;
	}
	
	
	public void removeChild(Person barn) {
		if((this.Children.contains(barn))){
			this.Children.remove(barn);
			if(this.getGender() == 'M') {
				barn.setFather(null);				
			}
			else {
				barn.setMother(null);
			}
		}
		else {
			throw new IllegalArgumentException("Du kan ikke fjerne en person som barn, når du ikke har han som barn.");
		}
	}
	
	public void setMother(Person mamma) {
		if(mamma.getGender() == 'F' && mamma != this) {
			if(this.getMother() != null && this.getMother() == this) {
				return;
			}
			if(this.getMother() != null && this.getMother() != this) {
				Person exmamma = this.getMother();
				exmamma.Children.remove(this);
				this.mother = mamma;
				mamma.Children.add(this);
			}
			if(this.getMother() == null) {
				this.mother = mamma;
				mamma.Children.add(this);
			}
		}
		else {
			throw new IllegalArgumentException("Du har satt inn feil charachter.");
		}
	}
	
	public void setFather(Person pappa) {
		if(pappa.getGender() == 'M' && pappa != this) {
			if(this.getFather() != null && this.getFather() == this) {
				return;
			}
			if(this.getFather() != null && this.getFather() != this) {
				Person expappa = this.getFather();
				expappa.Children.remove(this);
				this.father = pappa;
				pappa.Children.add(this);
			}
			if(this.getFather() == null) {
				this.father = pappa;
				pappa.Children.add(this);
			}
		}
		else {
			throw new IllegalArgumentException("Du har satt inn feil charachter.");
		}
	}	
	
// denne er egt litt dårlig innkapsla så ta deg til til å gjøre den omigjen
}


