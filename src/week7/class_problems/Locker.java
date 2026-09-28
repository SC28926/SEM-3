package week7.class_problems;

public class Locker {
    private final int lockerNumber;
    private String combinationCode;

    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.combinationCode = initialCode;
    }

    public void changeCode(String currentCode, String newCode) {
        if (this.combinationCode.equals(currentCode)) {
            this.combinationCode = newCode;
            System.out.println("l.changeCode(\"" + currentCode + "\", \"" + newCode + "\") -> success");
        } else {
            System.out.println("l.changeCode(\"" + currentCode + "\", \"" + newCode + "\") -> rejected, code is still \"" + this.combinationCode + "\"");
        }
    }

    public int getLockerNumber() {
        return this.lockerNumber;
    }

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        
        l.changeCode("1234", "5678");
        l.changeCode("0000", "9999");
    }
}