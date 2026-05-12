import Menu.Menu;
import Services.PatientService;
import Utilities.Constants;
import Utilities.InputHandler;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class HospitalManagementApp {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        PatientService patientService = new PatientService();
        Menu menu = new Menu();
        boolean Continue = true;
        while (Continue) {
            menu.displayMenu();
            int choice = InputHandler.getIntInput(Constants.ENTER_OPTION, 1, 8);
            switch (choice) {
                case 1 -> patientService.handlePatientMenu();
            /*    case 2 -> doctorMenu();
                case 3 -> nurseMenu();
                case 4 -> appointmentMenu();
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
