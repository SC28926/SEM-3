package abstraction.class_problems;

import java.util.Scanner;

abstract class Connection {
    double units;
    Connection(double units) { 
        this.units = units; 
    }
    abstract double getBill();
}

class Home extends Connection {
    Home(double units) { 
        super(units); 
    }
    double getBill() { 
        return units <= 100 ? units * 5.0 : (100 * 5.0) + ((units - 100) * 7.0); 
    }
}

class Shop extends Connection {
    Shop(double units) { 
        super(units); 
    }
    double getBill() { 
        return (units * 8.0) + 100.0; 
    }
}

class Factory extends Connection {
    Factory(double units) { 
        super(units); 
    }
    double getBill() { 
        return Math.max(1000.0, units * 6.0); 
    }
}

public class Ebill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double total = 0;
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double units = sc.nextDouble();
            Connection c = null;
            
            if (type.equals("HOME")) {
                c = new Home(units);
            } else if (type.equals("SHOP")) {
                c = new Shop(units);
            } else if (type.equals("FACTORY")) {
                c = new Factory(units);
            }
            
            if (c != null) {
                double bill = c.getBill();
                total += bill;
                System.out.printf("%s: %.2f\n", type, bill);
            }
        }
        System.out.printf("Total: %.2f\n", total);
        sc.close();
    }
}