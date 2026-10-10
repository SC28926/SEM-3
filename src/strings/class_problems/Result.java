package strings.class_problems;

import java.util.Scanner;

class Student {
    private String name;
    private int[] marks;

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public double calculateAverage() {
        double sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return sum / marks.length;
    }

    public char determineGrade(double average) {
        if (average >= 75) {
            return 'B';
        } else if (average >= 60) {
            return 'C';
        } else if (average >= 40) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public void printResultCard() {
        double average = calculateAverage();
        char grade = determineGrade(average);
        System.out.printf("%s: Average %.1f, Grade %c\n", name.toUpperCase(), average, grade);
    }
}

public class Result {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNext()) {
            String name = scanner.next();
            int[] marks = new int[3];
            for (int i = 0; i < 3; i++) {
                marks[i] = scanner.nextInt();
            }
            
            Student student = new Student(name, marks);
            student.printResultCard();
        }
        
        scanner.close();
    }
}
