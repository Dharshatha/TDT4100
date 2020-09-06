package Eksamen2019;

import java.util.ArrayList;
import java.util.List;

public class EmergencyDoctorAllocator extends PriorityDoctorAllocator{
    @Override
    // sier bare hvilken doctor vi skal hente ut og hva som skal skje med 
    public Doctor allocateDoctor(final Patient patient, final TreatmentUnit2 treatmentUnit) {
        final Doctor doctor = super.allocateDoctor(patient, treatmentUnit);
        if (doctor != null) {
            return doctor;
        }
        Patient patientToSuspend = null;
        for (final Doctor doctor2 : treatmentUnit.getAllDoctors()) {
            if (doctor2.canTreat(patient) > 0.0) {
                final Patient existingPatient = doctor2.getPatient();
                if (existingPatient != null && getPriority(existingPatient) < getPriority(patient) &&
                        (patientToSuspend == null || getPriority(existingPatient) < getPriority(patientToSuspend))) {
                    patientToSuspend = existingPatient;
                }
            }
        }
        if (patientToSuspend != null) {
            return treatmentUnit.getDoctor(patientToSuspend);
        }
        return null;
    }

}
