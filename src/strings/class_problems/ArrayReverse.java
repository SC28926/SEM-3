package strings.class_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayReverse {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(11, 22, 33, 44));
        
        int left = 0;
        int right = list.size() - 1;
        
        while (left < right) {
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            
            left++;
            right--;
        }
        
        System.out.println(list);
    }
}