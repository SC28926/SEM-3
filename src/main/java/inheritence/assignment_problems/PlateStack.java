package inheritence.assignment_problems;

import java.util.Scanner;

class Note {
    String data;
    Node next;

    Note(String data) {
        this.data = data;
        this.next = null;
    }
}

public class PlateStack {
    private Node top;
    private int size;

    public PlateStack() {
        this.top = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(String plate) {
        Node newNode = new Node(plate);
        newNode.next = top;
        top = newNode;
        size++;
        System.out.println("push " + plate + " -> top " + top.data + ", size " + size);
    }

    public String pop() {
        if (isEmpty()) {
            System.out.println("pop -> stack is empty");
            return null;
        }
        String poppedPlate = top.data;
        top = top.next;
        size--;
        System.out.println("pop -> " + poppedPlate + ", size " + size);
        return poppedPlate;
    }

    public String peek() {
        if (isEmpty()) {
            System.out.println("peek -> stack is empty");
            return null;
        }
        System.out.println("peek -> " + top.data);
        return top.data;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PlateStack stack = new PlateStack();

        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            String op = scanner.next();
            if (op.equalsIgnoreCase("push")) {
                String plate = scanner.next();
                stack.push(plate);
            } else if (op.equalsIgnoreCase("pop")) {
                stack.pop();
            } else if (op.equalsIgnoreCase("peek")) {
                stack.peek();
            } else if (op.equalsIgnoreCase("isEmpty")) {
                System.out.println("isEmpty -> " + stack.isEmpty());
            }
        }

        scanner.close();
    }
}