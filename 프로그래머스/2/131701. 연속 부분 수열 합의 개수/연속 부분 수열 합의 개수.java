import java.util.*;

class Solution {
    
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        
        int len = elements.length;
        
        for(int i = 0; i < len; i++) {
            int val = 0;
            for(int j = 0; j < len; j++) {
                int idx = (i + j) % len;
                val += elements[idx];
                set.add(val);
            }
        }
        
        return set.size();
    }
}