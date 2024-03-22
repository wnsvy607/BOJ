import java.util.*;

class Solution {
    public long solution(int n, int[] times) {        
        long start = times[0], 
            end = times[0]
                ,mid 
                ,answer;
        
        for(int i = 1; i < times.length; i++ ) {
            start = Math.min(start, times[i]);
            end = Math.max(end, times[i]);
        }
        end = end * n;
        answer = end;
        
        while(start <= end) {
            mid = (start + end) / 2L;
            
            long complete = 0; 
            for(int i = 0; i < times.length; i++ ) {
                complete += (mid / times[i]);
            }
            
            
            if(complete < n)
                start = mid + 1;
            else {
                answer = mid;
                end = mid - 1;
            }
        }
        
        return answer;
    }
}