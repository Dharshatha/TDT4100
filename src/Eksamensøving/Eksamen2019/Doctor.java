package Eksamen2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Doctor {
	private Patient patient = null;
	private List <String> Competences = new ArrayList<String>();
	private String name;
	
	
    public Doctor(String name, String ... competences){
    	this.name = name;
    	this.Competences = Arrays.asList(competences);
    	
    	/*
    	 * for(String s: competences) {
    		this.Competences.add(s);
    	}
    	 */
    }
    
    public String getName() {
    	return this.name;
    }


    public double canTreat(final Patient patient) {
    	double patientcondition = 0.00;
    	double cantreat=0.00;
    	List<String> Cp = patient.getConditions();
    	for(int i=0; i < Cp.size(); i++) {
    		String cp = Cp.get(i);
    		patientcondition++;
    		if(this.Competences.contains(cp)){
    			cantreat++;
    		}
    	}
    	double calculate = cantreat/patientcondition;    	
        return calculate;
    }


    public void treat() {
    	for(String s: this.Competences) {
    		if(patient.getConditions().contains(s)) {
    			patient.removeCondition(s);
    		}
    	}
    	
    	/*
    	 *     	if(this.patient != null && (this.canTreat(this.patient)!= 0.00)) {
    		List<String> cantreat = this.Competences;
    		for(int i=0; i < cantreat.size(); i++) {
        		String cp = cantreat.get(i);
        		if(this.patient.getConditions().contains(cp)){
        			this.patient.removeCondition(cp);
        		}
        	}
    	}
    	 */

    }

    public Patient getPatient() {
    	return this.patient;
    }


    public boolean isAvailable() {
    	if(this.patient == null) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }


    public void setPatient(final Patient patient) {
    	if(this.patient == null) {
    		this.patient = patient;
    	}
    	else {
    		System.out.println("Kunne ikke legge til pasient.");
    	} 
    }
    
    public void removepatient() {
    	if(this.patient !=null) {
    		this.patient = null;
    	}
    }


}
