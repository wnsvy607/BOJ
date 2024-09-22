class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        
        int s = 1, e = 100_000, m = 0;
        int ans = e;
        
        while(s < e) {
            m = (s + e) / 2;
            
            long tts = simulate(m, diffs, times);
            
            if(tts <= limit) {
                ans = Math.min(ans, m);
                e = m;
            }
            else
                s = m + 1;
        }
    
        
        return ans;
    }
    
    
    
    long simulate(int level, int[] diffs, int[] times) {
        int n = diffs.length;
        long total = 0;
        
        for(int i = 0; i < n; i++) {
            
            if(diffs[i] > level) {
                int wrong = diffs[i] - level;
                int time_prev = i > 0 ? times[i - 1] : 0;
                
                total += wrong * (times[i] + time_prev);
            }
            total += times[i];
            
        }
        
        return total;
    }
    
}