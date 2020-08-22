package patterns.delegation.office;

import java.util.ArrayList;
import java.util.List;

public class Printer {
	List<String> Logg = new ArrayList<String>();
	
	public Printer() {
		
	}
	
	public void printDocument(String document, Employee employee) {
		this.Logg.add(document);
	}
	
	public List<String> getPrintHistory (Employee employee){
		return this.Logg;
		
	}

}
