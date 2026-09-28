package week7.assigment_problems;

public class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        if (password == null) {
            return "Weak";
        }
        
        int length = password.length();
        
        if (length < 6) {
            return "Weak";
        } else if (length <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    public static void main(String[] args) {
        PasswordChecker pc = new PasswordChecker("abcd");
        System.out.println("Password 'abcd' strength: " + pc.getStrength());

        PasswordChecker pc2 = new PasswordChecker("abcdefghij");
        System.out.println("Password 'abcdefghij' strength: " + pc2.getStrength());
    }
}