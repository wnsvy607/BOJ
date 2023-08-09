import java.util.*;

class Solution {
    public long[] solution(int x, int n) {   
        List<Long> list = new ArrayList<>();
        
        long buffer = (long) x;
        for(int i = 0; i < n; i++) {
            list.add(buffer);
            buffer += x;
        }
        
        
        return list.stream().mapToLong(i -> i).toArray();
    }
}