import model.Subscription;
import service.SubscriptionManager;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SubscriptionManager manager = new SubscriptionManager();
        while (true) {
            System.out.println("\n===== Subscription Manager =====");
            System.out.println("1. Add Subscription");
            System.out.println("2. View Subscriptions");
            System.out.println("3. Search Subscription");
            System.out.println("4. Update Subscription");
            System.out.println("5. Delete Subscription");
            System.out.println("6. Show Statistics");
            System.out.println("7. Exit");
            System.out.print("Choose Option: ");
            try{
                int choice = Integer.parseInt(scanner.nextLine());
                switch(choice){
                    case 1:
                        manager.addSubscription();
                        break;
                    case 2:
                        manager.viewSubscriptions();
                        break;
                    case 3:
                        manager.searchSubscription();
                        break;
                    case 4:
                        manager.updateSubscription();
                        break;
                    case 5:
                        manager.deleteSubscription();
                        break;
                    case 6:
                        manager.showStatistics();
                        break;
                    case 7:
                        manager.saveToFile();
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid Choice!");
                }
            }
            catch(NumberFormatException e){
                System.out.println("Invalid Input. Please enter a number.");
            }
        }
    }
}