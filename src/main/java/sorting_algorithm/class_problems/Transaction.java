package sorting_algorithm.class_problems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Transaction {

    public static boolean hasDuplicate(List<String> transactionIds) {
        if (transactionIds == null || transactionIds.isEmpty()) {
            return false;
        }

        Set<String> seenIds = new HashSet<>();
        for (String id : transactionIds) {
            if (!seenIds.add(id)) {
                return true; 
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<String> batch1 = List.of("TXN1001", "TXN1002", "TXN1003", "TXN1002", "TXN1004");
        List<String> batch2 = List.of("TXN2001", "TXN2002", "TXN2003");

        System.out.println(hasDuplicate(batch1)); 
        System.out.println(hasDuplicate(batch2)); 
    }
}