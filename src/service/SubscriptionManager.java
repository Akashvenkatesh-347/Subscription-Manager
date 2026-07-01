import java.util.Scanner;
import java.util.ArrayList;
public class SubscriptionManager {
    //Data Structure Creation
    private ArrayList<Subscription> subscriptions;

    //Scanner Object Creation
    Scanner scanner;

    //Constructor
    public SubscriptionManager(){
        subscriptions = new ArrayList<>();
        scanner = new Scanner(System.in);
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
        double monthlyCost = Double.parseDouble(scanner.nextLine());
        if(monthlyCost <= 0){
            System.out.println("Enter a valid cost");
            return;
        }
        System.out.print("Enter Billing Date: ");
        int billingDate = Integer.parseInt(scanner.nextLine());
        if(billingDate < 1 || billingDate > 31){
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
                System.out.println("Name: " + subscription.getName());
                System.out.println("Cost: " + subscription.getMonthlyCost());
                System.out.println("Category: " + subscription.getCategory());
                System.out.println("Billing Date: " + subscription.getBillingDate());
                return;
            }
        }

        System.out.println("Subscription not found.");
    }
}