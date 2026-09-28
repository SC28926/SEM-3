package week8.assigment_problems;

import java.time.LocalDate;
import java.util.Scanner;

interface Renewable {
    LocalDate calculateRenewalDate(LocalDate startDate);
}

abstract class Subscriber implements Renewable {
    protected String name;
    protected LocalDate startDate;

    public Subscriber(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
}

class BasicSubscriber extends Subscriber {
    public BasicSubscriber(String name, LocalDate startDate) {
        super(name, startDate);
    }

    public LocalDate calculateRenewalDate(LocalDate startDate) {
        return startDate.plusDays(30);
    }
}

class StandardSubscriber extends Subscriber {
    public StandardSubscriber(String name, LocalDate startDate) {
        super(name, startDate);
    }

    public LocalDate calculateRenewalDate(LocalDate startDate) {
        return startDate.plusDays(90);
    }
}

class PremiumSubscriber extends Subscriber {
    public PremiumSubscriber(String name, LocalDate startDate) {
        super(name, startDate);
    }

    public LocalDate calculateRenewalDate(LocalDate startDate) {
        return startDate.plusDays(365);
    }
}

class SubscriberFactory {
    public static Subscriber createSubscriber(String type, String name, LocalDate startDate) {
        switch (type.toUpperCase()) {
            case "BASIC":
                return new BasicSubscriber(name, startDate);
            case "STANDARD":
                return new StandardSubscriber(name, startDate);
            case "PREMIUM":
                return new PremiumSubscriber(name, startDate);
            default:
                throw new IllegalArgumentException("Unknown plan type: " + type);
        }
    }
}

public class Q5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        Subscriber[] subscribers = new Subscriber[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            LocalDate startDate = LocalDate.parse(scanner.next());

            subscribers[i] = SubscriberFactory.createSubscriber(type, name, startDate);
        }

        for (int i = 0; i < n; i++) {
            LocalDate renewalDate = subscribers[i].calculateRenewalDate(subscribers[i].getStartDate());
            System.out.printf("%s: %s\n", subscribers[i].getName(), renewalDate);
        }

        scanner.close();
    }
}