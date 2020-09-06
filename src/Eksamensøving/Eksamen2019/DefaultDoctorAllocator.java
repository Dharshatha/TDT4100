package Eksamen2019;

import java.util.ArrayList;
import java.util.List;

public class DefaultDoctorAllocator implements DoctorAllocator{

	@Override
	public Patient allocatePatient(Doctor doctor, TreatmentUnit2 treatmentUnit) {
		Patient o = null;
		List<Patient> waitingpatient = new ArrayList<Patient>(treatmentUnit.getWaitingPatients());
    	for(Patient p: waitingpatient) {
    		if(doctor.canTreat(p) > 0.00) {
    			o = p;
    			return o;
    		}
    	}
    	return o;
	}

	@Override
	public Doctor allocateDoctor(Patient patient, TreatmentUnit2 treatmentUnit) {
    	List<Doctor> availabledoctors = new ArrayList<Doctor>(treatmentUnit.getAvailableDoctors());
    	Doctor o = null;
    	for(Doctor d: availabledoctors) {
    		if(d.canTreat(patient) > 0.00) {
    			o = d;
    			return o;
    		}
    	}
    	return o;
	}

}
