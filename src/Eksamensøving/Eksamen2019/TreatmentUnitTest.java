package Eksamen2019;

import org.junit.Before;
import org.junit.Test;

public class TreatmentUnitTest extends junit.framework.TestCase {
    private TreatmentUnit treatmentUnit;

    @Before
    public void setUp() throws Exception {
    	System.out.println("System is setting up!");
    	this.treatmentUnit = new TreatmentUnit();
        // TODO
    }

    @Test
    public void testAddDoctorsPatient() {
        Doctor doctor1 = new Doctor("flu");
        Doctor doctor2 = new Doctor("noseblead");
        treatmentUnit.addDoctor(doctor1);
        treatmentUnit.addDoctor(doctor2);
        assertTrue(doctor1.isAvailable() && doctor2.isAvailable());
        Patient patient = new Patient();
        patient.addConditions("flu", "noseblead");
// 2e) start sequence diagram
        treatmentUnit.addPatient(patient);
        assertTrue(! (doctor1.isAvailable() && doctor2.isAvailable()));
        Doctor patientDoctor = treatmentUnit.getDoctor(patient);
        patientDoctor.treat();
        treatmentUnit.treatmentFinished(patientDoctor);
// 2e) end sequence diagram
        assertTrue(patientDoctor.isAvailable());
        assertNotSame(patientDoctor, treatmentUnit.getDoctor(patient));
        patientDoctor = treatmentUnit.getDoctor(patient);
        patientDoctor.treat();
        treatmentUnit.treatmentFinished(patientDoctor);
        assertTrue(doctor1.isAvailable() && doctor2.isAvailable());

}
}
