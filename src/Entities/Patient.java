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

    @Override
    public void displayInfo() {
        super.displayInfo();

        System.out.println("Patient ID        :"+patientId);
        System.out.println("Blood Group       :"+bloodGroup );

        System.out.println("Allergies");
        for(String x : allergies){
            System.out.print(x + ",");
        }

        System.out.println("Emergency Contact :"+emergencyContact);
        System.out.println("Registration Date :"+registrationDate);
        System.out.println("Insurance Id"+insuranceId);

        System.out.println("Medical Records");
        for(String x : medicalRecords){
            System.out.print(x + ",");

        }System.out.println("Appointments");
        for(String x : appointments){
            System.out.print(x + ",");
        }

            }
}
