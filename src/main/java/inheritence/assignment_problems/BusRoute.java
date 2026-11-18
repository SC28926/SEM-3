package inheritence.assignment_problems;

import java.util.Scanner;

class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

public class BusRoute {

    public static Node build(String[] stops) {
        if (stops == null || stops.length == 0) {
            return null;
        }

        Node head = new Node(stops[0]);
        Node tail = head;

        for (int i = 1; i < stops.length; i++) {
            tail.next = new Node(stops[i]);
            tail = tail.next;
        }

        return head;
    }

    public static void printRoute(Node head) {
        if (head == null) {
            return;
        }

        Node current = head;
        int count = 0;
        String first = head.data;
        String last = head.data;

        while (current != null) {
            System.out.print(current.data + " -> ");
            last = current.data;
            count++;
            current = current.next;
        }
        System.out.println("null");
        System.out.println("Stops: " + count + ", First: " + first + ", Last: " + last);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextLine()) {
            return;
        }

        String line = scanner.nextLine().trim();
        if (line.isEmpty()) {
            return;
        }

        String[] stops = line.split("\\s+");

        Node head = build(stops);
        printRoute(head);

        scanner.close();
    }
}