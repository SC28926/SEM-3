package week8.class_problems;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

interface Delivery {
    String getType();
    double calculateFee();
}

class StandardDelivery implements Delivery {
    private double weight;
    private double distance;

    public StandardDelivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public String getType() {
        return "STANDARD";
    }

    public double calculateFee() {
        return 5.0 + (0.50 * weight) + (0.10 * distance);
    }
}

class ExpressDelivery implements Delivery {
    private double weight;
    private double distance;

    public ExpressDelivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public String getType() {
        return "EXPRESS";
    }

    public double calculateFee() {
        return 20.0 + (1.00 * weight) + (0.20 * distance);
    }
}

class InternationalDelivery implements Delivery {
    private double weight;
    private double distance;
    private double customsFee;

    public InternationalDelivery(double weight, double distance, double customsFee) {
        this.weight = weight;
        this.distance = distance;
        this.customsFee = customsFee;
    }

    public String getType() {
        return "INTERNATIONAL";
    }

    public double calculateFee() {
        return 35.0 + (2.00 * weight) + (0.50 * distance) + customsFee;
    }
}

public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
        	return;
        }
        int n = scanner.nextInt();
        List<Delivery> deliveries = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double distance = scanner.nextDouble();
            
            if (type.equals("STANDARD")) {
                deliveries.add(new StandardDelivery(weight, distance));
            } else if (type.equals("EXPRESS")) {
                deliveries.add(new ExpressDelivery(weight, distance));
            } else if (type.equals("INTERNATIONAL")) {
                double customsFee = scanner.nextDouble();
                deliveries.add(new InternationalDelivery(weight, distance, customsFee));
            }
        }
        
        double totalFee = 0;
        for (Delivery delivery : deliveries) {
            double fee = delivery.calculateFee();
            totalFee += fee;
            System.out.printf("%s: %.2f\n", delivery.getType(), fee);
        }
        
        System.out.printf("Total: %.2f\n", totalFee);
        scanner.close();
    }
}
