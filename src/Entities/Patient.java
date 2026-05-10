package Entities;

import java.time.LocalDate;
import java.util.List;

public class Patient extends Person{

    public Patient(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address);

    }
    String patientId;
    String bloodGroup;
    List<String> allergies;
    String emergencyContact;
    LocalDate registrationDate;
    String insuranceId;
    List<String> medicalRecords;
    List<String> appointments;


}
