package Eksamen2019;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class TreatmentUnit2 {
	protected  List<Doctor> Doctors = new ArrayList<Doctor>();
	protected List<Patient> Patients = new ArrayList<Patient>();
	protected int priority = 0;
	
	public TreatmentUnit2() {
		
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
    private DoctorAllocator doctorAllocator = new DefaultDoctorAllocator();
    
    public void setDoctorAllocator(final DoctorAllocator doctorAllocator) {
        this.doctorAllocator = doctorAllocator;
    }
 
    protected boolean startTreatment(final Doctor doctor) {
        final Patient patient = doctorAllocator.allocatePatient(doctor, this);
        if (patient != null) {
            doctor.setPatient(patient);
            return true;
        }
        return false;
    }
 
    protected boolean startTreatment(final Patient patient) {
        final Doctor doctor = doctorAllocator.allocateDoctor(patient, this);
        if (patient != null) {
            final Patient oldPatient = doctor.getPatient();
            doctor.setPatient(patient);
            if (oldPatient != null) {
                startTreatment(oldPatient);
            }
            return true;
        }
        return false;
    }
 
    public void treatmentFinished(final Doctor doctor) {
        if (doctor.getPatient() == null) {
            throw new IllegalStateException(doctor + " has no patient!");
        }
        final Patient patient = doctor.getPatient();
        doctor.setPatient(null);
        if (patient.requiresTreatment()) {
            startTreatment(patient);
        } else {
            Patients.remove(patient);
        }
        startTreatment(doctor);
    }
    


}
