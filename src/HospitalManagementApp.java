import Menu.Menu;
import Services.*;
import Utilities.Constants;
import Utilities.InputHandler;
import Utilities.MenuMessage;
import Utilities.SampleData;

import java.time.LocalDate;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class HospitalManagementApp {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SampleData.loadData();
        PatientService patientService = new PatientService();
        DoctorService doctorService = new DoctorService();
        NurseService nurseService = new NurseService();
        DepartmentService departmentService = new DepartmentService();
        AppointmentService appointmentService = new AppointmentService();
        MedicalRecordService medicalRecordService = new MedicalRecordService();
        Menu menu = new Menu();
        boolean Continue = true;
        while (Continue) {
            menu.displayMenu();
            int choice = InputHandler.getIntInput(Constants.ENTER_OPTION, 1, 8);
            switch (choice) {
                case 1 -> patientService.handlePatientMenu();
                case 2 -> doctorService.handleDoctorMenu();
                case 3 -> nurseService.handleNurseMenu();
                case 4 -> appointmentService.handleAppointmentMenu();
                case 5 -> medicalRecordService.handleMedicalRecordMenu();
                case 6 -> departmentService.handleDepartmentMenu();
                case 7 -> {
                    boolean exit = true;
                    while (exit){
                        System.out.println(MenuMessage.ReportsMenu);
                        switch (InputHandler.getIntInput(Constants.ENTER_OPTION,0,5)){
                            case 1-> appointmentService.getupComingAppointments();
                            case 2-> doctorService.DoctorPerformanceReport();
                            case 3-> departmentService.departmentOccupancyReport();
                            case 4-> patientService.patientStatisticsReport();
                            case 5-> patientService.emergencyCasesReport();
                        }
                    }


                }
                case 8 -> {
                    System.out.println("Exit.....");
                    Continue = false;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

}
