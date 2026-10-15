package Constructor.class_problems;

import java.util.Arrays;

public class Candidate implements Comparable<Candidate> {
    private String name;
    private double cgpa;
    private int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    public static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    public static boolean isEligible(double cgpa, int codingScore) {
        if (isEligible(cgpa)) {
            return true;
        }
        return cgpa >= 6.5 && codingScore >= 50;
    }

    public double getCompositeScore() {
        return (this.cgpa * 10.0) + (this.codingScore * 0.5);
    }

    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.getCompositeScore(), this.getCompositeScore());
    }

    public static String shortlistAndRank(Candidate[] candidates) {
        Candidate[] eligibleList = new Candidate[candidates.length];
        int count = 0;

        for (Candidate c : candidates) {
            if (isEligible(c.cgpa, c.codingScore)) {
                eligibleList[count++] = c;
            }
        }

        Candidate[] resultList = Arrays.copyOf(eligibleList, count);
        Arrays.sort(resultList);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < resultList.length; i++) {
            sb.append(i + 1).append(". ")
              .append(resultList[i].name).append(" (")
              .append(resultList[i].getCompositeScore()).append(")");
            if (i < resultList.length - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
    }
}