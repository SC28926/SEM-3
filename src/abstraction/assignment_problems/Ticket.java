package abstraction.assignment_problems;

import java.util.Scanner;

abstract class Seat {
    protected int count;
    public Seat(int count) {
        this.count = count;
    }
    protected abstract double getPrice();
    public double calculateBooking() {
        return (getPrice() + 20) * count;
    }
}

class Regular extends Seat {
    public Regular(int count) { super(count); }
    protected double getPrice() { return 150.0; }
}

class Premium extends Seat {
    public Premium(int count) { super(count); }
    protected double getPrice() { return 250.0; }
}

class Recliner extends Seat {
    public Recliner(int count) { super(count); }
    protected double getPrice() { return 400.0; }
}

public class Ticket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int count = sc.nextInt();
            Seat seat = null;
            if (type.equals("REGULAR")) seat = new Regular(count);
            else if (type.equals("PREMIUM")) seat = new Premium(count);
            else if (type.equals("RECLINER")) seat = new Recliner(count);
            
            if (seat != null) {
                double amount = seat.calculateBooking();
                System.out.printf("%s: %.2f\n", type, amount);
                total += amount;
            }
        }
        System.out.printf("Total: %.2f\n", total);
        sc.close();
    }
}