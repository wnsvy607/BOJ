import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a , b) -> Integer.compare(b, a));
        
        for(int i = 0; i < works.length; i++) {
            pq.add(works[i]);
        }
        
        
        while(n-- > 0 && !pq.isEmpty()) {
            int max = pq.poll();
            if(max != 1)
                pq.add(max - 1);
        }
        
        while(!pq.isEmpty()) {
            int idx = pq.poll();
            answer += idx * idx;
        }
        
        
        return answer;
    }
}