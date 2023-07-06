import java.util.*;

class Solution {
    public int solution(int n) {
        
        Set<Integer> divisor = new HashSet<>();
        
        if(n == 1)
            return 1;
        
        for(int i = 1; i < (n / 2) + 1; i++) {
            if(n % i == 0) {
                divisor.add(i);
                divisor.add(n / i);
            }
        }
        
        return divisor.stream().mapToInt(i -> i).sum();
        

    }
}