import java.util.Scanner;

public class Facility {
    private String facility;

    public Facility() {}

    public Facility(String facility) {
        this.facility = facility;
    }

    // Accepts external Scanner to prevent resource leaks and handle inputs safely
    public void newFacility(Scanner sc) {
        try {
            System.out.print("Enter Facility Name: ");
            this.facility = sc.nextLine().trim();

            while (this.facility.isEmpty()) {
                System.out.print("Facility name cannot be blank. Enter Facility Name: ");
                this.facility = sc.nextLine().trim();
            }
        } catch (Exception e) {
            System.out.println("Runtime Error during facility input: " + e.getMessage());
        }
    }

    public void showFacility() {
        System.out.printf("%-25s%n", facility);
    }

    public String getFacility() { 
        return facility; 
    }
}