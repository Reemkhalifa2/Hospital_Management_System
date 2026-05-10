package Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Doctor extends Person{
    private String doctorId;
    private String specialization;
    private String qualification;
    private Integer experienceYears;
    private String departmentId;
    private String consultationFee;
    private List<String> availableSlots;
    private List<String> assignedPatients;


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
}
