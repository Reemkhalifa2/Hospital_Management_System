package Services;

import Entities.MedicalRecord;
import Entities.Nurse;
import Utilities.Constants;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedicalRecordService {
    List <MedicalRecord> medicalRecords = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public void addRecord(MedicalRecord record){
        medicalRecords.add(record);
        System.out.println(Constants.RECORD_ADDED_SUCCESSFULLY);
    }

    public MedicalRecord addNewRecords(){
        System.out.println("Enter Record Id: ");
        String recordId = scanner.nextLine();

        System.out.println("Enter patient Id: ");
        String patientId = scanner.nextLine();

        System.out.println("Enter Doctor Id: ");
        String doctorId = scanner.nextLine();

        LocalDate visitDate = LocalDate.now();

        System.out.println("Enter diagnosis: ");
        String diagnosis = scanner.nextLine();

        System.out.println("Enter prescription: ");
        String prescription = scanner.nextLine();

        System.out.println("Enter testResults: ");
        String testResults = scanner.nextLine();

        System.out.println("Enter notes: ");
        String notes = scanner.nextLine();

        MedicalRecord medicalRecord = new MedicalRecord(
                recordId,patientId,doctorId,visitDate,diagnosis,prescription,testResults,notes
        );

        return medicalRecord;

    }






}
