package service;
import model.Subscription;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class SubscriptionManager{
    //Data Structure Creation
    private ArrayList<Subscription> subscriptions;

    //Scanner Object Creation
    Scanner scanner;

    //Constructor
    public SubscriptionManager(){
        subscriptions = new ArrayList<>();
        scanner = new Scanner(System.in);
        loadFromFile();
    }
    //addSubscription() implementation
    public void addSubscription(){
        System.out.print("Enter Subscription Name: ");
        String name = scanner.nextLine();
        if(name.isBlank()){
            System.out.println("Enter a valid subscription");
            return;
        }
        System.out.print("Enter Monthly Cost: ");
        double monthlyCost;
        try {
            monthlyCost = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid Cost.");
            System.out.println("Please enter a valid number.");
            return;
        }
        if (monthlyCost <= 0) {
            System.out.println("Enter a valid cost");
            return;
        }
        System.out.print("Enter Billing Date: ");
        int billingDate;
        try {
            billingDate = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid Billing Date.");
            System.out.println("Please enter a valid number.");
            return;
        }
        if (billingDate < 1 || billingDate > 31) {
            System.out.println("Enter a valid date");
            return;
        }
        System.out.print("Enter Category: ");
        String category = scanner.nextLine();
        System.out.print("Auto Renew (true/false): ");
        boolean autoRenew = Boolean.parseBoolean(scanner.nextLine());
        Subscription subscription = new Subscription(name,monthlyCost,billingDate,category,autoRenew);
        subscriptions.add(subscription);
        System.out.println("Subscription Added Successfully");
    }

    //viewSubscription() implementation
    public void viewSubscriptions(){
        if(subscriptions.isEmpty()){
            System.out.println("No Subscriptions Found");
            return;
        }
        for(Subscription subscription:subscriptions){
            System.out.println("Subscription");
            System.out.println("-------------");
            System.out.println(subscription);
            System.out.println("\n");
        }
    }

    //searchSubscription() implementation
    public void searchSubscription() {
        System.out.print("Enter Subscription Name: ");
        String searchName = scanner.nextLine();
        for (Subscription subscription : subscriptions) {
            if (subscription.getName().equalsIgnoreCase(searchName)) {
                System.out.println(subscription);
                return;
            }
        }

        System.out.println("Subscription not found.");
    }

    //deleteSubscription() implementation
    public void deleteSubscription() {
        System.out.println("Enter Subscription Name:");
        String searchName = scanner.nextLine();
        for (int i = 0; i < subscriptions.size(); i++) {
            if (subscriptions.get(i).getName().equalsIgnoreCase(searchName)) {
                subscriptions.remove(i);
                System.out.println("Subscription deleted successfully.");
                return;
            }
        }
        System.out.println("Subscription not found.");
    }

    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("subscriptions.txt"))) {

            for (Subscription subscription : subscriptions){
                writer.write(
                        subscription.getName() + "," +
                                subscription.getMonthlyCost() + "," +
                                subscription.getBillingDate() + "," +
                                subscription.getCategory() + "," +
                                subscription.isAutoRenew()
                );
                writer.newLine();
            }
            System.out.println("Subscriptions saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving subscriptions.");
        }
    }

    public void loadFromFile() {
        File file = new File("subscriptions.txt");
        if (!file.exists()) {
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                double monthlyCost = Double.parseDouble(data[1]);
                int billingDate = Integer.parseInt(data[2]);
                String category = data[3];
                boolean autoRenew = Boolean.parseBoolean(data[4]);
                Subscription subscription = new Subscription(
                        name,
                        monthlyCost,
                        billingDate,
                        category,
                        autoRenew
                );
                subscriptions.add(subscription);
            }
        } catch (IOException e) {
            System.out.println("Error loading subscriptions.");
        }
    }
}