package Utilities;

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



    }
}