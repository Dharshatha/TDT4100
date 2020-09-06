package Eksamen2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Patient {
	private Doctor doctor = null;
	private int priority;
	private List<String> PasientDiagnose = new ArrayList<String>();
	
	
	public Patient(String ...diagnose) {
		this.PasientDiagnose = Arrays.asList(diagnose);
		/*
		 * for(String s: diagnose) {
			this.PasientDiagnose.add(s);
		}
		 */
		
	}
	
	
    // TODO 2a: Add fields, constructors, and methods here

    /**
     * Indicates if this patient has conditions that needs to be treated.
     * 
     * @return true if this patient has conditions that needs to be treated, false
     *         otherwise.
     */
    public boolean requiresTreatment() {
    	if(!PasientDiagnose.isEmpty()) {
    		return true;
    	}
    	else {
        return false;
    	}
    }
    
    public void removeCondition(String ...Condition) {    	
    	for(String s:Condition) {
    		if(this.PasientDiagnose.contains(s)) {
    			this.PasientDiagnose.remove(s);
    		}
    	}
    }
    
    public void addConditions(String ...Condition) {
    	for(String s:Condition) {
    		if(!this.PasientDiagnose.contains(s)) {
        		this.PasientDiagnose.add(s);
        	}
    	}
    }
    
    public List<String> getConditions(){
    	return this.PasientDiagnose;
    }

	
	public Doctor getdoctor() {
		return this.doctor;
	}
	
	public void setdoctor(Doctor doctor) {
		if(this.requiresTreatment()) {
			this.doctor = doctor;
		}
		else {
			System.out.println("Denne pasienten har fått behandling.");
		}
	}
	
	public void removeDocter(Doctor doctor) {
		if(this.doctor != null) {
			this.doctor = null;
		}
	}


	public int getPriority() {
		return priority;
	}


	public void setPriority(int priority) {
		this.priority = priority;
	}
}
