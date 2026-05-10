package Entities;

import Utilities.Constants;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Patient extends Person{
    static Scanner scanner = new Scanner(System.in);
    private String patientId;
    private String bloodGroup;
    private List<String> allergies;
    private String emergencyContact;
    private LocalDate registrationDate;
    private String insuranceId;
    private List<String> medicalRecords;
    private List<String> appointments;

    //call parent constructor
    public Patient(String id, String firstName, String lastName,
                   LocalDate dateOfBirth, String gender,
                   String phoneNumber, String email, String address,
                   String patientId, String bloodGroup,
                   String emergencyContact, LocalDate registrationDate,
                   String insuranceId) {

        super(id, firstName, lastName, dateOfBirth,
                gender, phoneNumber, email, address);

        this.patientId = patientId;
        this.bloodGroup = bloodGroup;
        this.emergencyContact = emergencyContact;
        this.registrationDate = registrationDate;
        this.insuranceId = insuranceId;

        this.allergies = new ArrayList<>();
        this.medicalRecords = new ArrayList<>();
        this.appointments = new ArrayList<>();
    }




    //Display patient information
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

    public void addMedicalRecord(){
        System.out.println(Constants.ADD_MEDICAL_RECORD);
        medicalRecords.add(scanner.nextLine());
    }

    public void addAppointment(){
        System.out.println(Constants.ADD_APPOINTMENT);
        appointments.add(scanner.nextLine());
    }

    public void updateInsurance(){
        System.out.println(Constants.ENTER_INSURANCE);
        this.insuranceId = scanner.nextLine();
    }

}
