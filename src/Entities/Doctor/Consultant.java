package Entities.Doctor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Consultant extends Doctor{

    private List<String> consultationTypes;
    Boolean onlineConsultationAvailable;
    Integer consultationDuration;


    public Consultant(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender,
                      String phoneNumber, String email, String address, String specialization, String qualification,
                      Integer experienceYears, String departmentId, double consultationFee,
                      Boolean onlineConsultationAvailable , Integer consultationDuration) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, specialization, qualification, experienceYears, departmentId, consultationFee);
            this.consultationTypes = new ArrayList<>();
            this.onlineConsultationAvailable = onlineConsultationAvailable;
            this.consultationDuration = consultationDuration;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Online Consultation Available: " + onlineConsultationAvailable);
        System.out.println("Consultation Duration: " + consultationDuration);
        System.out.println("Consultation Types");
        for(String x : consultationTypes) {
            System.out.print(x + " , ");
        }
    }
}
