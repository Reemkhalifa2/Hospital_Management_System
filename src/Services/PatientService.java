package Services;

import Entities.Patient;
import Utilities.Constants;

import java.io.Console;
import java.util.List;

public class PatientService {
    private List<Patient> patients;
    public void addPatient(Patient patient) {
        patients.add(patient);
        System.out.println(Constants.PATIENT_ADDED_SUCCESSFULLY);
    }

    public void displayAllPatients(){
        for(Patient p : patients){
            p.displayInfo();
        }
    }




}
