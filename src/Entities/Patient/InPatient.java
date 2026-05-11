package Entities.Patient;

import java.time.LocalDate;
import java.util.List;

public class InPatient extends Patient{
    LocalDate admissionDate;
    LocalDate dischargeDate;
    String roomNumber;
    String bedNumber;
    String admittingDoctorId;
    Double dailyCharges;


    public InPatient(String id, String firstName, String lastName, LocalDate dateOfBirth,
                     String gender, String phoneNumber, String email, String address,
                     String bloodGroup, String emergencyContact, LocalDate registrationDate,
                     String insuranceId, List<String> allergies, LocalDate admissionDate, LocalDate dischargeDate, String roomNumber, String bedNumber, String admittingDoctorId, Double dailyCharges) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, bloodGroup, emergencyContact, registrationDate, insuranceId, allergies);

        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.roomNumber =  roomNumber;
        this.bedNumber =  bedNumber;
        this.admittingDoctorId  = admittingDoctorId;
        this.dailyCharges = dailyCharges;
    }
}
