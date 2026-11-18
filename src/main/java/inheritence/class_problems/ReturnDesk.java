package inheritence.class_problems;

import java.util.Scanner;

class BookStack {
    private String[] pile;
    private int top;
    private final int capacity;

    public BookStack(int capacity) {
        this.capacity = capacity;
        this.pile = new String[capacity];
        this.top = -1;
    }

    public void push(String book) {
        if (top == capacity - 1) {
            System.out.println(book + " rejected: pile is full");
            return;
        }
        pile[++top] = book;
        System.out.println(book + " placed on pile");
    }

    public void pop() {
        if (top == -1) {
            System.out.println("pile is empty");
            return;
        }
        String book = pile[top--];
        System.out.println("shelved " + book);
    }
}

class StudentQueue {
    private String[] line;
    private int front;
    private int rear;
    private int size;
    private final int capacity;

    public StudentQueue(int capacity) {
        this.capacity = capacity;
        this.line = new String[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(String student) {
        if (size == capacity) {
            System.out.println(student + " rejected: line is full");
            return;
        }
        rear = (rear + 1) % capacity;
        line[rear] = student;
        size++;
        System.out.println(student + " joined the line");
    }

    public void dequeue() {
        if (size == 0) {
            System.out.println("no one waiting");
            return;
        }
        String student = line[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println("served " + student);
    }
}

public class ReturnDesk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder inputBuilder = new StringBuilder();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                break;
            }
            if (inputBuilder.length() > 0) {
                inputBuilder.append(",");
            }
            inputBuilder.append(line);
        }

        if (inputBuilder.length() == 0) {
            scanner.close();
            return;
        }

        BookStack bookPile = new BookStack(3);
        StudentQueue studentLine = new StudentQueue(3);

        String[] commands = inputBuilder.toString().split(",");

        for (String rawCmd : commands) {
            String cmd = rawCmd.trim();
            if (cmd.isEmpty()) {
                continue;
            }

            if (cmd.startsWith("RETURN ")) {
                String book = cmd.substring(7).trim();
                bookPile.push(book);
            } else if (cmd.equals("SHELVE")) {
                bookPile.pop();
            } else if (cmd.startsWith("WAIT ")) {
                String student = cmd.substring(5).trim();
                studentLine.enqueue(student);
            } else if (cmd.equals("SERVE")) {
                studentLine.dequeue();
            }
        }

        scanner.close();
    }
}