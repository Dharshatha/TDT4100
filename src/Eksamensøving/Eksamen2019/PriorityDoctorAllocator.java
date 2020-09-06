package Eksamen2019;

public class PriorityDoctorAllocator extends DefaultDoctorAllocator{
    protected double getPriority(final Patient patient) {
        
        return 0.0;
    }
 
    @Override
    // sier bare hvilke pasienter vi skal hente ut etter prioritet.
    public Patient allocatePatient(final Doctor doctor, final TreatmentUnit2 treatmentUnit) {
        Patient patient = null;
        for (final Patient patient2 : treatmentUnit.getWaitingPatients()) {
            if (doctor.canTreat(patient2) > 0.0 && (patient == null || getPriority(patient2) > getPriority(patient))) {
 
                patient = patient2;
            }
        }
        return patient;
    }
}
