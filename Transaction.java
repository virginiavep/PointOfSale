import java.util.ArrayList;
//import java.util.Iterator;
import java.util.Scanner;

public class Transaction {
    private ArrayList<Item> items;
    private ArrayList<Payment> payments;
    private double subTotal;
    private double tax;
    private double total;
    private double change;
    
    public Transaction(){
        this.items = new ArrayList<>();
        this.payments = new ArrayList<>();
    }
    public Transaction(ArrayList<Item> items){
        this.items = items;
        this.payments = new ArrayList<>();
    }
    
    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Payment> getPayments() {
        return payments;
    }

    public void setPayments(ArrayList<Payment> payments) {
        this.payments = payments;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }
    
    public void computeSubtotal(){
        items.forEach((item) -> {
            subTotal += item.getPrice();
        });
    }
    
    public void computeTax(){
        tax = subTotal * .07;
    }
    
    public void computeTotal(){
        total = subTotal + tax;
    }
    
    public void takePayment(){
        Scanner scnr = new Scanner(System.in);
        do{
            System.out.println("Please enter the payment type.\n1. Cash\n2. "
                + "Debit Card\n3. Credit Card\n4. Check");
        int payOption = scnr.nextInt();
        switch (payOption) {
            case 1:
                {
                    double payAmount;
                    PaymentType payment = PaymentType.CASH;
                    System.out.print("Enter the amount to pay with this type.\n");
                    payAmount = scnr.nextDouble();
                    Payment payObj = new Payment(payment, payAmount);
                    payments.add(payObj);
                    total = total-payAmount;
                    if (total<0){
                        change = Math.abs(total);
                    }
                    System.out.println("Total after payment: " + total);
                    break;
                }
            case 2:
                {
                    double payAmount;
                    PaymentType payment = PaymentType.DEBIT_CARD;
                    System.out.print("Enter the amount to pay with this type.\n");
                    payAmount = scnr.nextDouble();
                    Payment payObj = new Payment(payment, payAmount);
                    payments.add(payObj);
                    total = total-payAmount;
                    if (total<0){
                        change = Math.abs(total);
                    }
                    System.out.println("Total after payment: " + total);
                    break;
                }
            case 3:
                {
                    double payAmount;
                    PaymentType payment = PaymentType.CREDIT_CARD;
                    System.out.print("Enter the amount to pay with this type.\n");
                    payAmount = scnr.nextDouble();
                    Payment payObj = new Payment(payment, payAmount);
                    payments.add(payObj);
                    total = total-payAmount;
                    if (total<0){
                        change = Math.abs(total);
                    }
                    System.out.println("Total after payment: "+ total);
                    break;
                }
            case 4:
                {   
                    double payAmount;
                    PaymentType payment = PaymentType.CHECK;
                    System.out.print("Enter the amount to pay with this type.\n");
                    payAmount = scnr.nextDouble();
                    Payment payObj = new Payment(payment, payAmount);
                    payments.add(payObj);
                    total = total-payAmount;
                    if (total<0){
                        change = Math.abs(total);
                    }
                    System.out.println("Total after payment: " + total);
                    break;
                }
            default:
                break;
            }
        } while(total>0);
    }
}
