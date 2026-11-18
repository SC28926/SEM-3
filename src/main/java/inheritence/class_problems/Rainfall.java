package inheritence.class_problems;

import java.util.Scanner;

interface PaymentMode {
    double processPayment(double amount);
    String getModeName();
}

class CashPayment implements PaymentMode {
    @Override
    public double processPayment(double amount) {
        return amount;
    }

    @Override
    public String getModeName() {
        return "Cash";
    }
}

class CardPayment implements PaymentMode {
    @Override
    public double processPayment(double amount) {
        double fee = amount * 0.02;
        return amount + fee;
    }

    @Override
    public String getModeName() {
        return "Card";
    }
}

class UpiPayment implements PaymentMode {
    @Override
    public double processPayment(double amount) {
        return amount;
    }

    @Override
    public String getModeName() {
        return "UPI";
    }
}

public class Rainfall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();

        PaymentMode[] payments = new PaymentMode[n];
        double[] amounts = new double[n];

        for (int i = 0; i < n; i++) {
            String mode = scanner.next();
            double amount = scanner.nextDouble();
            amounts[i] = amount;

            switch (mode) {
                case "Cash":
                    payments[i] = new CashPayment();
                    break;
                case "Card":
                    payments[i] = new CardPayment();
                    break;
                case "UPI":
                    payments[i] = new UpiPayment();
                    break;
                default:
                    payments[i] = new CashPayment();
                    break;
            }
        }

        double totalProcessed = 0.0;

        for (int i = 0; i < n; i++) {
            double amount = amounts[i];
            double processed = payments[i].processPayment(amount);
            double fee = processed - amount;

            System.out.printf("%s: amount %.1f, fee %.1f, processed %.1f%n",
                    payments[i].getModeName(), amount, fee, processed);

            totalProcessed += processed;
        }

        System.out.printf("Total Amount Processed: %.1f%n", totalProcessed);
        scanner.close();
    }
}