package week7;

public class PiggyBank {
    private final String id;
    private double savings;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.savings += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount <= this.savings) {
            this.savings -= amount;
        } else {
            System.out.println("pb.withdraw(" + (int)amount + ") -> rejected, savings stays " + (int)this.savings);
        }
    }

    public double getSavings() {
        return this.savings;
    }

    public String getId() {
        return this.id;
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        
        pb.deposit(100);
        System.out.println("pb.deposit(100) -> savings = " + (int)pb.getSavings());

        pb.withdraw(30);
        System.out.println("pb.withdraw(30) -> savings = " + (int)pb.getSavings());

        pb.withdraw(500);
    }
}