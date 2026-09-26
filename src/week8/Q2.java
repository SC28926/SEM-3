package week8;
import java.time.*;
import java.time.format.*;
import java.util.*;

abstract class LibraryItem {
    private String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract int getBorrowingDuration();

    public String calculateDueDate(LocalDate currentDate) {
        LocalDate dueDate = currentDate.plusDays(getBorrowingDuration());
        return dueDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}

class Book extends LibraryItem {
    public Book(String title) {
        super(title);
    }

    public int getBorrowingDuration() {
        return 14;
    }
}

class DVD extends LibraryItem {
    public DVD(String title) {
        super(title);
    }

    public int getBorrowingDuration() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    public Magazine(String title) {
        super(title);
    }

    public int getBorrowingDuration() {
        return 3;
    }
}

interface ItemFactory {
    LibraryItem create(String title);
}

public class Q2 {
    private static final Map<String, ItemFactory> registry = new HashMap<>();

    static {
        registry.put("BOOK", Book::new);
        registry.put("DVD", DVD::new);
        registry.put("MAGAZINE", Magazine::new);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        scanner.nextLine();

        LocalDate currentDate = LocalDate.parse("2023-10-26");
        List<LibraryItem> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextLine()) break;
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            int firstSpace = line.indexOf(' ');
            if (firstSpace == -1) continue;

            String type = line.substring(0, firstSpace).toUpperCase();
            String title = line.substring(firstSpace + 1).trim();

            if (title.startsWith("\"") && title.endsWith("\"") && title.length() >= 2) {
                title = title.substring(1, title.length() - 1);
            }

            ItemFactory factory = registry.get(type);
            if (factory != null) {
                items.add(factory.create(title));
            }
        }
        scanner.close();

        for (LibraryItem item : items) {
            System.out.println(item.getTitle() + ": " + item.calculateDueDate(currentDate));
        }
    }
}