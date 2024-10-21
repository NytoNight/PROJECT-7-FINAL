package Project_7;

import java.util.List;
import java.util.Scanner;

public class Controller implements ICANCEL, ICREATE, IREMOVE, ISTATUS, IUPDATE {
    DataBase database;
    Scanner read;

    public Controller(DataBase database, Scanner read) {
        this.database = database;
        this.read = read;
    }

    @Override
    public void create() {
        //Prompts the User to Select which Subscription would they like to Create
        System.out.println("=========================================================================================================================================================");
        System.out.println("                                                                Creating a new Subscriptions       ");
        System.out.println("=========================================================================================================================================================");
        System.out.println("Select the type of subscription to create:");
        System.out.println("[1] Magazine");
        System.out.println("[2] Streaming");
        System.out.println("[3] Freemium");
        System.out.print("Enter your choice (1-3): ");
        int choice = read.nextInt();
        read.nextLine();
        String name;
        String startDate;
        String endDate;
        switch (choice) {
            case 1:
                System.out.print("Enter the Magazine Subscription name: ");
                name = read.nextLine();
                startDate = ErrorHandling.getValidDate(read, "Enter start date (yyyy-MM-dd): ");
                endDate = ErrorHandling.getValidDate(read, "Enter end date (yyyy-MM-dd): ");
                System.out.print("Enter the Delivery Type [Physical or Online]: ");
                String deliveryType = read.nextLine();
                Magazine magazine = new Magazine(startDate, endDate, "Active", name, deliveryType);
                database.add_magazine(magazine);
                System.out.println("Magazine subscription added successfully!");
                break;

            case 2:
                System.out.print("Enter the Streaming Subscription name: ");
                name = read.nextLine();
                System.out.print("Enter Device Limit: ");
                int devicelimit = read.nextInt();
                read.nextLine();
                startDate = ErrorHandling.getValidDate(read, "Enter start date (yyyy-MM-dd): ");
                endDate = ErrorHandling.getValidDate(read, "Enter end date (yyyy-MM-dd): ");
                Streaming streaming = new Streaming(startDate, endDate, "Active", name, devicelimit);
                database.addStreaming(streaming);
                System.out.println("Streaming subscription added successfully!");
                break;

            case 3:
                System.out.print("Enter Subscription name: ");
                name = read.nextLine();
                startDate = ErrorHandling.getValidDate(read, "Enter start date (yyyy-MM-dd): ");
                endDate = ErrorHandling.getValidDate(read, "Enter end date (yyyy-MM-dd): ");
                System.out.print("Enter Trial Period (in days):  ");
                int trialPeriod = read.nextInt();
                Freemium free = new Freemium(startDate, endDate, "Active", name, trialPeriod);
                database.addFreemium(free);
                System.out.println("Freemium subscription added successfully!");
                break;
            default:
                System.out.println("Invalid subscription type provided.");
                return;
        }

        System.out.println("Added to your subscriptions!!");
        System.out.println(" ");
    }

    @Override
    public void update() {
        //Prompts the User to Select which Subscription would they like to Update
        System.out.println("=========================================================================================================================================================");
        System.out.println("                                                                Updating a Subscriptions        ");
        System.out.println("=========================================================================================================================================================");
        System.out.println("Select the type of subscription to update:");
        System.out.println("[1] Magazine");
        System.out.println("[2] Streaming");
        System.out.println("[3] Freemium");
        System.out.print("Enter your choice (1-3): ");
        int choice = read.nextInt();
        read.nextLine();
        System.out.println("Updating the subscription");
        System.out.print("Enter Subscription name: ");
        String name = read.nextLine();
        String startDate = ErrorHandling.getValidDate(read, "Enter new start date (yyyy-MM-dd): ");
        String endDate = ErrorHandling.getValidDate(read, "Enter new end date (yyyy-MM-dd): ");
        //Switch Cases for The Update Feature of the Program
        switch (choice) {
            case 1:
                System.out.print("Enter new Delivery Type [Online or Physical]: "); String deliveryType = read.nextLine();
                Magazine magazine = new Magazine(startDate, endDate, "Active", name, deliveryType);
                database.updateMagazine(magazine, 0);
                System.out.println("Updated the Magazine Subscription!!");
                break;
            case 2:
                System.out.print("Enter new Device Limit: ");int deviceLimit = read.nextInt();
                Streaming streaming = new Streaming(startDate, endDate, "Active", name, deviceLimit); 
                database.updateStreaming(streaming, 0);
                System.out.println("Updated the Streaming Subscription!!");
                break;
            case 3:
                Freemium freemium = new Freemium(startDate, endDate, "Active", name,0);
                database.updateFreemium(freemium, 0);
                System.out.println("Updated the Freemium Subscription!!");
                break;
            default:
                System.out.println("Invalid subscription type provided.");
                return;
        }

        System.out.println(" ");
    }

    @Override
    public void cancel() {
        //Prompts the User to Select which Subscription would they like to Cancel
        System.out.println("=========================================================================================================================================================");
        System.out.println("                                                                Cancelling a Subscriptions        ");
        System.out.println("=========================================================================================================================================================");
        System.out.println("Select the type of subscription to cancel:");
        System.out.println("[1] Magazine");
        System.out.println("[2] Streaming");
        System.out.println("[3] Freemium");
        System.out.print("Enter your choice (1-3): ");
        int choice = read.nextInt();
        read.nextLine();
        System.out.println("Canceling the subscription");
        System.out.print("Enter Subscription name: ");
        String name = read.nextLine();
        switch (choice) {
            case 1:
                Magazine magazine = new Magazine("Cancelled", "Cancelled", "Cancelled", name, "Cancelled");
                database.updateMagazine(magazine, 0);
                System.out.println("Cancelled the Magazine Subscription!!");
                break;
            case 2:
                Streaming streaming = new Streaming("Cancelled", "Cancelled", "Cancelled", name, 0); 
                database.updateStreaming(streaming, 0);
                System.out.println("Cancelled the Streaming Subscription!!");
                break;
            case 3:
                Freemium freemium = new Freemium("Cancelled", "Cancelled", "Cancelled", name, 0);
                database.updateFreemium(freemium, 0);
                System.out.println("Cancelled the Freemium Subscription!!");
                break;
            default:
                System.out.println("Invalid subscription type provided.");
                break;
        }

        System.out.println(" ");
    }

    @Override
    public void remove() {
        //Prompts the User to Select which Subscription would they like to Remove
        System.out.println("=========================================================================================================================================================");
        System.out.println("                                                                Removing a Subscriptions        ");
        System.out.println("=========================================================================================================================================================");
        System.out.println("[1] Magazine");
        System.out.println("[2] Streaming");
        System.out.println("[3] Freemium");
        System.out.print("Enter your choice (1-3): ");
        int choice = read.nextInt();
        read.nextLine();
        System.out.print("Enter name: ");
        String name = read.nextLine();
        switch (choice) {
            case 1:
                Magazine magazine = database.searchMagazine(name);
                if (magazine != null) {
                    database.removeMagazine(magazine);
                    System.out.println("Magazine subscription removed successfully.");
                } else {
                    System.out.println("Magazine subscription not found.");
                }
                break;
            case 2:
                Streaming streaming = database.searchStreaming(name);
                if (streaming != null) {
                    database.removeStreaming(streaming);
                    System.out.println("Streaming subscription removed successfully.");
                } else {
                    System.out.println("Streaming subscription not found.");
                }
                break;
            case 3:
                Freemium freemium = database.searchFreemium(name);
                if (freemium != null) {
                    database.removeFreemium(freemium);
                    System.out.println("Freemium subscription removed successfully.");
                } else {
                    System.out.println("Freemium subscription not found.");
                }
                break;
            default:
                System.out.println("Invalid subscription type provided.");
                break;
        }
    }


    public void status() {
        //Prompts the User to Select which Subscription would they like to access there Status if its Active or Cancelled
        System.out.println("=========================================================================================================================================================");
        System.out.println("                                                                Previewing all status of all the subscription        ");
        System.out.println("=========================================================================================================================================================");
        System.out.println("Select the type of subscription status you want to check:");
        System.out.println("[1] Magazine");
        System.out.println("[2] Streaming");
        System.out.println("[3] Freemium");
        System.out.print("Enter your choice (1-3): ");
        int choice = read.nextInt();
        read.nextLine();
        System.out.print("Enter name: ");
        String name = read.nextLine();
        switch (choice) {
            case 1:
                Magazine magazine = database.searchMagazine(name);
                if (magazine != null) {
                    System.out.println("The Magazine: " + magazine.getName() + " is " + magazine.getStatus());
                } else {
                    System.out.println("Magazine subscription not found.");
                }
                break;
            case 2:
                Streaming streaming = database.searchStreaming(name);
                if (streaming != null) {
                    System.out.println("The Streaming Service: " + streaming.getName() + " is " + streaming.getStatus());
                } else {
                    System.out.println("Streaming subscription not found.");
                }
                break;
            case 3:
                Freemium freemium = database.searchFreemium(name);
                if (freemium != null) {
                    System.out.println("The Freemium: " + freemium.getName() + " is " + freemium.getStatus());
                } else {
                    System.out.println("Freemium subscription not found.");
                }
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
    }

    public void view() {
        //Views all the Current Active Subscription and Show their Details
        System.out.println("=========================================================================================================================================================");
        System.out.println("                                                                Viewing ALL Subscriptions        ");
        System.out.println("=========================================================================================================================================================");
        System.out.println("Viewing all subscriptions...");
        database.viewAllSubscriptions();
    }

    public void search() {
        //Search Feature so user may choose which Specific Subscription they would like to see if it is inside the database
        System.out.println("=========================================================================================================================================================");
        System.out.println("                                                                Searching for a Existing Subscription        ");
        System.out.println("=========================================================================================================================================================");
        System.out.println("Select the type of subscription to search:");
        System.out.println("[1] Magazine");
        System.out.println("[2] Streaming");
        System.out.println("[3] Freemium");
        System.out.print("Enter your choice (1-3): ");
        int choice = read.nextInt();
        read.nextLine();
        System.out.print("Enter the name of the subscription: ");
        String name = read.nextLine();
        switch (choice) {
            case 1:
                Magazine magazine = database.searchMagazine(name);
                if (magazine != null) {
                    System.out.println("Magazine found: " + magazine.getName() + " - Status: " + magazine.getStatus());
                } else {
                    System.out.println("Magazine subscription not found.");
                }
                break;
            case 2:
                Streaming streaming = database.searchStreaming(name);
                if (streaming != null) {
                    System.out.println("Streaming found: " + streaming.getName() + " - Status: " + streaming.getStatus());
                } else {
                    System.out.println("Streaming subscription not found.");
                }
                break;
            case 3:
                Freemium freemium = database.searchFreemium(name);
                if (freemium != null) {
                    System.out.println("Freemium found: " + freemium.getName() + " - Status: " + freemium.getStatus());
                } else {
                    System.out.println("Freemium subscription not found.");
                }
                break;
            default:
                System.out.println("Invalid subscription type provided.");
                break;
        }
    }

    public void filter() {
        //User would Select to filter either between Active or Cancelled to view.
        System.out.println("=========================================================================================================================================================");
        System.out.println("                                                                Filtering ALL Subscriptions        ");
        System.out.println("=========================================================================================================================================================");
        System.out.println("Select the type of subscription to filter [Active or Cancelled]: ");
        System.out.println("[1] Magazine");
        System.out.println("[2] Streaming");
        System.out.println("[3] Freemium");
        System.out.print("Enter your choice (1-3): ");
        int choice = read.nextInt();
        read.nextLine();
        System.out.println("Enter the status to filter by [Active or Cancelled]: ");
        String status = read.nextLine();
        System.out.println("Results");
        switch (choice) {
            case 1:
                List<Magazine> filteredMagazines = database.filterMagazines(status);
                if (filteredMagazines.isEmpty()) {
                    System.out.println("No magazines found with status: " + status);
                } else {
                    System.out.println("Filtered Magazines:");
                    for (Magazine magazine : filteredMagazines) {
                        System.out.println("Name: " + magazine.getName() + " - Status: " + magazine.getStatus());
                    }
                }
                break;
            case 2:
                List<Streaming> filteredStreamings = database.filterStreaming(status);
                if (filteredStreamings.isEmpty()) {
                    System.out.println("No Streaming Sites found with status: " + status);
                } else {
                    System.out.println("Filtered Streaming Sites Subscription");
                    for (Streaming streaming : filteredStreamings) {
                        System.out.println("Name: " + streaming.getName() + " - Status: " + streaming.getStatus());
                    }
                }
                break;
            case 3:
                List<Freemium> filteredFreemiums = database.filterFreemiums(status);
                if (filteredFreemiums.isEmpty()) {
                    System.out.println("No freemiums found with status: " + status);
                } else {
                    System.out.println("Filtered Freemium Subscription:");
                    for (Freemium freemium : filteredFreemiums) {
                        System.out.println("Name: " + freemium.getName() + " - Status: " + freemium.getStatus());
                    }
                }
                break;
            default:
                System.out.println("Invalid subscription type provided.");
                break;
        }
    }
}
