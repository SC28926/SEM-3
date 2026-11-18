package inheritence.assignment_problems;

import java.util.Scanner;

class Nodee {
    String data;
    Node next;

    Nodee(String data) {
        this.data = data;
        this.next = null;
    }
}

public class LibraryTrolley {

    public static String find(Node head, String id) {
        Node current = head;
        int position = 1;
        int firstPosition = -1;
        int copies = 0;

        while (current != null) {
            if (current.data.equals(id)) {
                if (firstPosition == -1) {
                    firstPosition = position;
                }
                copies++;
            }
            position++;
            current = current.next;
        }

        if (copies == 0) {
            return id + " not found";
        }

        return id + " first at position " + firstPosition + ", copies: " + copies;
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
        String targetId = scanner.next();

        System.out.println(find(head, targetId));
        scanner.close();
    }
}