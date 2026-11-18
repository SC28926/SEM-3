package inheritence.class_problems;

import java.util.Scanner;

interface PaymentModes {
    double processPayment(double amount);
}

class CashPayments implements PaymentModes {
    @Override
    public double processPayment(double amount) {
        double fee = 0.0;
        double processed = amount + fee;
        System.out.println("Cash: amount " + amount + ", fee " + fee + ", processed " + processed);
        return processed;
    }
}

class CardsPayment implements PaymentModes {
    @Override
    public double processPayment(double amount) {
        double fee = amount * 0.02;
        double processed = amount + fee;
        System.out.println("Card: amount " + amount + ", fee " + fee + ", processed " + processed);
        return processed;
    }
}

class UpiPayments implements PaymentModes {
    @Override
    public double processPayment(double amount) {
        double fee = 0.0;
        double processed = amount + fee;
        System.out.println("UPI: amount " + amount + ", fee " + fee + ", processed " + processed);
        return processed;
    }
}

public class PayMode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        PaymentMode[] payments = new PaymentMode[n];
        double[] amounts = new double[n];

        for (int i = 0; i < n; i++) {
            String mode = scanner.next();
            double amount = scanner.nextDouble();
            amounts[i] = amount;

            if (mode.equalsIgnoreCase("Cash")) {
                payments[i] = new CashPayment();
            } else if (mode.equalsIgnoreCase("Card")) {
                payments[i] = new CardPayment();
            } else if (mode.equalsIgnoreCase("UPI")) {
                payments[i] = new UpiPayment();
            }
        }

        double totalProcessed = 0.0;

        for (int i = 0; i < n; i++) {
            if (payments[i] != null) {
                totalProcessed += payments[i].processPayment(amounts[i]);
            }
        }

        System.out.println("Total Amount Processed: " + totalProcessed);
        scanner.close();
    }
}