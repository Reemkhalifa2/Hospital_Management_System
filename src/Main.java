import Entities.Appointment;
import Entities.MedicalRecord;
import Entities.Nurse;
import Services.AppointmentService;
import Services.MedicalRecordService;
import Services.NurseService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       /* AppointmentService appointmentService = new AppointmentService();
        Appointment appointment = appointmentService.addNewAppointment();
        appointmentService.createAppointment(appointment);
        appointmentService.displayAppointments();*/

      /*  NurseService nurseService = new NurseService();
        Nurse nurse = nurseService.addNurses();
        nurseService.addNurse(nurse);
        nurseService.getNurse();*/

        MedicalRecordService medicalRecordService = new MedicalRecordService();
        MedicalRecord medicalRecord = medicalRecordService.addNewRecords();
        medicalRecordService.addRecord(medicalRecord);
        medicalRecordService.getRecords();




    }
}