package inheritence.class_problems;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

interface Journey {
    String getType();
    double calculateFare();
}

class BusJourney implements Journey {
    private double distance;

    public BusJourney(double distance) {
        this.distance = distance;
    }

    public String getType() {
        return "BUS";
    }
    
    public double calculateFare() {
        double fare = 2.0 + (0.10 * distance);
        return Math.min(fare, 10.0);
    }
}

class TrainJourney implements Journey {
    private double distance;

    public TrainJourney(double distance) {
        this.distance = distance;
    }

    public String getType() {
        return "TRAIN";
    }

    public double calculateFare() {
        return 3.0 + (0.15 * distance);
    }
}

class MetroJourney implements Journey {
    private double distance;
    private double peakHourFactor;

    public MetroJourney(double distance, double peakHourFactor) {
        this.distance = distance;
        this.peakHourFactor = peakHourFactor;
    }

    public String getType() {
        return "METRO";
    }

    public double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }
}

public class Q5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) 
        	return;

        int n = scanner.nextInt();
        List<Journey> journeys = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double distance = scanner.nextDouble();

            if (type.equals("BUS")) {
                journeys.add(new BusJourney(distance));
            } else if (type.equals("TRAIN")) {
                journeys.add(new TrainJourney(distance));
            } else if (type.equals("METRO")) {
                double peakHourFactor = scanner.nextDouble();
                journeys.add(new MetroJourney(distance, peakHourFactor));
            }
        }

        double totalFare = 0;
        for (Journey journey : journeys) {
            double fare = journey.calculateFare();
            totalFare += fare;
            System.out.printf("%s: %.2f\n", journey.getType(), fare);
        }

        System.out.printf("Total: %.2f\n", totalFare);
        scanner.close();
    }
}