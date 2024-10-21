package Project_7;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class DataBase {
    private List<Magazine> magazines;
    private List<Streaming> streamings;
    private List<Freemium> freemiums;

    public DataBase() {
        magazines = new LinkedList<>();
        streamings = new LinkedList<>();
        freemiums = new LinkedList<>();
    }

    public void add_magazine(Magazine magazine) {
        magazines.add(magazine);
    }

    public void addStreaming(Streaming streaming) {
        streamings.add(streaming);
    }

    public void addFreemium(Freemium freemium) {
        freemiums.add(freemium);
    }

    public void updateMagazine(Magazine magazine, int index) {
        if (index >= 0 && index < magazines.size()) {
            magazines.set(index, magazine);
        }
    }

    public void updateStreaming(Streaming streaming, int index) {
        if (index >= 0 && index < streamings.size()) {
            streamings.set(index, streaming);
        }
    }

    public void updateFreemium(Freemium freemium, int index) {
        if (index >= 0 && index < freemiums.size()) {
            freemiums.set(index, freemium);
        }
    }

    public void removeMagazine(Magazine magazine) {
        magazines.remove(magazine);
    }

    public void removeStreaming(Streaming streaming) {
        streamings.remove(streaming);
    }

    public void removeFreemium(Freemium freemium) {
        freemiums.remove(freemium);
    }

    public Magazine searchMagazine(String name) {
        return magazines.stream()
                .filter(m -> m.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public Streaming searchStreams(String name) {
        return streamings.stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public Freemium searchFreemium(String name) {
        return freemiums.stream()
                .filter(f -> f.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    // Filter methods
    public List<Magazine> filterMagazines(String status) {
        return magazines.stream()
                .filter(m -> m.getStatus().equalsIgnoreCase(status))
                .collect(Collectors.toList());
    }

    public List<Freemium> filterFreemiums(String status) {
        return freemiums.stream()
                .filter(f -> f.getStatus().equalsIgnoreCase(status))
                .collect(Collectors.toList());
    }

    public List<Streaming> filterStreams(String status) {
        return streamings.stream()
                .filter(s -> s.getStatus().equalsIgnoreCase(status))
                .collect(Collectors.toList());
    }

    // Views all subscriptions inside the Database and Prints the Details
    public void viewAllSubscriptions() {
        System.out.println("Magazines that you have :");
        for (Magazine magazine : magazines) {
            System.out.println("Name: " + magazine.getName());
            System.out.println("Starting Date: " + magazine.getStartDate());
            System.out.println("End Date: " + magazine.getEndDate());
            System.out.println("Status " + magazine.getStatus());
            System.out.println("Delivery Type " + magazine.getDeliveryType());
            System.out.println("=========================================================================================================================================================");
        }
        System.out.println("Streamings that you have : ");
        for (Streaming stream : streamings) {
            System.out.println("Name: " + stream.getName());
            System.out.println("Starting Date: " + stream.getStartDate());
            System.out.println("End Date: " + stream.getEndDate());
            System.out.println("Status " + stream.getStatus());
            System.out.println("Device Limit " + stream.getDevicelimit());
            System.out.println("=========================================================================================================================================================");
        }
        System.out.println("Freemiums that you have :");
        for (Freemium free : freemiums) {
            System.out.println("Name: " + free.getName());
            System.out.println("Starting Date: " + free.getStartDate());
            System.out.println("End Date: " + free.getEndDate());
            System.out.println("Status " + free.getStatus());
            System.out.println("Trial Period: " + free.getTrialPeriod() + " days");
            System.out.println("=========================================================================================================================================================");
        }
    }

}