package Eksamen2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class EmergencyPriorityTreatmentUnit extends PriorityTreatmentUnit{
	
	protected Collection<Doctor> getBusyDoctors(){
		Collection<Doctor> busydoctor =  super.Doctors
				.stream()
				.filter(c -> !(c.isAvailable()))
				.collect(Collectors.toList());
		return busydoctor;
	
		
	}

	
	
    public boolean startTreatment(final Patient patient) {
    	if(!super.startTreatment(patient)) {
        	List<Doctor> busyleger = new ArrayList<Doctor>(this.getBusyDoctors());
        	Patient p = null;
        	for(Doctor d: busyleger) {
        		if(d.canTreat(patient) > 0.00) {
        			p = d.getPatient();
        			if(p.getPriority() < patient.getPriority()) {
        				d.setPatient(patient);
            			patient.setdoctor(d);
            			d.treat();
            			super.startTreatment(p);
            			return true;
        			}
        		}
        	}
    	}
    	return false;
    }
}
