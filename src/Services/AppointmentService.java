package Services;

import Behaviour.Appointable;
import Behaviour.Manageable;
import Behaviour.Searchable;
import Entities.Appointment;
import Utilities.Constants;
import Utilities.HelperUtils;
import Utilities.InputHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppointmentService implements Manageable , Searchable , Appointable {

    static Scanner scanner = new Scanner(System.in);
    private static List<Appointment> appointmentList = new ArrayList<>();

    public void createAppointment(Appointment appointment){
        // Integrate HelperUtils Throughout the System
        if(HelperUtils.isNotNull(appointment)){
        appointmentList.add(appointment);
        System.out.println(Constants.APPOINTMENT_ADDED_SUCCESSFULLY);}
    }

    public Appointment addNewAppointment(){

        String patientId = InputHandler.getStringInput("Enter Patient Id: ");
        String doctorId = InputHandler.getStringInput("Enter Doctor Id: ");

        LocalDate appointmentDate = InputHandler.getDateInput("Enter Date: ");

        String appointmentTime = String.valueOf(InputHandler.getTimeInput("Enter Appointment Time: "));



        System.out.println("Enter status (Scheduled/Completed/Cancelled/Rescheduled): ");
        String status = scanner.nextLine();
        List<String> validStatus = List.of("Scheduled", "Completed", "Cancelled", "Rescheduled");
        if (!validStatus.contains(status)) {
            System.out.println("Invalid status value");
            return null;
        }

        System.out.println("Enter reason: ");
        String reason = scanner.nextLine();

        System.out.println("Enter notes: ");
        String notes = scanner.nextLine();

        Appointment appointment = new Appointment(
                // Integrate HelperUtils Throughout the System
                HelperUtils.generateId("A",3),
                patientId,
                doctorId,
                appointmentDate,
                appointmentTime,
                status,
                reason,
                notes
        );

        return appointment;
    }

    public void editAppointment(String appointmentId, Appointment updatedAppointment){
        for(Appointment a : appointmentList){
            if (HelperUtils.isNotNull(a.getAppointmentId())
                    && a.getAppointmentId().equals(appointmentId)){

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
            if (HelperUtils.isNotNull(a.getAppointmentId())
                    && a.getAppointmentId().equals(appointmentId)){
                a.setAppointmentDate(newDate);
                a.setAppointmentTime(newTime);
                a.setStatus("Rescheduled");
                System.out.println(Constants.APPOINTMENT_RESCHEDULED_SUCCESSFULLY);
                return;
            }
        }
        System.out.println(Constants.APPOINTMENT_NOT_FOUND);

    }

    @Override
    public void scheduleAppointment(Appointment appointment) {

    }

    public void cancelAppointment(String appointmentId){
        for(Appointment a : appointmentList){
            if (HelperUtils.isNotNull(a.getAppointmentId())
                    && a.getAppointmentId().equals(appointmentId)){
                a.setStatus("Cancelled");
                System.out.println(Constants.APPOINTMENT_CANCELLED_SUCCESSFULLY);
                return;
            }
        }
        System.out.println(Constants.APPOINTMENT_NOT_FOUND);
    }

    public void getAppointmentsByPatient(String patientId){
        for(Appointment a : appointmentList){
            if(a.getPatientId().equals(patientId)){
                a.displayInfo();
                return;
            }
        }
        System.out.println(Constants.APPOINTMENT_NOT_FOUND);
    }

    public void getAppointmentsByDoctor(String doctorId){
        for(Appointment a : appointmentList){
            if(a.getDoctorId().equals(doctorId)){
                a.displayInfo();
                return;
            }
        }
        System.out.println(Constants.APPOINTMENT_NOT_FOUND);
    }

    public void displayAppointments(LocalDate date){
        for(Appointment a : appointmentList){
            if(a.getAppointmentDate().equals(date)){
                a.displayInfo();
                return;
            }
        }
        System.out.println(Constants.APPOINTMENT_NOT_FOUND);
    }
    public void displayAppointments(){
        for(Appointment a : appointmentList){
                a.displayInfo();
        }
    }

    public void createAppointment(String patientId, String doctorId, LocalDate date){
        Appointment appointment = new Appointment();

        appointment.setPatientId(patientId);
        appointment.setDoctorId(doctorId);
        appointment.setAppointmentDate(date);

        appointmentList.add(appointment);
    }

    public void createAppointment(String patientId, String doctorId, LocalDate date, String time){
        Appointment appointment = new Appointment();

        appointment.setPatientId(patientId);
        appointment.setDoctorId(doctorId);
        appointment.setAppointmentDate(date);
        appointment.setAppointmentTime(time);

        appointmentList.add(appointment);
    }

    public void rescheduleAppointment(String appointmentId, LocalDate newDate){
        for (Appointment appointment : appointmentList){
            if(appointment.getAppointmentId().equals(appointmentId)){
                appointment.setAppointmentDate(newDate);
                appointment.setStatus("Rescheduled");
                System.out.println(Constants.APPOINTMENT_RESCHEDULED_SUCCESSFULLY);
                return;
            }

        }
        System.out.println(Constants.APPOINTMENT_NOT_FOUND);
    }

    public void rescheduleAppointment(Appointment appointment, LocalDate newDate, String newTime, String reason){
        for (Appointment a : appointmentList){
            if(a.getAppointmentId().equals(appointment.getAppointmentId())){
                a.setAppointmentTime(newTime);
                a.setAppointmentDate(newDate);
                a.setReason(reason);
                a.setStatus("Rescheduled");
                System.out.println(Constants.APPOINTMENT_RESCHEDULED_SUCCESSFULLY);
                return;
            }


        }
        System.out.println(Constants.APPOINTMENT_NOT_FOUND);
    }

    public void displayAppointments(String doctorId, LocalDate startDate, LocalDate endDate){
        for(Appointment a : appointmentList){
            if(a.getDoctorId().equals(doctorId)
            && !a.getAppointmentDate().isBefore(startDate) && !a.getAppointmentDate().isAfter(endDate)){
                a.displayInfo();
                return;
            }
        }
        System.out.println(Constants.APPOINTMENT_NOT_FOUND);
    }


    @Override
    public void add(Object entity) {

    }

    @Override
    public void remove(String id) {

    }

    @Override
    public void getAll() {

    }

    @Override
    public void search(String keyword) {

    }

    @Override
    public void searchById(String id) {

    }
}
