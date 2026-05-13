import Menu.Menu;
import Services.DoctorService;
import Services.NurseService;
import Services.PatientService;
import Utilities.Constants;
import Utilities.InputHandler;
import Utilities.SampleData;

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
        Menu menu = new Menu();
        boolean Continue = true;
        while (Continue) {
            menu.displayMenu();
            int choice = InputHandler.getIntInput(Constants.ENTER_OPTION, 1, 8);
            switch (choice) {
                case 1 -> patientService.handlePatientMenu();
                case 2 -> doctorService.handleDoctorMenu();
                case 3 -> nurseService.handleNurseMenu();
              /*   case 4 -> appointmentMenu();
                case 5 -> medicalRecordMenu();
                case 6 -> departmentMenu();
                case 7 -> reportsMenu();*/
                case 8 -> {
                    System.out.println("Exit.....");
                    Continue = false;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

}
