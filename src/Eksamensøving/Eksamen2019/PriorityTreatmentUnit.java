package Eksamen2019;

import java.util.ArrayList;
import java.util.List;

public class PriorityTreatmentUnit extends TreatmentUnit{

	private Patient HighestPriority(List<Patient> waitingpatient){
		int priority = 0;
		Patient o = null;
		for(Patient p: waitingpatient) {
			if(p.getPriority() > priority) {
				priority = p.getPriority();
				o = p;
			}
		}
		return o;
	}
	
	protected boolean startTreatment(final Doctor doctor) {
    	List<Patient> waitingpatient = new ArrayList<Patient>(super.getWaitingPatients());
    	List<Patient> nyliste = new ArrayList<Patient>();
    	for(Patient p: waitingpatient) {
    		if(doctor.canTreat(p) > 0.00) {
    			nyliste.add(p);
    		}
    	}
    	if(!nyliste.isEmpty()) {
        	Patient highestPriority = this.HighestPriority(nyliste);
    		doctor.setPatient(highestPriority);
    		highestPriority.setdoctor(doctor);
    		doctor.treat();
    		return true;
    	}
    	else {
    		return false;
    	}
    	
    }

}