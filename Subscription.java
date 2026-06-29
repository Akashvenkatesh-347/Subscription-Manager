import java.lang.*;
public class Subscription {
    //Private Variables
    private String name;
    private double monthlyCost;
    private int billingDate;
    private String category;
    private boolean autoRenew;

    //Constructor
    public Subscription(String name,double monthlyCost,int billingDate,String category,boolean autoRenew){
        this.name = name;
        this.monthlyCost = monthlyCost;
        this.billingDate = billingDate;
        this.category = category;
        this.autoRenew = autoRenew;
    }

    //toString() function
    public String toString(){
        return "Name: "+name+
                "\nMonthly Cost: "+monthlyCost+
                "\nBilling Date: "+billingDate+
                "\nCategory: "+category+
                "\nAuto Renew: "+autoRenew;
    }
}