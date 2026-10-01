import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HospitalManagement extends Application {

    // Shared Scanner for the whole application
    private Scanner input = new Scanner(System.in);

    // Arrays with the required capacities
    private Doctor[] doctors = new Doctor[25];
    private Patient[] patients = new Patient[100];
    private Medical[] medicals = new Medical[100];
    private Lab[] laboratories = new Lab[20];
    private Facility[] facilities = new Facility[20];
    private Staff[] staffs = new Staff[100];

    // Number of records currently stored in each array
    private int doctorCount = 0;
    private int patientCount = 0;
    private int medicalCount = 0;
    private int laboratoryCount = 0;
    private int facilityCount = 0;
    private int staffCount = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        initializeData();
        showMainMenu(primaryStage);
    }

    private void showMainMenu(Stage primaryStage) {

        // Welcome message
        Label title = new Label("Hospital Management System");
        title.setStyle("-fx-font-size: 28px; -fx-font-weight: bold;");

        Label welcome = new Label("Welcome to the HMS");
        welcome.setStyle("-fx-font-size: 18px;");

        DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        Label dateTime = new Label(
            "Date and Time: " + LocalDateTime.now().format(formatter)
        );

        // Main menu buttons
        Button doctorButton = new Button("Doctors");
        Button patientButton = new Button("Patients");
        Button medicalButton = new Button("Medical");
        Button laboratoryButton = new Button("Laboratories");
        Button facilityButton = new Button("Facilities");
        Button staffButton = new Button("Staff");
        Button exitButton = new Button("Exit");

        // Button sizes
        doctorButton.setPrefWidth(250);
        patientButton.setPrefWidth(250);
        medicalButton.setPrefWidth(250);
        laboratoryButton.setPrefWidth(250);
        facilityButton.setPrefWidth(250);
        staffButton.setPrefWidth(250);
        exitButton.setPrefWidth(250);

        // Button actions
        doctorButton.setOnAction(e -> showDoctorGUI(primaryStage));
        patientButton.setOnAction(e -> showPatientGUI(primaryStage));
        medicalButton.setOnAction(e -> showMedicalGUI(primaryStage));
        laboratoryButton.setOnAction(e -> showLaboratoryGUI(primaryStage));
        facilityButton.setOnAction(e -> showFacilityGUI(primaryStage));
        staffButton.setOnAction(e -> showStaffGUI(primaryStage));

        exitButton.setOnAction(e -> primaryStage.close());

        VBox layout = new VBox(
            12,
            title,
            welcome,
            dateTime,
            doctorButton,
            patientButton,
            medicalButton,
            laboratoryButton,
            facilityButton,
            staffButton,
            exitButton
        );

        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(30));

        Scene scene = new Scene(layout, 500, 650);

        primaryStage.setTitle("Hospital Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Start the Hospital Management System
    public void startConsole() {
        initializeData();
        displayWelcome();
        mainMenu();
    }

    // Initialize existing records for all six categories
    private void initializeData() {

        // ==================== DOCTORS ====================
        doctors[0] = new Doctor(
            "389",
            "Dr. Soo Joe Yong",
            "General Physician",
            "8-11AM",
            "MBBS, MD",
            8
        );

        doctors[1] = new Doctor(
            "866",
            "Dr. Low Zhe Yuan",
            "Surgeon",
            "8-11AM",
            "MBBS, MD",
            9
        );

        doctors[2] = new Doctor(
            "183",
            "Dr. Lim Chee Hao",
            "Pediatrician",
            "10AM-1PM",
            "MBBS, DCH",
            10
        );

        doctors[3] = new Doctor(
            "587",
            "Dr. Desmond Beh",
            "Cardiologist",
            "1-4PM",
            "MBBS, MRCP",
            11
        );
        
        doctors[4] = new Doctor(
        	    "621",
        	    "Dr. Sarah Lee",
        	    "Neurologist",
        	    "2-5PM",
        	    "MBBS, MRCP",
        	    12
        	);

        doctorCount = 5;


        // ==================== PATIENTS ====================
        patients[0] = new Patient(
            "389",
            "Soo Joe Yong",
            "Fever",
            "Male",
            "outpatient",
            20
        );

        patients[1] = new Patient(
            "102",
            "John Lim",
            "Flu",
            "Male",
            "outpatient",
            35
        );

        patients[2] = new Patient(
            "103",
            "Mary Tan",
            "Asthma",
            "Female",
            "inpatient",
            28
        );

        patients[3] = new Patient(
            "104",
            "David Wong",
            "Diabetes",
            "Male",
            "observation",
            52
        );

        patients[4] = new Patient(
            "105",
            "Lisa Lee",
            "Migraine",
            "Female",
            "discharged",
            41
        );

        patientCount = 5;


        // ==================== MEDICALS ====================
        medicals[0] = new Medical(
    	    "Paracetamol",
    	    "GSK",
    	    "04/06/2027",
    	    10,
    	    100
    	);

    	medicals[1] = new Medical(
    	    "Amoxicillin",
    	    "Pfizer",
    	    "15/09/2027",
    	    25,
    	    80
    	);

    	medicals[2] = new Medical(
    	    "Ibuprofen",
    	    "Abbott",
    	    "20/11/2027",
    	    15,
    	    60
    	);

    	medicals[3] = new Medical(
    	    "Cetirizine",
    	    "Novartis",
    	    "10/01/2028",
    	    12,
    	    75
    	);

    	medicals[4] = new Medical(
    	    "Omeprazole",
    	    "AstraZeneca",
    	    "25/03/2028",
    	    30,
    	    50
    	);

        medicalCount = 5;


        // ==================== LABORATORIES ====================
        laboratories[0] = new Lab("Pathology Lab", 250);
        laboratories[1] = new Lab("Radiology Lab", 500);
        laboratories[2] = new Lab("X-Ray Lab", 150);
        laboratories[3] = new Lab("Blood Bank Lab", 100);
        laboratories[4] = new Lab("Microbiology Lab", 300);

        laboratoryCount = 5;


        // ==================== FACILITIES ====================
        facilities[0] = new Facility("Emergency Room (ER)");
        facilities[1] = new Facility("Intensive Care Unit (ICU)");
        facilities[2] = new Facility("Operating Theater (OT)");
        facilities[3] = new Facility("Ambulance Service");
        facilities[4] = new Facility("Cafeteria");

        facilityCount = 5;


        // ==================== STAFF ====================
        staffs[0] = new Staff(
            "389",
            "Soo Joe Yong",
            "Administrator",
            "Male",
            3500
        );

        staffs[1] = new Staff(
            "202",
            "Alice Tan",
            "Nurse",
            "Female",
            3200
        );

        staffs[2] = new Staff(
            "203",
            "Brian Lee",
            "Receptionist",
            "Male",
            2800
        );

        staffs[3] = new Staff(
            "204",
            "Catherine Wong",
            "Pharmacist",
            "Female",
            4000
        );

        staffs[4] = new Staff(
            "205",
            "Daniel Lim",
            "Technician",
            "Male",
            3000
        );

        staffCount = 5;
    }

    // Display welcome message and current date/time
    private void displayWelcome() {
        DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        String currentDateTime =
            LocalDateTime.now().format(formatter);

        System.out.println();
        System.out.println("==============================================");
        System.out.println("       Welcome to the Hospital Management System");
        System.out.println("       Date and Time: " + currentDateTime);
        System.out.println("==============================================");
    }

    // Display the main menu
    private void mainMenu() {

        int choice;

        do {
            System.out.println();
            System.out.println("============== MAIN MENU ==============");
            System.out.println("1. Doctors");
            System.out.println("2. Patients");
            System.out.println("3. Medical");
            System.out.println("4. Laboratories");
            System.out.println("5. Facilities");
            System.out.println("6. Staff");
            System.out.println("7. Exit");
            System.out.println("========================================");
            System.out.print("Enter your choice: ");

            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine();

                switch (choice) {
                    case 1:
                    	doctorMenu();
                        break;

                    case 2:
                    	patientMenu();
                        break;

                    case 3:
                    	medicalMenu();
                        break;

                    case 4:
                    	laboratoryMenu();
                        break;

                    case 5:
                    	facilityMenu();
                        break;

                    case 6:
                    	staffMenu();
                        break;

                    case 7:
                        System.out.println("Exiting Hospital Management System...");
                        break;

                    default:
                        System.out.println(
                            "Invalid choice! Please enter a number from 1 to 7."
                        );
                }

            } else {
                System.out.println(
                    "Invalid input! Please enter a number from 1 to 7."
                );
                input.nextLine();
                choice = 0;
            }

        } while (choice != 7);

        input.close();
    }
    // Display the Doctor menu
    private void doctorMenu() {
    	int choice;
    	
        do {
        	System.out.println();
            System.out.println("============== DOCTOR MENU ==============");
            System.out.println("1. Add New Doctor");
            System.out.println("2. Display Doctors");
            System.out.println("3. Return to Main Menu");
            System.out.println("=========================================");
            System.out.print("Enter your choice: ");

            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine();

                switch (choice) {

                    case 1:
                        addDoctor();
                        break;

                    case 2:
                        displayDoctors();
                        break;

                    case 3:
                        System.out.println("Returning to Main Menu...");
                        break;

                    default:
                        System.out.println(
                            "Invalid choice! Please enter a number from 1 to 3."
                        );
                }

            } else {
                System.out.println(
                    "Invalid input! Please enter a number from 1 to 3."
                );
                input.nextLine();
                choice = 0;
            }

        } while (choice != 3);
    }
    // Add a new doctor to the array
    private void addDoctor() {

        if (doctorCount >= doctors.length) {
            System.out.println("Doctor list is full. Cannot add more doctors.");
            return;
        }

        Doctor doctor = new Doctor("", "", "", "", "", 0);

        doctor.newDoctor(input);

        doctors[doctorCount] = doctor;
        doctorCount++;

        System.out.println("Doctor added successfully!");
    }
    // Display all existing doctors
    private void displayDoctors() {

        if (doctorCount == 0) {
            System.out.println("No doctors available.");
            return;
        }

        System.out.println();
        System.out.println("==================== DOCTORS ====================");
        System.out.printf(
        	"%-8s %-20s %-20s %-15s %-18s %-8s%n",
            "ID", "Name", "Specialist", "Work Time",
            "Qualification", "Room"
        );
        System.out.println("--------------------------------------------------------------------------");

        for (int i = 0; i < doctorCount; i++) {
            doctors[i].showDoctorInfo();
        }

        System.out.println("--------------------------------------------------------------------------");
    }
 // Display the Patient menu
    private void patientMenu() {
        int choice;

        do {
            System.out.println();
            System.out.println("============== PATIENT MENU ==============");
            System.out.println("1. Add New Patient");
            System.out.println("2. Display Patients");
            System.out.println("3. Return to Main Menu");
            System.out.println("==========================================");
            System.out.print("Enter your choice: ");

            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine();

                switch (choice) {

                    case 1:
                        addPatient();
                        break;

                    case 2:
                        displayPatients();
                        break;

                    case 3:
                        System.out.println("Returning to Main Menu...");
                        break;

                    default:
                        System.out.println(
                            "Invalid choice! Please enter a number from 1 to 3."
                        );
                }

            } else {
                System.out.println(
                    "Invalid input! Please enter a number from 1 to 3."
                );
                input.nextLine();
                choice = 0;
            }

        } while (choice != 3);
    }


    // Add a new patient to the array
    private void addPatient() {

        if (patientCount >= patients.length) {
            System.out.println("Patient list is full. Cannot add more patients.");
            return;
        }

        Patient patient = new Patient("", "", "", "", "", 0);

        patient.newPatient(input);

        patients[patientCount] = patient;
        patientCount++;

        System.out.println("Patient added successfully!");
    }


    // Display all existing patients
    private void displayPatients() {

        if (patientCount == 0) {
            System.out.println("No patients available.");
            return;
        }

        System.out.println();
        System.out.println("==================== PATIENTS ====================");
        System.out.printf(
            "%-10s %-20s %-15s %-10s %-15s %-5s%n",
            "ID", "Name", "Disease", "Sex", "Admit Status", "Age"
        );
        System.out.println("--------------------------------------------------------------------------");

        for (int i = 0; i < patientCount; i++) {
            patients[i].showPatientInfo();
        }

        System.out.println("--------------------------------------------------------------------------");
    }
    
 // Display the Medical menu
    private void medicalMenu() {
        int choice;

        do {
            System.out.println();
            System.out.println("============== MEDICAL MENU ==============");
            System.out.println("1. Add New Medical");
            System.out.println("2. Display Medical");
            System.out.println("3. Return to Main Menu");
            System.out.println("==========================================");
            System.out.print("Enter your choice: ");

            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine();

                switch (choice) {

                    case 1:
                        addMedical();
                        break;

                    case 2:
                        displayMedicals();
                        break;

                    case 3:
                        System.out.println("Returning to Main Menu...");
                        break;

                    default:
                        System.out.println(
                            "Invalid choice! Please enter a number from 1 to 3."
                        );
                }

            } else {
                System.out.println(
                    "Invalid input! Please enter a number from 1 to 3."
                );
                input.nextLine();
                choice = 0;
            }

        } while (choice != 3);
    }


    // Add a new medical record to the array
    private void addMedical() {

        if (medicalCount >= medicals.length) {
            System.out.println("Medical list is full. Cannot add more medical records.");
            return;
        }

        Medical medical = new Medical("", "", "", 0, 0);

        medical.newMedical(input);

        medicals[medicalCount] = medical;
        medicalCount++;

        System.out.println("Medical added successfully!");
    }


    // Display all existing medical records
    private void displayMedicals() {

        if (medicalCount == 0) {
            System.out.println("No medical records available.");
            return;
        }

        System.out.println();
        System.out.println("==================== MEDICAL ====================");
        System.out.printf(
            "%-20s %-20s %-20s %-10s%n",
            "Name", "Manufacturer", "Expiry Date", "Cost"
        );
        System.out.println("--------------------------------------------------------------------------");

        for (int i = 0; i < medicalCount; i++) {
            medicals[i].findMedical();
        }

        System.out.println("--------------------------------------------------------------------------");
    }
    
 // Display the Laboratory menu
    private void laboratoryMenu() {
        int choice;

        do {
            System.out.println();
            System.out.println("============== LABORATORY MENU ==============");
            System.out.println("1. Add New Laboratory");
            System.out.println("2. Display Laboratories");
            System.out.println("3. Return to Main Menu");
            System.out.println("=============================================");
            System.out.print("Enter your choice: ");

            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine();

                switch (choice) {

                    case 1:
                        addLaboratory();
                        break;

                    case 2:
                        displayLaboratories();
                        break;

                    case 3:
                        System.out.println("Returning to Main Menu...");
                        break;

                    default:
                        System.out.println(
                            "Invalid choice! Please enter a number from 1 to 3."
                        );
                }

            } else {
                System.out.println(
                    "Invalid input! Please enter a number from 1 to 3."
                );
                input.nextLine();
                choice = 0;
            }

        } while (choice != 3);
    }


    // Add a new laboratory to the array
    private void addLaboratory() {

        if (laboratoryCount >= laboratories.length) {
            System.out.println("Laboratory list is full. Cannot add more laboratories.");
            return;
        }

        Lab laboratory = new Lab("", 0);

        laboratory.newLab(input);

        laboratories[laboratoryCount] = laboratory;
        laboratoryCount++;

        System.out.println("Laboratory added successfully!");
    }


    // Display all existing laboratories
    private void displayLaboratories() {

        if (laboratoryCount == 0) {
            System.out.println("No laboratories available.");
            return;
        }

        System.out.println();
        System.out.println("==================== LABORATORIES ====================");
        System.out.printf(
            "%-25s %-10s%n",
            "Laboratory", "Cost"
        );
        System.out.println("-------------------------------------------------------");

        for (int i = 0; i < laboratoryCount; i++) {
            laboratories[i].labList();
        }

        System.out.println("-------------------------------------------------------");
    }
    
 // Display the Facility menu
    private void facilityMenu() {
        int choice;

        do {
            System.out.println();
            System.out.println("============== FACILITY MENU ==============");
            System.out.println("1. Add New Facility");
            System.out.println("2. Display Facilities");
            System.out.println("3. Return to Main Menu");
            System.out.println("===========================================");
            System.out.print("Enter your choice: ");

            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine();

                switch (choice) {

                    case 1:
                        addFacility();
                        break;

                    case 2:
                        displayFacilities();
                        break;

                    case 3:
                        System.out.println("Returning to Main Menu...");
                        break;

                    default:
                        System.out.println(
                            "Invalid choice! Please enter a number from 1 to 3."
                        );
                }

            } else {
                System.out.println(
                    "Invalid input! Please enter a number from 1 to 3."
                );
                input.nextLine();
                choice = 0;
            }

        } while (choice != 3);
    }


    // Add a new facility to the array
    private void addFacility() {

        if (facilityCount >= facilities.length) {
            System.out.println("Facility list is full. Cannot add more facilities.");
            return;
        }

        Facility facility = new Facility("");

        facility.newFacility(input);

        facilities[facilityCount] = facility;
        facilityCount++;

        System.out.println("Facility added successfully!");
    }


    // Display all existing facilities
    private void displayFacilities() {

        if (facilityCount == 0) {
            System.out.println("No facilities available.");
            return;
        }

        System.out.println();
        System.out.println("==================== FACILITIES ====================");
        System.out.printf("%-25s%n", "Facility");
        System.out.println("-----------------------------------------");

        for (int i = 0; i < facilityCount; i++) {
            facilities[i].showFacility();
        }

        System.out.println("-----------------------------------------");
    }
    
 // Display the Staff menu
    private void staffMenu() {
        int choice;

        do {
            System.out.println();
            System.out.println("============== STAFF MENU ==============");
            System.out.println("1. Add New Staff");
            System.out.println("2. Display Staff");
            System.out.println("3. Return to Main Menu");
            System.out.println("========================================");
            System.out.print("Enter your choice: ");

            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine();

                switch (choice) {

                    case 1:
                        addStaff();
                        break;

                    case 2:
                        displayStaff();
                        break;

                    case 3:
                        System.out.println("Returning to Main Menu...");
                        break;

                    default:
                        System.out.println(
                            "Invalid choice! Please enter a number from 1 to 3."
                        );
                }

            } else {
                System.out.println(
                    "Invalid input! Please enter a number from 1 to 3."
                );
                input.nextLine();
                choice = 0;
            }

        } while (choice != 3);
    }


    // Add a new staff member to the array
    private void addStaff() {

        if (staffCount >= staffs.length) {
            System.out.println("Staff list is full. Cannot add more staff.");
            return;
        }

        Staff staff = new Staff("", "", "", "", 0);

        staff.newStaff(input);

        staffs[staffCount] = staff;
        staffCount++;

        System.out.println("Staff added successfully!");
    }


    // Display all existing staff
    private void displayStaff() {

        if (staffCount == 0) {
            System.out.println("No staff available.");
            return;
        }

        System.out.println();
        System.out.println("==================== STAFF ====================");
        System.out.printf(
            "%-10s %-20s %-15s %-10s %-10s%n",
            "ID", "Name", "Designation", "Sex", "Salary"
        );
        System.out.println("--------------------------------------------------------------------");

        for (int i = 0; i < staffCount; i++) {
            staffs[i].showStaffInfo();
        }

        System.out.println("--------------------------------------------------------------------");
    }
    
    private void showDoctorGUI(Stage stage) {

        Label title = new Label("Doctor Management");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        Button displayButton = new Button("Display Doctors");
        Button addButton = new Button("Add New Doctor");
        Button backButton = new Button("Back to Main Menu");

        TextArea doctorArea = new TextArea();
        doctorArea.setEditable(false);
        doctorArea.setPrefHeight(250);
        doctorArea.setPrefWidth(700);
        doctorArea.setStyle(
            "-fx-font-family: 'Monospaced'; -fx-font-size: 13px;"
        );

        // Display existing doctors
        displayButton.setOnAction(e -> {

            StringBuilder output = new StringBuilder();

            output.append(String.format(
                "%-8s %-22s %-22s %-15s %-20s %-8s%n",
                "ID",
                "Name",
                "Specialist",
                "Work Time",
                "Qualification",
                "Room"
            ));

            output.append(
                "-------------------------------------------------------------------------------------------------\n"
            );

            for (int i = 0; i < doctorCount; i++) {

                Doctor doctor = doctors[i];

                output.append(String.format(
                    "%-8s %-22s %-22s %-15s %-20s %-8d%n",
                    doctor.getId(),
                    doctor.getName(),
                    doctor.getSpecialist(),
                    doctor.getWorkTime(),
                    doctor.getQualification(),
                    doctor.getRoom()
                ));
            }

            doctorArea.setText(output.toString());
        });

        // Add new doctor
        addButton.setOnAction(e -> showAddDoctorGUI(stage));

        // Return to main menu
        backButton.setOnAction(e -> showMainMenu(stage));

        VBox buttonLayout = new VBox(
            10,
            displayButton,
            addButton,
            backButton
        );

        buttonLayout.setAlignment(Pos.CENTER);

        VBox layout = new VBox(
            15,
            title,
            buttonLayout,
            doctorArea
        );

        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(25));

        Scene scene = new Scene(layout, 850, 500);

        stage.setTitle("Doctor Management");
        stage.setScene(scene);
    }
    
    private void showAddDoctorGUI(Stage stage) {

        Label title = new Label("Add New Doctor");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Input fields
        TextField idField = new TextField();
        setupExampleField(idField, "Example: 389");

        TextField nameField = new TextField();
        setupExampleField(nameField, "Example: Dr. Soo Joe Yong");

        TextField specialistField = new TextField();
        setupExampleField(specialistField, "Example: Cardiologist");

        TextField workTimeField = new TextField();
        setupExampleField(workTimeField, "Example: 8-11AM");

        TextField qualificationField = new TextField();
        setupExampleField(qualificationField, "Example: MBBS, MD");

        TextField roomField = new TextField();
        setupExampleField(roomField, "Example: 13");
        
        // Set input field width
        TextField[] fields = {
            idField,
            nameField,
            specialistField,
            workTimeField,
            qualificationField,
            roomField
        };

        for (TextField field : fields) {
            field.setPrefWidth(250);
        }

        // Create labels
        Label idLabel = new Label("Doctor ID:");
        Label nameLabel = new Label("Doctor Name:");
        Label specialistLabel = new Label("Specialization:");
        Label workTimeLabel = new Label("Work Time:");
        Label qualificationLabel = new Label("Qualification:");
        Label roomLabel = new Label("Room Number:");

        // Set label widths so all fields align
        Label[] labels = {
            idLabel,
            nameLabel,
            specialistLabel,
            workTimeLabel,
            qualificationLabel,
            roomLabel
        };

        for (Label label : labels) {
            label.setPrefWidth(120);
        }

        // Create rows
        HBox idRow = new HBox(10, idLabel, idField);
        HBox nameRow = new HBox(10, nameLabel, nameField);
        HBox specialistRow = new HBox(10, specialistLabel, specialistField);
        HBox workTimeRow = new HBox(10, workTimeLabel, workTimeField);
        HBox qualificationRow = new HBox(10, qualificationLabel, qualificationField);
        HBox roomRow = new HBox(10, roomLabel, roomField);

        // Align rows
        idRow.setAlignment(Pos.CENTER);
        nameRow.setAlignment(Pos.CENTER);
        specialistRow.setAlignment(Pos.CENTER);
        workTimeRow.setAlignment(Pos.CENTER);
        qualificationRow.setAlignment(Pos.CENTER);
        roomRow.setAlignment(Pos.CENTER);

        // Buttons
        Button addButton = new Button("Add Doctor");
        Button backButton = new Button("Back");

        addButton.setPrefWidth(150);
        backButton.setPrefWidth(150);

        // Add Doctor button
        addButton.setOnAction(e -> {

            if (doctorCount >= doctors.length) {
                showAlert(
                    AlertType.ERROR,
                    "Error",
                    "Doctor list is full. Cannot add more doctors."
                );
                return;
            }

            String id = getFieldValue(idField);
            String name = getFieldValue(nameField);
            String specialist = getFieldValue(specialistField);
            String workTime = getFieldValue(workTimeField);
            String qualification = getFieldValue(qualificationField);
            String roomText = getFieldValue(roomField);

            // Check for empty fields
            if (id.isEmpty() ||
                name.isEmpty() ||
                specialist.isEmpty() ||
                workTime.isEmpty() ||
                qualification.isEmpty() ||
                roomText.isEmpty()) {

                showAlert(
                    AlertType.ERROR,
                    "Invalid Input",
                    "Please fill in all fields."
                );
                return;
            }
            
            // Validate Doctor ID
            if (!id.matches("\\d{3}")) {
                showAlert(
                    Alert.AlertType.ERROR,
                    "Invalid Doctor ID",
                    "Doctor ID must contain exactly 3 digits."
                );
                return;
            }

            // Validate Doctor Name
            if (!name.matches("[a-zA-Z. ]+")) {
                showAlert(
                    AlertType.ERROR,
                    "Invalid Name",
                    "Doctor name should contain letters only."
                );
                return;
            }

            // Validate Specialist
            if (!specialist.matches("[a-zA-Z ]+")) {
                showAlert(
                    AlertType.ERROR,
                    "Invalid Specialist",
                    "Specialization should contain letters only."
                );
                return;
            }

            // Validate Room Number
            int room;

            try {
                room = Integer.parseInt(roomText);

                if (room <= 0) {
                    showAlert(
                        AlertType.ERROR,
                        "Invalid Room Number",
                        "Room number must be greater than 0."
                    );
                    return;
                }

            } catch (NumberFormatException ex) {

                showAlert(
                    AlertType.ERROR,
                    "Invalid Room Number",
                    "Please enter a valid whole number for the room."
                );
                return;
            }

            // Create new Doctor object
            Doctor doctor = new Doctor(
                id,
                name,
                specialist,
                workTime,
                qualification,
                room
            );

            // Store Doctor in array
            doctors[doctorCount] = doctor;
            doctorCount++;

            showAlert(
                AlertType.INFORMATION,
                "Success",
                "Doctor added successfully!"
            );

            // Return to Doctor Management
            showDoctorGUI(stage);
        });

        // Back button
        backButton.setOnAction(e -> showDoctorGUI(stage));

        // Form layout
        VBox form = new VBox(
            12,
            idRow,
            nameRow,
            specialistRow,
            workTimeRow,
            qualificationRow,
            roomRow
        );

        form.setAlignment(Pos.CENTER);

        // Button layout
        VBox buttons = new VBox(
            10,
            addButton,
            backButton
        );

        buttons.setAlignment(Pos.CENTER);

        // Main layout
        VBox layout = new VBox(
            20,
            title,
            form,
            buttons
        );

        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(30));

        Scene scene = new Scene(layout, 550, 550);

        stage.setTitle("Add New Doctor");
        stage.setScene(scene);
    }


    private void showPatientGUI(Stage stage) {

        Label title = new Label("Patient Management");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        Button displayButton = new Button("Display Patients");
        Button addButton = new Button("Add New Patient");
        Button backButton = new Button("Back to Main Menu");

        TextArea output = new TextArea();
        output.setEditable(false);
        output.setPrefHeight(350);
        output.setStyle("-fx-font-family: monospace;");

        displayButton.setOnAction(e -> {

            output.clear();

            output.appendText(
                String.format(
                    "%-10s %-20s %-20s %-10s %-15s %-5s%n",
                    "ID", "Name", "Disease", "Sex", "Admit Status", "Age"
                )
            );

            output.appendText(
                "------------------------------------------------------------------------------------------\n"
            );

            for (int i = 0; i < patientCount; i++) {

                Patient patient = patients[i];

                output.appendText(
                    String.format(
                        "%-10s %-20s %-20s %-10s %-15s %-5d%n",
                        patient.getId(),
                        patient.getName(),
                        patient.getDisease(),
                        patient.getSex(),
                        patient.getAdmitStatus(),
                        patient.getAge()
                    )
                );
            }
        });

        addButton.setOnAction(e -> showAddPatientGUI(stage));

        backButton.setOnAction(e -> showMainMenu(stage));

        HBox buttons = new HBox(10, displayButton, addButton, backButton);
        buttons.setAlignment(Pos.CENTER);

        VBox layout = new VBox(15, title, buttons, output);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.TOP_CENTER);

        Scene scene = new Scene(layout, 800, 500);

        stage.setTitle("Patient Management");
        stage.setScene(scene);
        stage.show();
    }
    
    private void showAddPatientGUI(Stage stage) {

        Label title = new Label("Add New Patient");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Patient ID
        TextField idField = new TextField();
        setupExampleField(idField, "Example: 389");

        // Patient Name
        TextField nameField = new TextField();
        setupExampleField(nameField, "Example: Soo Joe Yong");

        // Disease
        TextField diseaseField = new TextField();
        setupExampleField(diseaseField, "Example: Fever");

        // Patient Sex
        ComboBox<String> sexBox = new ComboBox<>();
        sexBox.getItems().addAll("Male", "Female");
        sexBox.setPromptText("Select Sex");
        sexBox.setPrefWidth(250);

        // Admit Status
        ComboBox<String> admitStatusBox = new ComboBox<>();
        admitStatusBox.getItems().addAll(
            "inpatient",
            "outpatient",
            "observation",
            "discharged"
        );
        admitStatusBox.setPromptText("Select Admit Status");
        admitStatusBox.setPrefWidth(250);

        // Patient Age
        TextField ageField = new TextField();
        setupExampleField(ageField, "Example: 20");

        HBox idRow = new HBox(10, new Label("Patient ID:"), idField);
        HBox nameRow = new HBox(10, new Label("Patient Name:"), nameField);
        HBox diseaseRow = new HBox(10, new Label("Disease:"), diseaseField);
        HBox sexRow = new HBox(10, new Label("Patient Sex:"), sexBox);
        HBox admitStatusRow = new HBox(10, new Label("Admit Status:"), admitStatusBox);
        HBox ageRow = new HBox(10, new Label("Patient Age:"), ageField);

        // Set the same width for labels
        ((Label) idRow.getChildren().get(0)).setPrefWidth(120);
        ((Label) nameRow.getChildren().get(0)).setPrefWidth(120);
        ((Label) diseaseRow.getChildren().get(0)).setPrefWidth(120);
        ((Label) sexRow.getChildren().get(0)).setPrefWidth(120);
        ((Label) admitStatusRow.getChildren().get(0)).setPrefWidth(120);
        ((Label) ageRow.getChildren().get(0)).setPrefWidth(120);

        idField.setPrefWidth(250);
        nameField.setPrefWidth(250);
        diseaseField.setPrefWidth(250);
        ageField.setPrefWidth(250);

        Button addButton = new Button("Add Patient");
        Button backButton = new Button("Back");

        addButton.setOnAction(e -> {

            String id = getFieldValue(idField);
            String name = getFieldValue(nameField);
            String disease = getFieldValue(diseaseField);
            String sex = sexBox.getValue();
            String admitStatus = admitStatusBox.getValue();
            String ageText = getFieldValue(ageField);

            // Check for empty input
            if (id.isEmpty()
                    || name.isEmpty()
                    || disease.isEmpty()
                    || sex == null
                    || admitStatus == null
                    || ageText.isEmpty()) {

                showAlert(
                    Alert.AlertType.ERROR,
                    "Missing Information",
                    "Please fill in all patient information."
                );

                return;
            }

            // Validate Patient ID
            if (!id.matches("\\d{3}")) {

                showAlert(
                    Alert.AlertType.ERROR,
                    "Invalid Patient ID",
                    "Patient ID must contain exactly 3 digits."
                );

                return;
            }

            // Validate Patient Name
            if (!name.matches("[a-zA-Z. ]+")) {

                showAlert(
                    Alert.AlertType.ERROR,
                    "Invalid Patient Name",
                    "Patient name can only contain letters, spaces and periods."
                );

                return;
            }

            // Validate Age
            int age;

            try {

                age = Integer.parseInt(ageText);

                if (age < 0) {

                    showAlert(
                        Alert.AlertType.ERROR,
                        "Invalid Age",
                        "Patient age cannot be negative."
                    );

                    return;
                }

            } catch (NumberFormatException ex) {

                showAlert(
                    Alert.AlertType.ERROR,
                    "Invalid Age",
                    "Patient age must be a whole number."
                );

                return;
            }

            // Check array capacity
            if (patientCount >= patients.length) {

                showAlert(
                    Alert.AlertType.ERROR,
                    "Patient List Full",
                    "The maximum number of patients has been reached."
                );

                return;
            }

            // Create and store new Patient
            patients[patientCount] = new Patient(
                id,
                name,
                disease,
                sex,
                admitStatus,
                age
            );

            patientCount++;

            showAlert(
                Alert.AlertType.INFORMATION,
                "Patient Added",
                "Patient has been added successfully."
            );

            showPatientGUI(stage);
        });

        backButton.setOnAction(e -> showPatientGUI(stage));

        HBox buttons = new HBox(10, addButton, backButton);
        buttons.setAlignment(Pos.CENTER);

        VBox layout = new VBox(
            15,
            title,
            idRow,
            nameRow,
            diseaseRow,
            sexRow,
            admitStatusRow,
            ageRow,
            buttons
        );

        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.TOP_CENTER);

        Scene scene = new Scene(layout, 600, 500);

        stage.setTitle("Add New Patient");
        stage.setScene(scene);
        stage.show();
    }
    
    private void showMedicalGUI(Stage stage) {

        Label title = new Label("Medical Management");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        Button displayButton = new Button("Display Medical");
        Button addButton = new Button("Add New Medical");
        Button backButton = new Button("Back to Main Menu");

        TextArea output = new TextArea();
        output.setEditable(false);
        output.setPrefHeight(350);
        output.setPrefWidth(800);
        output.setStyle(
            "-fx-font-family: 'Monospaced'; -fx-font-size: 13px;"
        );

        // Display existing medical records
        displayButton.setOnAction(e -> {

            StringBuilder outputText = new StringBuilder();

            outputText.append(String.format(
                "%-20s %-20s %-20s %-10s%n",
                "Name",
                "Manufacturer",
                "Expiry Date",
                "Cost"
            ));

            outputText.append(
                "--------------------------------------------------------------------------\n"
            );

            for (int i = 0; i < medicalCount; i++) {

                Medical medical = medicals[i];

                outputText.append(String.format(
                    "%-20s %-20s %-20s %-10.2f%n",
                    medical.getName(),
                    medical.getManufacturer(),
                    medical.getExpiryDate(),
                    medical.getCost()
                ));
            }

            output.setText(outputText.toString());
        });

        // Add new medical record
        addButton.setOnAction(e -> showAddMedicalGUI(stage));

        // Return to main menu
        backButton.setOnAction(e -> showMainMenu(stage));

        HBox buttons = new HBox(
            10,
            displayButton,
            addButton,
            backButton
        );

        buttons.setAlignment(Pos.CENTER);

        VBox layout = new VBox(
            15,
            title,
            buttons,
            output
        );

        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(25));

        Scene scene = new Scene(layout, 850, 500);

        stage.setTitle("Medical Management");
        stage.setScene(scene);
        stage.show();
    }
    
    private void showAddMedicalGUI(Stage stage) {

        Label title = new Label("Add New Medical");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Input fields
        TextField nameField = new TextField();
        setupExampleField(nameField, "Example: Paracetamol");

        TextField manufacturerField = new TextField();
        setupExampleField(manufacturerField, "Example: GSK");

        DatePicker expiryDatePicker = new DatePicker();
        expiryDatePicker.setPromptText("Select expiry date");
        expiryDatePicker.setPrefWidth(250);

        TextField costField = new TextField();
        setupExampleField(costField, "Example: 10");

        TextField countField = new TextField();
        setupExampleField(countField, "Example: 100");

        // Set input field width
        TextField[] fields = {
            nameField,
            manufacturerField,
            costField,
            countField
        };

        for (TextField field : fields) {
            field.setPrefWidth(250);
        }

        // Create labels
        Label nameLabel = new Label("Medical Name:");
        Label manufacturerLabel = new Label("Manufacturer:");
        Label expiryDateLabel = new Label("Expiry Date:");
        Label costLabel = new Label("Cost:");
        Label countLabel = new Label("Number of Units:");

        // Set label widths so all fields align
        Label[] labels = {
            nameLabel,
            manufacturerLabel,
            expiryDateLabel,
            costLabel,
            countLabel
        };

        for (Label label : labels) {
            label.setPrefWidth(120);
        }

        // Create rows
        HBox nameRow = new HBox(10, nameLabel, nameField);
        HBox manufacturerRow = new HBox(10, manufacturerLabel, manufacturerField);
        HBox expiryDateRow = new HBox(10, expiryDateLabel, expiryDatePicker);
        HBox costRow = new HBox(10, costLabel, costField);
        HBox countRow = new HBox(10, countLabel, countField);

        // Align rows
        nameRow.setAlignment(Pos.CENTER);
        manufacturerRow.setAlignment(Pos.CENTER);
        expiryDateRow.setAlignment(Pos.CENTER);
        costRow.setAlignment(Pos.CENTER);
        countRow.setAlignment(Pos.CENTER);

        // Buttons
        Button addButton = new Button("Add Medical");
        Button backButton = new Button("Back");

        addButton.setPrefWidth(150);
        backButton.setPrefWidth(150);

        // Add Medical button
        addButton.setOnAction(e -> {

            if (medicalCount >= medicals.length) {

                showAlert(
                    AlertType.ERROR,
                    "Error",
                    "Medical list is full. Cannot add more medical records."
                );

                return;
            }

            String name = getFieldValue(nameField);
            String manufacturer = getFieldValue(manufacturerField);
            LocalDate selectedDate = expiryDatePicker.getValue();
            String costText = getFieldValue(costField);
            String countText = getFieldValue(countField);

	         // Check for empty fields
	            if (name.isEmpty()
	                    || manufacturer.isEmpty()
	                    || selectedDate == null
	                    || costText.isEmpty()
	                    || countText.isEmpty()) {
	
	                showAlert(
	                    AlertType.ERROR,
	                    "Invalid Input",
	                    "Please fill in all fields."
	                );
	
	                return;
	            }
	            
	            // Validate Medical Name
	            if (!name.matches("[a-zA-Z ]+")) {

	                showAlert(
	                    AlertType.ERROR,
	                    "Invalid Medical Name",
	                    "Medical name should contain letters and spaces only."
	                );

	                return;
	            }

	            // Validate Manufacturer
	            if (!manufacturer.matches("[a-zA-Z ]+")) {

	                showAlert(
	                    AlertType.ERROR,
	                    "Invalid Manufacturer",
	                    "Manufacturer should contain letters and spaces only."
	                );

	                return;
	            }
	
	            // Convert selected date to dd/MM/yyyy format
	            String expiryDate =
	                selectedDate.format(
	                    DateTimeFormatter.ofPattern("dd/MM/yyyy")
	                );

            // Validate cost
            int cost;

            try {

                cost = Integer.parseInt(costText);

                if (cost < 0) {

                    showAlert(
                        AlertType.ERROR,
                        "Invalid Cost",
                        "Cost cannot be negative."
                    );

                    return;
                }

            } catch (NumberFormatException ex) {

                showAlert(
                    AlertType.ERROR,
                    "Invalid Cost",
                    "Please enter a valid number for the cost."
                );

                return;
            }

            // Validate number of units
            int count;

            try {

                count = Integer.parseInt(countText);

                if (count < 0) {

                    showAlert(
                        AlertType.ERROR,
                        "Invalid Number of Units",
                        "Number of units cannot be negative."
                    );

                    return;
                }

            } catch (NumberFormatException ex) {

                showAlert(
                    AlertType.ERROR,
                    "Invalid Number of Units",
                    "Please enter a valid whole number."
                );

                return;
            }

            // Create new Medical object
            Medical medical = new Medical(
                name,
                manufacturer,
                expiryDate,
                cost,
                count
            );

            // Store Medical in array
            medicals[medicalCount] = medical;
            medicalCount++;

            showAlert(
                AlertType.INFORMATION,
                "Success",
                "Medical record added successfully!"
            );

            // Return to Medical Management
            showMedicalGUI(stage);
        });

        // Back button
        backButton.setOnAction(e -> showMedicalGUI(stage));

        // Form layout
        VBox form = new VBox(
            12,
            nameRow,
            manufacturerRow,
            expiryDateRow,
            costRow,
            countRow
        );

        form.setAlignment(Pos.CENTER);

        // Button layout
        VBox buttons = new VBox(
            10,
            addButton,
            backButton
        );

        buttons.setAlignment(Pos.CENTER);

        // Main layout
        VBox layout = new VBox(
            20,
            title,
            form,
            buttons
        );

        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(30));

        Scene scene = new Scene(layout, 550, 500);

        stage.setTitle("Add New Medical");
        stage.setScene(scene);
        stage.show();
    }


    private void showLaboratoryGUI(Stage stage) {

        Label title = new Label("Laboratory Management");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        Button displayButton = new Button("Display Laboratories");
        Button addButton = new Button("Add New Laboratory");
        Button backButton = new Button("Back to Main Menu");

        TextArea output = new TextArea();
        output.setEditable(false);
        output.setPrefHeight(350);
        output.setPrefWidth(700);
        output.setStyle(
            "-fx-font-family: 'Monospaced'; -fx-font-size: 13px;"
        );

        // Display existing laboratories
        displayButton.setOnAction(e -> {

            StringBuilder outputText = new StringBuilder();

            outputText.append(String.format(
                "%-25s %-10s%n",
                "Laboratory",
                "Cost"
            ));

            outputText.append(
                "-------------------------------------------------------\n"
            );

            for (int i = 0; i < laboratoryCount; i++) {

                Lab laboratory = laboratories[i];

                outputText.append(String.format(
                    "%-25s %-10.2f%n",
                    laboratory.getLab(),
                    laboratory.getCost()
                ));
            }

            output.setText(outputText.toString());
        });

        // Add new laboratory
        addButton.setOnAction(e -> showAddLaboratoryGUI(stage));

        // Return to main menu
        backButton.setOnAction(e -> showMainMenu(stage));

        HBox buttons = new HBox(
            10,
            displayButton,
            addButton,
            backButton
        );

        buttons.setAlignment(Pos.CENTER);

        VBox layout = new VBox(
            15,
            title,
            buttons,
            output
        );

        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(25));

        Scene scene = new Scene(layout, 750, 500);

        stage.setTitle("Laboratory Management");
        stage.setScene(scene);
        stage.show();
    }
    
    private void showAddLaboratoryGUI(Stage stage) {

        Label title = new Label("Add New Laboratory");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Laboratory Name
        TextField labField = new TextField();
        setupExampleField(
            labField,
            "Example: Pathology Lab"
        );

        // Cost
        TextField costField = new TextField();
        setupExampleField(
            costField,
            "Example: 250"
        );

        // Set input field width
        labField.setPrefWidth(250);
        costField.setPrefWidth(250);

        // Create labels
        Label labLabel = new Label("Laboratory Name:");
        Label costLabel = new Label("Cost:");

        // Set label widths so fields align
        labLabel.setPrefWidth(120);
        costLabel.setPrefWidth(120);

        // Create rows
        HBox labRow = new HBox(
            10,
            labLabel,
            labField
        );

        HBox costRow = new HBox(
            10,
            costLabel,
            costField
        );

        // Align rows
        labRow.setAlignment(Pos.CENTER);
        costRow.setAlignment(Pos.CENTER);

        // Buttons
        Button addButton = new Button("Add Laboratory");
        Button backButton = new Button("Back");

        addButton.setPrefWidth(150);
        backButton.setPrefWidth(150);

        // Add Laboratory button
        addButton.setOnAction(e -> {

            // Check array capacity
            if (laboratoryCount >= laboratories.length) {

                showAlert(
                    AlertType.ERROR,
                    "Laboratory List Full",
                    "The maximum number of laboratories has been reached."
                );

                return;
            }

            String lab = getFieldValue(labField);
            String costText = getFieldValue(costField);

            // Check for empty fields
            if (lab.isEmpty() || costText.isEmpty()) {

                showAlert(
                    AlertType.ERROR,
                    "Invalid Input",
                    "Please fill in all fields."
                );

                return;
            }

            // Validate Laboratory Name
            if (!lab.matches("[a-zA-Z ]+")) {

                showAlert(
                    AlertType.ERROR,
                    "Invalid Laboratory Name",
                    "Laboratory name should contain letters and spaces only."
                );

                return;
            }

            // Validate Cost
            int cost;

            try {

                cost = Integer.parseInt(costText);

                if (cost < 0) {

                    showAlert(
                        AlertType.ERROR,
                        "Invalid Cost",
                        "Cost cannot be negative."
                    );

                    return;
                }

            } catch (NumberFormatException ex) {

                showAlert(
                    AlertType.ERROR,
                    "Invalid Cost",
                    "Please enter a valid number for the cost."
                );

                return;
            }

            // Create new Lab object
            Lab laboratory = new Lab(
                lab,
                cost
            );

            // Store laboratory in array
            laboratories[laboratoryCount] = laboratory;
            laboratoryCount++;

            showAlert(
                AlertType.INFORMATION,
                "Success",
                "Laboratory added successfully!"
            );

            // Return to Laboratory Management
            showLaboratoryGUI(stage);
        });

        // Back button
        backButton.setOnAction(e -> showLaboratoryGUI(stage));

        // Form layout
        VBox form = new VBox(
            12,
            labRow,
            costRow
        );

        form.setAlignment(Pos.CENTER);

        // Button layout
        VBox buttons = new VBox(
            10,
            addButton,
            backButton
        );

        buttons.setAlignment(Pos.CENTER);

        // Main layout
        VBox layout = new VBox(
            20,
            title,
            form,
            buttons
        );

        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(30));

        Scene scene = new Scene(layout, 550, 350);

        stage.setTitle("Add New Laboratory");
        stage.setScene(scene);
        stage.show();
    }


    private void showFacilityGUI(Stage stage) {

        Label title = new Label("Facility Management");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        Button displayButton = new Button("Display Facilities");
        Button addButton = new Button("Add New Facility");
        Button backButton = new Button("Back to Main Menu");

        TextArea output = new TextArea();
        output.setEditable(false);
        output.setPrefHeight(350);
        output.setPrefWidth(700);
        output.setStyle(
            "-fx-font-family: 'Monospaced'; -fx-font-size: 13px;"
        );

        // Display existing facilities
        displayButton.setOnAction(e -> {

            StringBuilder outputText = new StringBuilder();

            outputText.append(
                String.format("%-30s%n", "Facility")
            );

            outputText.append(
                "-----------------------------------------\n"
            );

            for (int i = 0; i < facilityCount; i++) {

                Facility facility = facilities[i];

                outputText.append(
                    String.format(
                        "%-30s%n",
                        facility.getFacility()
                    )
                );
            }

            output.setText(outputText.toString());
        });

        // Add new facility
        addButton.setOnAction(e -> showAddFacilityGUI(stage));

        // Return to main menu
        backButton.setOnAction(e -> showMainMenu(stage));

        HBox buttons = new HBox(
            10,
            displayButton,
            addButton,
            backButton
        );

        buttons.setAlignment(Pos.CENTER);

        VBox layout = new VBox(
            15,
            title,
            buttons,
            output
        );

        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(25));

        Scene scene = new Scene(layout, 750, 500);

        stage.setTitle("Facility Management");
        stage.setScene(scene);
        stage.show();
    }
    
    private void showAddFacilityGUI(Stage stage) {

        Label title = new Label("Add New Facility");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Facility Name
        TextField facilityField = new TextField();
        setupExampleField(
            facilityField,
            "Example: Emergency Room"
        );

        facilityField.setPrefWidth(250);

        // Create label
        Label facilityLabel = new Label("Facility Name:");
        facilityLabel.setPrefWidth(120);

        // Create row
        HBox facilityRow = new HBox(
            10,
            facilityLabel,
            facilityField
        );

        facilityRow.setAlignment(Pos.CENTER);

        // Buttons
        Button addButton = new Button("Add Facility");
        Button backButton = new Button("Back");

        addButton.setPrefWidth(150);
        backButton.setPrefWidth(150);

        // Add Facility button
        addButton.setOnAction(e -> {

            // Check array capacity
            if (facilityCount >= facilities.length) {

                showAlert(
                    AlertType.ERROR,
                    "Facility List Full",
                    "The maximum number of facilities has been reached."
                );

                return;
            }

            String facilityName = getFieldValue(facilityField);

            // Check for empty input
            if (facilityName.isEmpty()) {

                showAlert(
                    AlertType.ERROR,
                    "Invalid Input",
                    "Please enter a facility name."
                );

                return;
            }

            // Validate Facility Name
            if (!facilityName.matches("[a-zA-Z ]+")) {

                showAlert(
                    AlertType.ERROR,
                    "Invalid Facility Name",
                    "Facility name should contain letters and spaces only."
                );

                return;
            }

            // Create new Facility object
            Facility facility = new Facility(
                facilityName
            );

            // Store facility in array
            facilities[facilityCount] = facility;
            facilityCount++;

            showAlert(
                AlertType.INFORMATION,
                "Success",
                "Facility added successfully!"
            );

            // Return to Facility Management
            showFacilityGUI(stage);
        });

        // Back button
        backButton.setOnAction(e -> showFacilityGUI(stage));

        // Button layout
        VBox buttons = new VBox(
            10,
            addButton,
            backButton
        );

        buttons.setAlignment(Pos.CENTER);

        // Main layout
        VBox layout = new VBox(
            20,
            title,
            facilityRow,
            buttons
        );

        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(30));

        Scene scene = new Scene(layout, 550, 300);

        stage.setTitle("Add New Facility");
        stage.setScene(scene);
        stage.show();
    }


    private void showStaffGUI(Stage stage) {

        Label title = new Label("Staff Management");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        Button displayButton = new Button("Display Staff");
        Button addButton = new Button("Add New Staff");
        Button backButton = new Button("Back to Main Menu");

        TextArea output = new TextArea();
        output.setEditable(false);
        output.setPrefHeight(350);
        output.setPrefWidth(750);
        output.setStyle(
            "-fx-font-family: 'Monospaced'; -fx-font-size: 13px;"
        );

        // Display existing staff
        displayButton.setOnAction(e -> {

            StringBuilder outputText = new StringBuilder();

            outputText.append(String.format(
                "%-10s %-20s %-15s %-10s %-10s%n",
                "ID",
                "Name",
                "Designation",
                "Sex",
                "Salary"
            ));

            outputText.append(
                "----------------------------------------------------------------\n"
            );

            for (int i = 0; i < staffCount; i++) {

                Staff staff = staffs[i];

                outputText.append(String.format(
                    "%-10s %-20s %-15s %-10s %-10d%n",
                    staff.getId(),
                    staff.getName(),
                    staff.getDesignation(),
                    staff.getSex(),
                    staff.getSalary()
                ));
            }

            output.setText(outputText.toString());
        });

        // Add new staff
        addButton.setOnAction(e -> showAddStaffGUI(stage));

        // Return to main menu
        backButton.setOnAction(e -> showMainMenu(stage));

        HBox buttons = new HBox(
            10,
            displayButton,
            addButton,
            backButton
        );

        buttons.setAlignment(Pos.CENTER);

        VBox layout = new VBox(
            15,
            title,
            buttons,
            output
        );

        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(25));

        Scene scene = new Scene(layout, 800, 500);

        stage.setTitle("Staff Management");
        stage.setScene(scene);
        stage.show();
    }
    
    private void showAddStaffGUI(Stage stage) {

        Label title = new Label("Add New Staff");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Staff ID
        TextField idField = new TextField();
        setupExampleField(
            idField,
            "Example: 389"
        );

        // Staff Name
        TextField nameField = new TextField();
        setupExampleField(
            nameField,
            "Example: Soo Joe Yong"
        );

        // Designation
        TextField designationField = new TextField();
        setupExampleField(
            designationField,
            "Example: Administrator"
        );

        // Staff Sex
        ComboBox<String> sexBox = new ComboBox<>();
        sexBox.getItems().addAll(
            "Male",
            "Female"
        );
        sexBox.setPromptText("Select Sex");
        sexBox.setPrefWidth(250);

        // Salary
        TextField salaryField = new TextField();
        setupExampleField(
            salaryField,
            "Example: 3500"
        );

        // Set input field width
        idField.setPrefWidth(250);
        nameField.setPrefWidth(250);
        designationField.setPrefWidth(250);
        salaryField.setPrefWidth(250);

        // Create labels
        Label idLabel = new Label("Staff ID:");
        Label nameLabel = new Label("Staff Name:");
        Label designationLabel = new Label("Designation:");
        Label sexLabel = new Label("Staff Sex:");
        Label salaryLabel = new Label("Salary:");

        // Set label widths so fields align
        idLabel.setPrefWidth(120);
        nameLabel.setPrefWidth(120);
        designationLabel.setPrefWidth(120);
        sexLabel.setPrefWidth(120);
        salaryLabel.setPrefWidth(120);

        // Create rows
        HBox idRow = new HBox(
            10,
            idLabel,
            idField
        );

        HBox nameRow = new HBox(
            10,
            nameLabel,
            nameField
        );

        HBox designationRow = new HBox(
            10,
            designationLabel,
            designationField
        );

        HBox sexRow = new HBox(
            10,
            sexLabel,
            sexBox
        );

        HBox salaryRow = new HBox(
            10,
            salaryLabel,
            salaryField
        );

        // Align rows
        idRow.setAlignment(Pos.CENTER);
        nameRow.setAlignment(Pos.CENTER);
        designationRow.setAlignment(Pos.CENTER);
        sexRow.setAlignment(Pos.CENTER);
        salaryRow.setAlignment(Pos.CENTER);

        // Buttons
        Button addButton = new Button("Add Staff");
        Button backButton = new Button("Back");

        addButton.setPrefWidth(150);
        backButton.setPrefWidth(150);

        // Add Staff button
        addButton.setOnAction(e -> {

            // Check array capacity
            if (staffCount >= staffs.length) {

                showAlert(
                    AlertType.ERROR,
                    "Staff List Full",
                    "The maximum number of staff members has been reached."
                );

                return;
            }

            String id = getFieldValue(idField);
            String name = getFieldValue(nameField);
            String designation = getFieldValue(designationField);
            String sex = sexBox.getValue();
            String salaryText = getFieldValue(salaryField);

            // Check for empty fields
            if (id.isEmpty()
                    || name.isEmpty()
                    || designation.isEmpty()
                    || sex == null
                    || salaryText.isEmpty()) {

                showAlert(
                    AlertType.ERROR,
                    "Invalid Input",
                    "Please fill in all staff information."
                );

                return;
            }

            // Validate Staff ID
            if (!id.matches("\\d{3}")) {

                showAlert(
                    AlertType.ERROR,
                    "Invalid Staff ID",
                    "Staff ID must contain exactly 3 digits."
                );

                return;
            }

            // Validate Staff Name
            if (!name.matches("[a-zA-Z. ]+")) {

                showAlert(
                    AlertType.ERROR,
                    "Invalid Staff Name",
                    "Staff name can only contain letters, spaces and periods."
                );

                return;
            }

            // Validate Designation
            if (!designation.matches("[a-zA-Z ]+")) {

                showAlert(
                    AlertType.ERROR,
                    "Invalid Designation",
                    "Designation should contain letters and spaces only."
                );

                return;
            }

            // Validate Salary
            int salary;

            try {

                salary = Integer.parseInt(salaryText);

                if (salary <= 0) {

                    showAlert(
                        AlertType.ERROR,
                        "Invalid Salary",
                        "Salary must be greater than 0."
                    );

                    return;
                }

            } catch (NumberFormatException ex) {

                showAlert(
                    AlertType.ERROR,
                    "Invalid Salary",
                    "Please enter a valid whole number for the salary."
                );

                return;
            }

            // Create new Staff object
            Staff staff = new Staff(
                id,
                name,
                designation,
                sex,
                salary
            );

            // Store staff in array
            staffs[staffCount] = staff;
            staffCount++;

            showAlert(
                AlertType.INFORMATION,
                "Success",
                "Staff member added successfully!"
            );

            // Return to Staff Management
            showStaffGUI(stage);
        });

        // Back button
        backButton.setOnAction(e -> showStaffGUI(stage));

        // Form layout
        VBox form = new VBox(
            12,
            idRow,
            nameRow,
            designationRow,
            sexRow,
            salaryRow
        );

        form.setAlignment(Pos.CENTER);

        // Button layout
        VBox buttons = new VBox(
            10,
            addButton,
            backButton
        );

        buttons.setAlignment(Pos.CENTER);

        // Main layout
        VBox layout = new VBox(
            20,
            title,
            form,
            buttons
        );

        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(30));

        Scene scene = new Scene(layout, 550, 500);

        stage.setTitle("Add New Staff");
        stage.setScene(scene);
        stage.show();
    }
    
    private void showAlert(AlertType type, String title, String message) {

        Alert alert = new Alert(type);

        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }
    
    private void setupExampleField(TextField field, String example) {

        field.setText(example);
        field.setStyle("-fx-text-fill: gray;");
        field.setUserData(true);

        field.setOnMouseClicked(e -> {

            if (Boolean.TRUE.equals(field.getUserData())) {
                field.selectAll();
            }
        });

        field.setOnKeyPressed(e -> {

            if (Boolean.TRUE.equals(field.getUserData())) {

                // If user presses a key that can enter text,
                // remove the example first.
                if (e.getCode().isLetterKey()
                        || e.getCode().isDigitKey()
                        || e.getCode().toString().equals("SPACE")
                        || e.getCode().toString().equals("PERIOD")
                        || e.getCode().toString().equals("COMMA")
                        || e.getCode().toString().equals("MINUS")) {

                    field.clear();
                    field.setUserData(false);
                    field.setStyle("-fx-text-fill: black;");
                }
            }
        });

        field.focusedProperty().addListener((observable, oldValue, focused) -> {

            if (focused && Boolean.TRUE.equals(field.getUserData())) {

                field.selectAll();

            } else if (!focused && field.getText().trim().isEmpty()) {

                field.setText(example);
                field.setUserData(true);
                field.setStyle("-fx-text-fill: gray;");
            }
        });
    }
    
    private String getFieldValue(TextField field) {

        if (Boolean.TRUE.equals(field.getUserData())) {
            return "";
        }

        return field.getText().trim();
    }
}