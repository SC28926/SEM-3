package inheritence.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private int m1;
    private int m2;
    private int m3;

    public Student(String name) {
        this.name = name;
    }

    public boolean setMarks(int a, int b, int c) {
        if (isValid(a) && isValid(b) && isValid(c)) {
            this.m1 = a;
            this.m2 = b;
            this.m3 = c;
            return true;
        }
        return false;
    }

    private boolean isValid(int mark) {
        return mark >= 0 && mark <= 100;
    }

    public int getTotal() {
        return m1 + m2 + m3;
    }

    public double getAverage() {
        return getTotal() / 3.0;
    }

    public char getGrade() {
        double avg = getAverage();
        if (avg >= 80.0) return 'A';
        if (avg >= 70.0) return 'B';
        if (avg >= 60.0) return 'C';
        if (avg >= 40.0) return 'D';
        return 'F';
    }

    @Override
    public String toString() {
        return String.format("%s total=%d avg=%.2f grade=%c",
                name, getTotal(), getAverage(), getGrade());
    }
}

public class ReportCrd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        List<Student> validStudents = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            Student student = new Student(name);
            if (student.setMarks(a, b, c)) {
                validStudents.add(student);
            } else {
                System.out.println(name + " skipped: marks must be 0 to 100");
            }
        }

        int passes = bubbleSortDescending(validStudents);

        for (int i = 0; i < validStudents.size(); i++) {
            System.out.println((i + 1) + ". " + validStudents.get(i));
        }
        System.out.println("Sorted in " + passes + " passes");

        scanner.close();
    }

    private static int bubbleSortDescending(List<Student> list) {
        int size = list.size();
        int passes = 0;

        for (int i = 0; i < size - 1; i++) {
            boolean swapped = false;
            passes++;

            for (int j = 0; j < size - 1 - i; j++) {
                if (list.get(j).getTotal() < list.get(j + 1).getTotal()) {
                    Student temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }

        return passes;
    }
}