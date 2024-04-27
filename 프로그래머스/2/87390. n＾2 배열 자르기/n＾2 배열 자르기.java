import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        
        
        int len = (int) (right - left + 1L);
        
        int[] arr = new int[len];
        
        for(long i = left; i <= right; i++) {
            long r = i / n;
            long c = i % n;
            Long max = Math.max(r, c) + 1L;
            int idx = (int) (i - left);
            arr[idx] = max.intValue();
        }
    
        return arr;
    }
}