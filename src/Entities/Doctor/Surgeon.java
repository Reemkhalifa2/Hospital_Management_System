package Entities.Doctor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Surgeon extends Doctor{
    private Integer surgeriesPerformed;
    private List<String> surgeryTypes;
    private Boolean operationTheatreAccess;


    public Surgeon(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender,
                   String phoneNumber, String email, String address, String specialization, String qualification,
                   Integer experienceYears, String departmentId, double consultationFee , Integer surgeriesPerformed ,Boolean operationTheatreAccess) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, specialization, qualification, experienceYears, departmentId, consultationFee);
            this.surgeriesPerformed = surgeriesPerformed;
            this.operationTheatreAccess = operationTheatreAccess;
            this.surgeryTypes = new ArrayList<>();
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Surgeries Performed: " + surgeriesPerformed);
        System.out.println("Operation Theatre Access: " + operationTheatreAccess);
        for(String x : surgeryTypes){
            System.out.print(x + " , ");
        }
    }
}
