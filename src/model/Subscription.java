package model;
import service.SubscriptionManager;
import java.lang.*;
public class Subscription {
    //Private Variables
    private String name;
    private double monthlyCost;
    private int billingDate;
    private String category;
    private boolean autoRenew;

    //Getters
    public String getName(){
        return name;
    }
    public double getMonthlyCost(){
        return monthlyCost;
    }
    public int getBillingDate(){
        return billingDate;
    }
    public String getCategory(){
        return category;
    }
    public boolean isAutoRenew(){
        return autoRenew;
    }

    //Setters
    public void setName(String name){
        this.name = name;
    }
    public void setMonthlyCost(double monthlyCost){
        this.monthlyCost = monthlyCost;
    }
    public void setBillingDate(int billingDate) {
        this.billingDate = billingDate;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setAutoRenew(boolean autoRenew) {
        this.autoRenew = autoRenew;
    }

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