package abstraction.class_problems;

import java.util.Scanner;

abstract class Booking {
    double distance;
    Booking(double distance) { 
        this.distance = distance; 
    }
    abstract double getBaseFare();
    
    double getTotalFare() { 
        return getBaseFare() + 50.0; 
    }
}

class Bus extends Booking {
    Bus(double distance) { 
        super(distance); 
    }
    double getBaseFare() { 
        return distance * 2.0; 
    }
}

class Train extends Booking {
    Train(double distance) { 
        super(distance); 
    }
    double getBaseFare() { 
        return distance * 1.5; 
    }
}

class Flight extends Booking {
    Flight(double distance) { 
        super(distance); 
    }
    double getBaseFare() { 
        return 2500.0 + (distance * 4.0); 
    }
}

public class Travel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();
            Booking b = null;
            
            if (mode.equals("BUS")) {
                b = new Bus(distance);
            } else if (mode.equals("TRAIN")) {
                b = new Train(distance);
            } else if (mode.equals("FLIGHT")) {
                b = new Flight(distance);
            }
            
            if (b != null) {
                System.out.printf("%s: %.2f\n", mode, b.getTotalFare());
            }
        }
        sc.close();
    }
}