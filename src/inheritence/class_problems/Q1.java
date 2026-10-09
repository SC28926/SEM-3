package inheritence.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract double calculateFinalAmount();

    public String getType() {
        return this.getClass().getSimpleName().replace("Payment", "").toUpperCase();
    }
}

class CardPayment extends Payment {
    public CardPayment(double amount) {
        super(amount);
    }

    public double calculateFinalAmount() {
        return amount + (amount * 0.02);
    }
}

class WalletPayment extends Payment {
    public WalletPayment(double amount) {
        super(amount);
    }

    public double calculateFinalAmount() {
        return amount + (amount * 0.01);
    }
}

class BankTransferPayment extends Payment {
    public BankTransferPayment(double amount) {
        super(amount);
    }

    public double calculateFinalAmount() {
        return amount;
    }
}

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Payment> payments = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            String type = parts[0].toUpperCase();
            double amount = Double.parseDouble(parts[1]);

            switch (type) {
                case "CARD":
                    payments.add(new CardPayment(amount));
                    break;
                case "WALLET":
                    payments.add(new WalletPayment(amount));
                    break;
                case "BANKTRANSFER":
                    payments.add(new BankTransferPayment(amount));
                    break;
                default:
                    System.out.println("Invalid payment type");
            }
        }

        double total = 0.0;
        for (Payment p : payments) {
            double finalAmount = p.calculateFinalAmount();
            total += finalAmount;
            System.out.printf("%s: %.2f%n", p.getType(), finalAmount);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}