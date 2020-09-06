package Eksamen2019;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TreatmentUnit {
	protected  List<Doctor> Doctors = new ArrayList<Doctor>();
	protected List<Patient> Patients = new ArrayList<Patient>();
	protected int priority = 0;
	private Collection <TreatmentUnitListener> Lyttere = new ArrayList<TreatmentUnitListener>();
	
	public TreatmentUnit() {
		
	}


    public void addDoctor(final Doctor doctor) {
    	if(!this.Doctors.contains(doctor)) {
    		this.Doctors.add(doctor);
        	if((!this.getWaitingPatients().isEmpty()) && doctor.isAvailable()) {
        		this.startTreatment(doctor);
        	}
    	}
    	else {
    		throw new IllegalArgumentException("Denne doktoren finnes allerede i lista.");
    	}
    	
    }
    


    public Collection<Doctor> getAvailableDoctors() {
    	Collection <Doctor> availabledoctors = 
    				this.Doctors.stream()
    				.filter(c -> c.isAvailable())
    				.collect(Collectors.toList());
    	return availabledoctors;
    }


    public void addPatient(final Patient patient) {
    	if(!this.Patients.contains(patient)) {
    		this.Patients.add(patient);
        	if((!this.getAvailableDoctors().isEmpty()) && (patient.requiresTreatment())) {
        		this.startTreatment(patient);
        	}
        	else if(this.getAvailableDoctors().isEmpty()) {
        		int prioritet = this.priority;
        		patient.setPriority(prioritet);
        		this.priority++;
        	}
    	}
    	else {
    		throw new IllegalArgumentException("Denne pasienten finnes allerede i lista.");
    	}
    }
    


    public Doctor getDoctor(final Predicate<Doctor> pred) {
    	Doctor d = null;
    	List<Doctor> match = this.Doctors.stream().filter(pred).collect(Collectors.toList());
    	if(!match.isEmpty()) {
    		d = match.get(0);    		
    	}
    	return d;
    }


    public Doctor getDoctor(final Patient patient) {
        return patient.getdoctor();
    }


    public Collection<Patient> getWaitingPatients() {
    	Collection <Patient> waitingpatient = 
				this.Patients.stream()
				.filter(c -> (c.requiresTreatment()))
				.collect(Collectors.toList());
    	return waitingpatient;
         
    }


    private boolean startTreatment(final Doctor doctor) {
    	List<Patient> waitingpatient = new ArrayList<Patient>(this.getWaitingPatients());
    	for(Patient p: waitingpatient) {
    		if(doctor.canTreat(p) > 0.00) {
    			doctor.setPatient(p);
    			p.setdoctor(doctor);
    			doctor.treat();
    			this.alertothers(p, doctor);
    			return true;
    		}
    	}
    	return false;
    }


    protected boolean startTreatment(final Patient patient) {
    	List<Doctor> availabledoctors = new ArrayList<Doctor>(this.getAvailableDoctors());
    	for(Doctor d: availabledoctors) {
    		if(d.canTreat(patient) > 0.00) {
    			d.setPatient(patient);
    			patient.setdoctor(d);
    			d.treat();
    			this.alertothers(patient, d);
    			return true;
    		}
    	}
    	return false;
    	
    }
    
    /*
     * Dersom man bare skal ha ut neste element fra en liste random uten condition.
private boolean startTreatment(Doctor doctor) { // 1c
               Collection<Patient> waitingPatients = getWaitingPatients();
               if (waitingPatients.isEmpty()) {
                             return false;
               }
    doctor.setPatient(waitingPatients.iterator().next());
               return true;
}
 
private boolean startTreatment(Patient patient) { // 1c
               Collection<Doctor> availableDoctors = getAvailableDoctors();
               if (availableDoctors.isEmpty()) {
                             return false;
               }
               Doctor doctor = availableDoctors.iterator().next();
               doctor.setPatient(patient);
               return true;
}
     */

    public void treatmentFinished(final Doctor doctor) {
    	if(doctor.getPatient() == null) {
    		throw new IllegalStateException("Legen har" + doctor.getPatient() + "pasienter.");
    	}
    	else {
        	Patient p = doctor.getPatient();
        	p.removeDocter(doctor);
        	doctor.removepatient();
        	if(p.requiresTreatment()) {
            	this.startTreatment(doctor);
            	this.startTreatment(p);
        	}
        	else{
        		this.Patients.remove(p);
        		this.startTreatment(doctor);
    	}

    	}
    }
    
    public void addListener(TreatmentUnitListener l) {
    	if(this.Lyttere.contains(l)) {
    		throw new IllegalArgumentException("Lytter finnes allerede.");
    	}
    	else {
    		this.Lyttere.add(l);
    	}
    }
    
    public void removeListener(TreatmentUnitListener l) {
    	if(this.Lyttere.contains(l) && !this.Lyttere.isEmpty()) {
    		this.Lyttere.remove(l);
    	}
    	else {
    		throw new IllegalArgumentException("Lytter finnes ikke.");
    	}
    }

    
    public void alertothers(Patient p, Doctor d) {
    	for(TreatmentUnitListener l: this.Lyttere) {
    		l.PatientGoesToDoctor(p, d, this);
    	}
    }
    

}
