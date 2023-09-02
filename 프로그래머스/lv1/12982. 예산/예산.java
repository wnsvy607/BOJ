import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int n = d.length;

        
        int[] psum = new int[n]; 
        psum[0] = d[0];
        if(psum[0] > budget)
            return 0;
        
        for(int i = 1; i < n; i++) {
            psum[i] = d[i] + psum[i-1];
            if(psum[i] > budget) {
                return i;
            }
        }
                
        return n;
    }
}