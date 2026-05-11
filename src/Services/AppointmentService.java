package Services;

import Entities.Appointment;
import Entities.MedicalRecord;
import Utilities.Constants;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppointmentService {
    static Scanner scanner = new Scanner(System.in);
    List<Appointment> appointmentList = new ArrayList<>();

    public void addAppointment(Appointment appointment){
        appointmentList.add(appointment);
        System.out.println(Constants.APPOINTMENT_ADDED_SUCCESSFULLY);
    }

    public Appointment addNewAppointment(){

        System.out.println("Enter appointment Id: ");
        String appointmentId = scanner.nextLine();

        System.out.println("Enter patient Id: ");
        String patientId = scanner.nextLine();

        System.out.println("Enter Doctor Id: ");
        String doctorId = scanner.nextLine();

        LocalDate appointmentDate = LocalDate.now();

        System.out.println("Enter Appointment Time: ");
        String appointmentTime = scanner.nextLine();

        System.out.println("Enter status (Scheduled/Completed/Cancelled/Rescheduled): ");
        String status = scanner.nextLine();

        System.out.println("Enter reason: ");
        String reason = scanner.nextLine();

        System.out.println("Enter notes: ");
        String notes = scanner.nextLine();

        Appointment appointment = new Appointment(
                appointmentId,patientId,doctorId,appointmentDate,appointmentTime,status,reason,notes
        );

        return appointment;
    }

    public void editAppointment(String appointmentId, Appointment updatedAppointment){
        for(Appointment a : appointmentList){
            if(a.getAppointmentId().equals(appointmentId)){

                a.setNotes(updatedAppointment.getNotes());
                a.setReason(updatedAppointment.getReason());
                System.out.println(Constants.APPOINTMENT_UPDATED_SUCCESSFULLY);
                return;
            }
        }
        System.out.println(Constants.APPOINTMENT_NOT_FOUND);
    }
    public void rescheduleAppointment(String appointmentId, LocalDate newDate, String newTime){
        for(Appointment a : appointmentList){
            if(a.getAppointmentId().equals(appointmentId)){
                a.setAppointmentDate(newDate);
                a.setAppointmentTime(newTime);
                a.setStatus("Rescheduled");
            }
        }
    }

    public void cancelAppointment(String appointmentId){
        for(Appointment a : appointmentList){
            if(a.getAppointmentId().equals(appointmentId)){
                a.setStatus("Cancelled");
            }
        }
    }

















}
