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
        for(String patient : assignedPatients){
            System.out.print(patient + ",");
        }
    }
}
