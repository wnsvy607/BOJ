import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stk = new Stack<>();
        for(int num : arr) {
            if(stk.isEmpty())
                stk.add(num);
            else if(stk.peek() == num)
                continue;
            else
                stk.add(num);
        }
        
        

        return stk.stream().mapToInt(i -> i).toArray();
    }
}