import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[x] = 0;
        PriorityQueue<Try> pq = new PriorityQueue<>(); 
        pq.add(new Try(x, 0));
        
        while(!pq.isEmpty()) {
            Try t = pq.poll();
            if(t.num == y)
                return t.dist;
            
            if(t.num + n <= y && dp[t.num + n] > t.dist + 1) {
                dp[t.num + n] = t.dist + 1;
                pq.offer(new Try(t.num + n, dp[t.num + n]));
            }
            
            if(t.num * 2 <= y && dp[t.num * 2] > t.dist + 1) {
                dp[t.num * 2] = t.dist + 1;
                pq.offer(new Try(t.num * 2, dp[t.num * 2]));
            }
            
            if(t.num * 3 <= y && dp[t.num * 3] > t.dist + 1) {
                dp[t.num * 3] = t.dist + 1;
                pq.offer(new Try(t.num * 3, dp[t.num * 3]));
            }
        }
        
        return -1;
    }
    
    class Try implements Comparable<Try> {
        
        int num;
        int dist;
        
        Try(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
        
        
        @Override
        public int compareTo(Try t) {
            if(this.dist == t.dist)
                return Integer.compare(t.num, this.num);
            return Integer.compare(this.dist, t.dist);
        }
    }
 }