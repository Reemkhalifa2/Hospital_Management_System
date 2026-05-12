package Utilities;

import Entities.Department;
import Entities.Doctor.Consultant;
import Entities.Doctor.GeneralPractitioner;
import Entities.Doctor.Surgeon;
import Entities.Nurse;
import Entities.Patient.EmergencyPatient;
import Entities.Patient.InPatient;
import Entities.Patient.OutPatient;
import Entities.Patient.Patient;
import Services.PatientService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class SampleData {

    public static void loadPatients() {

        Patient p1 = new Patient("P",
                "Ali",
                "Ahmed",
                LocalDate.of(2000,1,1),
                "Male",
                "99999999",
                "ali@gmail.com",
                "Muscat",
                "A+",
                "91111111",
                LocalDate.now(),
                "INS001",
                new ArrayList<>(Arrays.asList("Dust"))
        );

        Patient p2 = new Patient(
                "P",
                "Sara",
                "Mohammed",
                LocalDate.of(1999,5,10),
                "Female",
                "98888888",
                "sara@gmail.com",
                "Seeb",
                "B+",
                "92222222",
                LocalDate.now(),
                "INS002",
                new ArrayList<>(Arrays.asList("Penicillin"))
        );

        Patient p3 = new Patient(
                "P",
                "Omar",
                "Salim",
                LocalDate.of(1998,3,20),
                "Male",
                "97777777",
                "omar@gmail.com",
                "Bowsher",
                "O+",
                "93333333",
                LocalDate.now(),
                "INS003",
                new ArrayList<>(Arrays.asList("Peanuts"))
        );

        InPatient p4 = new InPatient(
                "P",
                "Hana",
                "Nasser",
                LocalDate.of(2014,8,22),
                "Female",
                "97777777",
                "hana@gmail.com",
                "Nizwa",
                "O+",
                "95989659",
                LocalDate.now(),
                "INS004",
                new ArrayList<>(Arrays.asList()),
                LocalDate.of(2026,02,02),
                LocalDate.of(2026,02,20),
                "Room-05",
                "Bed-1",
                "D45446",
                3.5
                );
        OutPatient p5 = new OutPatient(
                "P005",
                "Mona",
                "Khalid",
                LocalDate.of(2001,4,15),
                "Female",
                "94444444",
                "mona@gmail.com",
                "Muscat",
                "AB+",
                "90000001",
                LocalDate.now(),
                "INS005",
                new ArrayList<>(Arrays.asList("Seafood")),
                5,
                LocalDate.of(2026,1,15),
                "D100"
        );

        OutPatient p6 = new OutPatient(
                "P006",
                "Yousef",
                "Said",
                LocalDate.of(1997,11,2),
                "Male",
                "95555555",
                "yousef@gmail.com",
                "Salalah",
                "B-",
                "90000002",
                LocalDate.now(),
                "INS006",
                new ArrayList<>(Arrays.asList()),
                2,
                LocalDate.of(2026,3,1),
                "D101"
        );

        OutPatient p7 = new OutPatient(
                "P007",
                "Fatma",
                "Ali",
                LocalDate.of(2003,6,30),
                "Female",
                "96666666",
                "fatma@gmail.com",
                "Sohar",
                "A-",
                "90000003",
                LocalDate.now(),
                "INS007",
                new ArrayList<>(Arrays.asList("Milk")),
                7,
                LocalDate.of(2026,2,10),
                "D102"
        );

        InPatient p8 = new InPatient(
                "P008",
                "Majid",
                "Hamad",
                LocalDate.of(1995,9,12),
                "Male",
                "97778888",
                "majid@gmail.com",
                "Ibri",
                "O-",
                "90000004",
                LocalDate.now(),
                "INS008",
                new ArrayList<>(Arrays.asList("Dust")),
                LocalDate.of(2026,4,1),
                LocalDate.of(2026,4,12),
                "Room-10",
                "Bed-2",
                "D103",
                5.0
        );

        InPatient p9 = new InPatient(
                "P009",
                "Noor",
                "Salem",
                LocalDate.of(2002,12,5),
                "Female",
                "98889999",
                "noor@gmail.com",
                "Rustaq",
                "A+",
                "90000005",
                LocalDate.now(),
                "INS009",
                new ArrayList<>(Arrays.asList("Pollen")),
                LocalDate.of(2026,1,20),
                LocalDate.of(2026,1,28),
                "Room-03",
                "Bed-4",
                "D104",
                4.5
        );

        EmergencyPatient p10 = new EmergencyPatient(
                "P010",
                "Saif",
                "Rashid",
                LocalDate.of(1990,7,18),
                "Male",
                "99990000",
                "saif@gmail.com",
                "Sur",
                "B+",
                "90000006",
                LocalDate.now(),
                "INS010",
                new ArrayList<>(Arrays.asList("Medicine")),
                LocalDate.of(2026,5,1),
                LocalDate.of(2026,5,5),
                "ER-01",
                "Bed-ER",
                "D105",
                8.0,
                "Accident",
                "Ambulance",
                1,
                true
        );


        //Doctors sample data

        Consultant d1 = new Consultant(
                "D001",
                "Ahmed",
                "Salim",
                LocalDate.of(1980,5,12),
                "Male",
                "91111111",
                "ahmed@hospital.com",
                "Muscat",
                "Cardiology",
                "MBBS",
                15,
                "DEP01",
                25.0
        );

        Consultant d2 = new Consultant(
                "D002",
                "Mariam",
                "Ali",
                LocalDate.of(1985,3,20),
                "Female",
                "92222222",
                "mariam@hospital.com",
                "Seeb",
                "Dermatology",
                "MD",
                12,
                "DEP02",
                20.0
        );

        GeneralPractitioner d3 = new GeneralPractitioner(
                "D003",
                "Hassan",
                "Khalid",
                LocalDate.of(1978,9,15),
                "Male",
                "93333333",
                "hassan@hospital.com",
                "Nizwa",
                "General Medicine",
                "MBBS",
                18,
                "DEP03",
                18.5,
                true,
                true,
                true
        );

        GeneralPractitioner d4 = new GeneralPractitioner(
                "D004",
                "Fatma",
                "Saeed",
                LocalDate.of(1990,11,25),
                "Female",
                "94444444",
                "fatma@hospital.com",
                "Sohar",
                "Family Medicine",
                "MBBS",
                8,
                "DEP03",
                15.0,
                true,
                false,
                true
        );

        Surgeon d5 = new Surgeon(
                "D005",
                "Salem",
                "Nasser",
                LocalDate.of(1975,1,30),
                "Male",
                "95555555",
                "salem@hospital.com",
                "Muscat",
                "Orthopedic Surgery",
                "PhD",
                20,
                "DEP04",
                40.0,
                350,
                true
        );

        Surgeon d6 = new Surgeon(
                "D006",
                "Noor",
                "Hamed",
                LocalDate.of(1988,7,14),
                "Female",
                "96666666",
                "noor@hospital.com",
                "Sur",
                "Neurosurgery",
                "MD",
                10,
                "DEP04",
                50.0,
                120,
                true
        );

        Consultant d7 = new Consultant(
                "D007",
                "Omar",
                "Rashid",
                LocalDate.of(1982,6,18),
                "Male",
                "97777777",
                "omar@hospital.com",
                "Ibri",
                "Pediatrics",
                "MBBS",
                14,
                "DEP05",
                22.0
        );

        GeneralPractitioner d8 = new GeneralPractitioner(
                "D008",
                "Aisha",
                "Mohammed",
                LocalDate.of(1992,2,8),
                "Female",
                "98888888",
                "aisha@hospital.com",
                "Barka",
                "General Practice",
                "MBBS",
                6,
                "DEP03",
                17.0,
                false,
                true,
                false
        );

        //sample data for databases
        Nurse n1 = new Nurse(
                "N001",
                "Layla",
                "Ahmed",
                LocalDate.of(1995,4,10),
                "Female",
                "91112222",
                "layla@hospital.com",
                "Muscat",
                "DEP01",
                "Morning",
                "BSc Nursing"
        );

        Nurse n2 = new Nurse(
                "N002",
                "Khalid",
                "Salim",
                LocalDate.of(1992,8,21),
                "Male",
                "92223333",
                "khalid@hospital.com",
                "Seeb",
                "DEP02",
                "Night",
                "Diploma Nursing"
        );

        Nurse n3 = new Nurse(
                "N003",
                "Maha",
                "Nasser",
                LocalDate.of(1998,1,15),
                "Female",
                "93334444",
                "maha@hospital.com",
                "Nizwa",
                "DEP03",
                "Evening",
                "BSc Nursing"
        );

        Nurse n4 = new Nurse(
                "N004",
                "Saeed",
                "Ali",
                LocalDate.of(1990,11,5),
                "Male",
                "94445555",
                "saeed@hospital.com",
                "Sohar",
                "DEP04",
                "Morning",
                "MSc Nursing"
        );

        Nurse n5 = new Nurse(
                "N005",
                "Huda",
                "Mohammed",
                LocalDate.of(1997,6,30),
                "Female",
                "95556666",
                "huda@hospital.com",
                "Sur",
                "DEP05",
                "Night",
                "BSc Nursing"
        );

        Department dep1 = new Department(
                "DEP01",
                "Cardiology",
                "D001",
                50
        );

        Department dep2 = new Department(
                "DEP02",
                "Dermatology",
                "D002",
                30
        );

        Department dep3 = new Department(
                "DEP03",
                "General Medicine",
                "D003",
                70
        );



    }
}