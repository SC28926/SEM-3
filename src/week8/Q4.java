package week8;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

interface Question {
    String getType();
    double calculateScore();
}

class MCQ implements Question {
    private String correctAnswer;
    private String studentAnswer;
    private double points;

    public MCQ(String correctAnswer, String studentAnswer, double points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public String getType() {
        return "MCQ";
    }

    public double calculateScore() {
        return correctAnswer.equals(studentAnswer) ? points : 0.0;
    }
}

class TF implements Question {
    private String correctAnswer;
    private String studentAnswer;
    private double points;

    public TF(String correctAnswer, String studentAnswer, double points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    @Override
    public String getType() {
        return "TF";
    }

    public double calculateScore() {
        return correctAnswer.equals(studentAnswer) ? points : 0.0;
    }
}

class Essay implements Question {
    private String correctAnswer;
    private String studentAnswer;
    private double points;

    public Essay(String correctAnswer, String studentAnswer, double points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public String getType() {
        return "ESSAY";
    }

    public double calculateScore() {
        String[] keywords = correctAnswer.split(",");
        int matchCount = 0;
        String lowerStudentAnswer = studentAnswer.toLowerCase();

        for (String keyword : keywords) {
            String trimmedKeyword = keyword.trim().toLowerCase();
            if (!trimmedKeyword.isEmpty() && lowerStudentAnswer.contains(trimmedKeyword)) {
                matchCount++;
            }
        }

        if (matchCount >= 2) {
            return points * 0.75;
        } else if (matchCount == 1) {
            return points * 0.50;
        }
        return 0.0;
    }
}

public class Q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = Integer.parseInt(scanner.nextLine().trim());
        List<Question> questions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            List<String> tokens = parseLine(line);

            if (tokens.size() < 5) continue;

            String type = tokens.get(0);
            String correctAnswer = tokens.get(2);
            String studentAnswer = tokens.get(3);
            double points = Double.parseDouble(tokens.get(4));

            if (type.equals("MCQ")) {
                questions.add(new MCQ(correctAnswer, studentAnswer, points));
            } else if (type.equals("TF")) {
                questions.add(new TF(correctAnswer, studentAnswer, points));
            } else if (type.equals("ESSAY")) {
                questions.add(new Essay(correctAnswer, studentAnswer, points));
            }
        }

        double totalScore = 0;
        for (Question question : questions) {
            double score = question.calculateScore();
            totalScore += score;
            System.out.printf("%s: %.2f\n", question.getType(), score);
        }

        System.out.printf("Total Score: %.2f\n", totalScore);
        scanner.close();
    }

    private static List<String> parseLine(String line) {
        List<String> tokens = new ArrayList<>();
        StringBuilder currentToken = new StringBuilder();
        boolean inQuotes = false;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (c == ' ' && !inQuotes) {
                if (currentToken.length() > 0) {
                    tokens.add(currentToken.toString());
                    currentToken.setLength(0);
                }
            } else {
                currentToken.append(c);
            }
        }
        if (currentToken.length() > 0) {
            tokens.add(currentToken.toString());
        }
        return tokens;
    }
}