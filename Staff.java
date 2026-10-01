import java.util.Scanner;
import java.util.InputMismatchException;

public class Staff {
	private String id;
	private String name;
	private String designation;
	private String sex;
	private int salary;
	
	public Staff(String id, String name, String designation, String sex, int salary){
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.sex = sex;
		this.salary = salary;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDesignation() {
		return designation;
	}
	
	public String getSex() {
		return sex;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void newStaff(Scanner input) {
		System.out.println("Enter Staff ID: ");
		id = input.nextLine();

		System.out.println("Enter Staff Name: ");
		name = input.nextLine();

		System.out.println("Enter Designation: ");
		designation = input.nextLine();

		while (true) {
		    System.out.println("Enter Staff Sex (Male/Female): ");
		    sex = input.nextLine().trim();

		    // Validate input
		    if (sex.equalsIgnoreCase("male") || sex.equalsIgnoreCase("female"))
		        break;
		    else
		        System.out.println("Please enter either Male or Female.");
		}

		while (true) {
			try {
				System.out.println("Enter Salary: ");
				salary = input.nextInt();
				input.nextLine(); // consume newline

				// Case 1: Staff enters a zero or negative value
				if (salary <= 0)
					System.out.println("Invalid input! Please enter a positive salary.");
				else
					break;
			}

			// Case 2: Staff enters incorrect data type
			catch (InputMismatchException e) {
				System.out.println("Invalid input! Please enter a valid salary in figures.");
				input.nextLine(); // Clear invalid input
			}
		}
	}
	
	public void showStaffInfo() {
		System.out.printf("%-10s %-20s %-15s %-10s %-10d%n", id, name, designation, sex, salary);
	}
	
}