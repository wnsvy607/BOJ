import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long start = 0;
        long end = Long.valueOf(times[times.length - 1]) * Long.valueOf(n);
        long ans = end;
        
        while(start <= end) {
            long mid = (start + end) / 2L;
            
            long t = 0;
            
            for(int i = 0; i < times.length; i++ ) {
                t += (mid / times[i]);
            }
            
            if(t < n) {
                start = mid + 1L;
            }
            else {
                ans = mid;
                end = mid - 1L;   
            }
        }
        
        
        return ans;
    }

}