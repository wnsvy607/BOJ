import java.util.*;

class Solution {
    public int[] solution(long n) {
        List<Integer> list = new ArrayList<>();
        
        while(n > 0) {
            int num = (int) (n % 10L);
            list.add(num);            
            n = n / 10L;
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}