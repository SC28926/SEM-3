package inheritence.class_problems;

import java.util.Scanner;

public class Ebill {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();

        int roomsBilled = 0;
        int totalAmount = 0;

        for (int i = 0; i < n; i++) {
            String room = scanner.next();
            int units = scanner.nextInt();

            if (units < 0) {
                System.out.println(room + ": invalid reading");
                continue;
            }

            int bill = calculateBill(units);
            System.out.println(room + ": " + units + " units, bill " + bill);

            roomsBilled++;
            totalAmount += bill;
        }

        System.out.println("Rooms billed " + roomsBilled + ", total " + totalAmount);
        scanner.close();
    }

    private static int calculateBill(int units) {
        int charge = 50;

        if (units <= 100) {
            charge += units * 3;
        } else if (units <= 200) {
            charge += (100 * 3) + ((units - 100) * 5);
        } else {
            charge += (100 * 3) + (100 * 5) + ((units - 200) * 8);
        }

        return charge;
    }
}