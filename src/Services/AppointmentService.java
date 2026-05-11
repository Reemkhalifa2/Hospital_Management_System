package Services;

import Entities.Appointment;
import Utilities.Constants;

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




}
