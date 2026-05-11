package Entities.Patient;

import java.time.LocalDate;
import java.util.List;

public class InPatient extends Patient{
    LocalDate admissionDate;
    LocalDate dischargeDate;
    String roomNumber;
    String bedNumber;

    public InPatient(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String bloodGroup, String emergencyContact, LocalDate registrationDate, String insuranceId, List<String> allergies) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, bloodGroup, emergencyContact, registrationDate, insuranceId, allergies);
    }
}
