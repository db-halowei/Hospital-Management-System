import java.util.Scanner;
import java.util.InputMismatchException;

public class Lab {
    private String lab;
    private int cost;

    public Lab() {}

    public Lab(String lab, int cost) {
        this.lab = lab;
        this.cost = cost;
    }

    public void newLab(Scanner sc) {
        System.out.print("Enter Laboratory Name: ");
        this.lab = sc.nextLine().trim();

        // Validate laboratory name
        while (this.lab.isEmpty()) {
            System.out.print("Laboratory name cannot be blank. Enter Laboratory Name: ");
            this.lab = sc.nextLine().trim();
        }

        boolean validCost = false;
        while (!validCost) {
            try {
                System.out.print("Enter Cost: ");
                this.cost = sc.nextInt();
                sc.nextLine(); // Clear buffer
                
                if (this.cost < 0) {
                    System.out.println("Cost cannot be negative! Try again.");
                } else {
                    validCost = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Runtime Error: Invalid input type! Please enter a valid numerical number.");
                sc.nextLine(); // Clear invalid input from buffer
            }
        }
    }

    public void labList() {
        System.out.printf("%-25s %-10.2f%n", lab, cost);
    }

    public String getLab() { 
        return lab; 
    }

    public double getCost() { 
        return cost; 
    }
}