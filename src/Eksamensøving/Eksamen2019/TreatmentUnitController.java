package Eksamen2019;

import java.util.ArrayList;
import java.util.Collection;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TreatmentUnitController implements TreatmentUnitListener {
    TreatmentUnit treatmentUnit;
    
    public TreatmentUnitController() {
                treatmentUnit = new  TreatmentUnit();
                treatmentUnit.addListener(this);
    }

    @FXML
    private Label patientMessage;
    
	@Override
	public void PatientGoesToDoctor(Patient p, Doctor d, TreatmentUnit t) {
		patientMessage.setText(Patient.getName() + " bes gå til doktor " + Doctor.getName());
	}

}
