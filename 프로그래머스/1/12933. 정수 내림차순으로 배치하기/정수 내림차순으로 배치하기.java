import java.util.*;

class Solution {
    public long solution(long n) {
        
        PriorityQueue<Long> pq = new PriorityQueue<>((a, b) -> Long.compare(b, a));
        
        while(n > 0) {
            pq.add(n % 10);
            n = n / 10;
        }
        
        long answer = 0;
        
        while(!pq.isEmpty()) {
            long x = pq.poll();
            answer = x + answer * 10;
        }
        
        
        return answer;
    }
}