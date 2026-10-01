import java.util.Scanner;
import java.util.InputMismatchException;

public class Doctor {
	private String id;
	private String name;
	private String specialist;
	private String workTime;
	private String qualification;
	private int room;
	
	public Doctor(String id, String name, String specialist, String workTime, String qualification, int room){
		this.id = id;
		this.name = name;
		this.specialist = specialist;
		this.workTime = workTime;
		this.qualification = qualification;
		this.room = room;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSpecialist() {
		return specialist;
	}
	
	public String getWorkTime() {
		return workTime;
	}
	
	public String getQualification() {
		return qualification;
	}
	
	public int getRoom() {
		return room;
	}
	
	public void newDoctor(Scanner input) {
		System.out.println("Enter Doctor ID: ");
		id = input.nextLine();

		System.out.println("Enter Doctor Name: ");
		name = input.nextLine();

		System.out.println("Enter Specialization: ");
		specialist = input.nextLine();

		System.out.println("Enter Work Time: ");
		workTime = input.nextLine();

		System.out.println("Enter Qualification: ");
		qualification = input.nextLine();

		while (true) {
			try {
				System.out.println("Enter Room Number: ");
				room = input.nextInt();
				input.nextLine(); // consume newline

				// Case 1: Doctor enters a zero or negative value
				if (room <= 0)
					System.out.println("Invalid input! Please enter a room number that is greater than 0.");
				else
					break;
			}

			// Case 2: Doctor enters incorrect data type
			catch (InputMismatchException e) {
				System.out.println("Invalid input! Please enter a valid room number in figures.");
				input.nextLine(); // Clear invalid input
			}
		}
	}
	
	public void showDoctorInfo() {
	    System.out.printf(
	    	"%-8s %-20s %-20s %-15s %-18s %-8d%n",
	        id, name, specialist, workTime, qualification, room
	    );
	}
	
}