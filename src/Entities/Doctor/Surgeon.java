package Entities.Doctor;

import java.time.LocalDate;

public class Surgeon extends Doctor{

    public Surgeon(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String specialization, String qualification, Integer experienceYears, String departmentId, double consultationFee) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, specialization, qualification, experienceYears, departmentId, consultationFee);
    }
}
