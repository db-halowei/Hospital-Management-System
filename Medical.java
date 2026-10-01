import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;

public class Medical {
	//declare variables
	private String name;
	private String manufacturer;
	private String expiryDate;
	private int cost;
	private int count;
	
	//constructor
	public Medical(String name, String manufacturer, String expiryDate, int cost, int count) {
		this.name = name;
		this.manufacturer = manufacturer;
		this.expiryDate = expiryDate;
		this.cost = cost;
		this.count = count;
	}
	
	//accessor and mutator
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public String getExpiryDate() {
		return expiryDate;
	}
	
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	public double getCost() {
		return cost;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	//input new medical info
	public void newMedical(Scanner input) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);
		System.out.println("Enter Medicine Name: ");
		name = input.nextLine();
		System.out.println("Enter Medicine Manufacturer: ");
		manufacturer = input.nextLine();

		while (true) {
            System.out.print("Enter Medicine Expiry Date (dd/MM/yyyy): ");
            expiryDate = input.nextLine().trim();

            //validate format of expiry date
            try {
                LocalDate.parse(expiryDate, formatter);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Please use dd/MM/yyyy format (e.g., 04/06/2027).");
            }
        }
		
		while (true) {
			System.out.println("Enter Medicine Cost: ");

			// validate type of input
			if (input.hasNextDouble()) {
				cost = input.nextInt();
				input.nextLine();

				// exit when correct type and value
				if (cost >= 0)
					break;
				else
					System.out.println("Please enter valid cost.");
			}
			else {
				System.out.println("Please enter a valid number.");
				input.next();
			}
		}
		
		while (true) {
		    System.out.println("Enter Number of Unit: ");

		    // validate type of input
		    if (input.hasNextInt()) {
		        count = input.nextInt();
		        input.nextLine();

		        // exit when correct type and value
		        if (count >= 0)
		            break;
		        else
		            System.out.println("Please enter a positive whole number as the number of units.");
		    }
		    else {
		        System.out.println("Please enter a valid whole number.");
		        input.next();
		    }
		}
		
	}
	
	//show medical info
	public void findMedical() {
		System.out.printf("%-20s %-20s %-20s %-10.2f%n", name, manufacturer, expiryDate, cost);
	}
}
