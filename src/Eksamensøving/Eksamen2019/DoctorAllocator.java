package Eksamen2019;

public interface DoctorAllocator {
	public Patient allocatePatient(Doctor doctor, TreatmentUnit2 treatmentUnit);
	public Doctor allocateDoctor(Patient patient, TreatmentUnit2 treatmentUnit);

}
