package Entities;

import Utilities.Constants;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Nurse extends Person{

    private String nurseId;
    private String departmentId;
    private String shift;
    private String qualification;
    private List<Patient> assignedPatients;
    public Nurse(String id, String firstName, String lastName,
                 LocalDate dateOfBirth, String gender,
                 String phoneNumber, String email, String address,
                 String nurseId, String departmentId,
                 String shift, String qualification) {

        super(
        );

        this.nurseId = nurseId;
        this.departmentId = departmentId;
        this.shift = shift;
        this.qualification = qualification;

        this.assignedPatients = new ArrayList<>();
    }

    @Override
    public void displayInfo() {
        super.displayInfo();

        System.out.println("Nurse ID: " + nurseId);
        System.out.println("Department ID: " + departmentId);
        System.out.println("Shift: " + shift);
        System.out.println("Qualification: " + qualification);
    }

    // Assign patient
    public void assignPatient(Patient patient) {
        assignedPatients.add(patient);
        System.out.println(Constants.ASSIGNED);
    }

    // Remove patient
    public void removePatient(Patient patient) {
        assignedPatients.remove(patient);
        System.out.println(Constants.PATIENT_REMOVED);
    }
}
