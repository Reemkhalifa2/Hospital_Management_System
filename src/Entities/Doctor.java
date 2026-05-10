package Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Doctor extends Person{
    private String doctorId;
    private String specialization;
    private String qualification;
    private Integer experienceYears;
    private String departmentId;
    private double consultationFee;
    private List<String> availableSlots;
    private List<Patient> assignedPatients;


    public Doctor(String id, String firstName, String lastName,
                  LocalDate dateOfBirth, String gender, String phoneNumber,
                  String email, String address , String doctorId, String specialization,
                  String qualification , Integer experienceYears , String departmentId,
                  double consultationFee) {

        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address);

        this.doctorId = doctorId;
        this.specialization = specialization;
        this.qualification = qualification;
        this.experienceYears = experienceYears;
        this.departmentId = departmentId;
        this.consultationFee = consultationFee;
        this.availableSlots = new ArrayList<>();
        this.assignedPatients = new ArrayList<>();
    }
    public Patient addPatient(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter patient id:");
        String id = scanner.nextLine();

        System.out.println("Enter first name:");
        String firstName = scanner.nextLine();

        System.out.println("Enter last name:");
        String lastName = scanner.nextLine();

        System.out.println("Enter gender:");
        String gender = scanner.nextLine();

        System.out.println("Enter phone number:");
        String phone = scanner.nextLine();

        System.out.println("Enter date of birth (yyyy-MM-dd):");
        String DOB = scanner.nextLine();
        LocalDate dateOfBirth = LocalDate.parse(DOB);

        System.out.println("Enter email:");
        String email = scanner.nextLine();

        System.out.println("Enter address:");
        String address = scanner.nextLine();

        System.out.println("Enter patient ID:");
        String patientId = scanner.nextLine();

        System.out.println("Enter blood group:");
        String bloodGroup = scanner.nextLine();

        System.out.println("Enter emergency contact:");
        String emergencyContact = scanner.nextLine();

        System.out.println("Enter insurance ID:");
        String insuranceId = scanner.nextLine();

        Patient patient;
        patient = new Patient(
                id,
                firstName,
                lastName,
                dateOfBirth,
                gender,
                phone,
                email,
                address,
                patientId,
                bloodGroup,
                emergencyContact,
                LocalDate.now(),
                insuranceId
        );
        return patient;

    }

    public void assignPatient(){

       assignedPatients.add(addPatient());

    }




    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println(doctorId);
        System.out.println(specialization);
        System.out.println(qualification);
        System.out.println(experienceYears);
        System.out.println(departmentId);
        System.out.println(consultationFee);

        System.out.println("Available Slots");
        for(String slot : availableSlots){
            System.out.print(slot + ",");
        }

        System.out.println("Assigned Patients");
        for(Patient patient : assignedPatients){
            patient.displayInfo();
        }
    }
}
