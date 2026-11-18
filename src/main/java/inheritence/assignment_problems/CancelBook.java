package inheritence.assignment_problems;

import java.util.Scanner;

class Nod {
    String data;
    Node next;

    Nod(String data) {
        this.data = data;
        this.next = null;
    }
}

public class CancelBook {

    public static Node removeFirst(Node head, String booking) {
        if (head == null) {
            System.out.println(booking + " not found");
            return null;
        }

        if (head.data.equals(booking)) {
            return head.next;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data.equals(booking)) {
                current.next = current.next.next;
                return head;
            }
            current = current.next;
        }

        System.out.println(booking + " not found");
        return head;
    }

    public static void printBookings(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        Node head = null;
        Node tail = null;

        for (int i = 0; i < n; i++) {
            Node newNode = new Node(scanner.next());
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        if (!scanner.hasNext()) {
            return;
        }
        String cancelBooking = scanner.next();

        head = removeFirst(head, cancelBooking);
        printBookings(head);

        scanner.close();
    }
}