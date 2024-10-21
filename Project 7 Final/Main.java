package Project_7;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DataBase database = new DataBase();
        Scanner read = new Scanner(System.in);
        Controller controller = new Controller(database, read);
        while (true) {
            System.out.flush();
            System.out.println("=========================================================================================================================================================");
            System.out.println("                                                                Subscription Management System        ");
            System.out.println("=========================================================================================================================================================");
            System.out.println("Select the Number corresponding to the option you wish to do today:");
            System.out.println("[1] Create a new subscription");
            System.out.println("[2] Update an existing subscription");
            System.out.println("[3] Cancel a subscription");
            System.out.println("[4] View all subscriptions");
            System.out.println("[5] Filter subscriptions");
            System.out.println("[6] Search for a subscription");
            System.out.println("[7] Remove a subscription");
            System.out.println("[8] End the program");
            System.out.println("=========================================================================================================================================================");
            System.out.print("Enter your choice: ");
            try {
                int choice = read.nextInt();
                read.nextLine();
                switch (choice) {
                    case 1:
                        controller.create();
                        break;
                    case 2:
                        controller.update();
                        break;
                    case 3:
                        controller.cancel();
                        break;
                    case 4:
                        controller.view();
                        break;
                    case 5:
                        controller.filter();
                        break;
                    case 6:
                        controller.search();
                        break;
                    case 7:
                        controller.remove();
                        break;
                    case 8:
                        System.out.println("Closing System. Thank you for using the Subscription Management System!");
                        read.close();
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                read.next();
            }
        }
    }
}