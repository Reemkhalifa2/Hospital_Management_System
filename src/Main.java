import Entities.Appointment;
import Entities.MedicalRecord;
import Entities.Nurse;
import Entities.Patient.Patient;
import Menu.Menu;
import Services.AppointmentService;
import Services.MedicalRecordService;
import Services.NurseService;
import Services.PatientService;
import Utilities.Constants;
import Utilities.MenuMessage;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        handleMainMenu();



    }


    public static void handleMainMenu() {
        PatientService patientService = new PatientService();


        Menu menu = new Menu();
        menu.displayMenu();
        System.out.println(Constants.ENTER_OPTION);
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {

            case 1 -> {
                System.out.println(MenuMessage.PatientManagementMenu);
                PatientService.handlePatientMenu();
                handleMainMenu();
            }

        }
    }

}