package inheritence.assignment_problems;

import java.util.Scanner;

class Nodes {
    String data;
    Node next;

    Nodes(String data) {
        this.data = data;
        this.next = null;
    }
}

public class StudentLine {

    public static Node addFirst(Node head, String name) {
        Node newNode = new Node(name);
        newNode.next = head;
        return newNode;
    }

    public static Node addLast(Node head, String name) {
        Node newNode = new Node(name);
        if (head == null) {
            return newNode;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return head;
    }

    public static void printLine(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node head = null;

        if (!scanner.hasNextInt()) {
            return;
        }
        int initialCount = scanner.nextInt();
        for (int i = 0; i < initialCount; i++) {
            head = addLast(head, scanner.next());
        }

        if (!scanner.hasNextInt()) {
            return;
        }
        int opCount = scanner.nextInt();
        for (int i = 0; i < opCount; i++) {
            String op = scanner.next();
            String name = scanner.next();

            if (op.equalsIgnoreCase("addFirst")) {
                head = addFirst(head, name);
            } else if (op.equalsIgnoreCase("addLast")) {
                head = addLast(head, name);
            }
        }

        printLine(head);
        scanner.close();
    }
}