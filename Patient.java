import java.util.Scanner;
import java.util.Arrays;

public class Patient {
	//declare variables
	private String id;
	private String name;
	private String disease;
	private String sex;
	private String admitStatus;
	private int age;
	private final String [] fullAdmitStatus = {"inpatient", "outpatient", "observation", "discharged"};
	
	//constructor
	public Patient(String id, String name, String disease, String sex, String admitStatus, int age) {
		this.id = id;
		this.name = name;
		this.disease = disease;
		this.sex = sex;
		this.admitStatus = admitStatus;
		this.age = age;
	}
	
	//accessor and mutator
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDisease() {
		return disease;
	}
	
	public void setDisease(String disease) {
		this.disease = disease;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getAdmitStatus() {
		return admitStatus;
	}
	
	public void setAdmitStatus(String admitStatus) {
		this.admitStatus = admitStatus;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	//input new patient info
	public void newPatient(Scanner input) {
		System.out.println("Enter Patient ID: ");
		id = input.nextLine().trim();

		System.out.println("Enter Patient Name: ");
		name = input.nextLine().trim();

		System.out.println("Enter Patient Disease: ");
		disease = input.nextLine().trim();
		
		while (true) {
			System.out.println("Enter Patient Sex (Male/Female): ");
			sex = input.nextLine().trim();

			//validate input
			if (sex.equalsIgnoreCase("male") || sex.equalsIgnoreCase("female"))
				break;
			else
				System.out.println("Please enter either Male or Female.");
		}
		
		while (true) {
			System.out.println("Enter Patient Admit Status [inpatient/outpatient/observation/discharged]: ");
			admitStatus = input.nextLine().trim();

			//validate input
			if (Arrays.asList(fullAdmitStatus).contains(admitStatus.toLowerCase()))
				break;
			else
				System.out.println("Please enter a valid status.");
		}
		
		while (true) {
			System.out.println("Enter Patient Age: ");

			//validate input
			if (input.hasNextInt()) {
				age = input.nextInt();
				input.nextLine(); // consume newline

				//exit when age is correct
				if (age >= 0)
					break;
				else 
					System.out.println("Please enter a positive whole number as age.");
			}
			else {
				System.out.println("Please enter a valid whole number.");
				input.nextLine(); // clear invalid input
			}
		}
	}
	
	//show patient info
	public void showPatientInfo() {
		System.out.printf(
			"%-10s %-20s %-15s %-10s %-15s %-5d%n",
			id, name, disease, sex, admitStatus, age
		);
	}
}