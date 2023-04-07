import java.util.*;

class Solution {
    public int solution(int[] c) {
        Arrays.sort(c);
        int answer = 0;
        int h = 0;
        while(true) {
            int big = 0;
            
            for(int i = 0; i < c.length ; i++) {
                if(h <= c[i])
                    big++;
            }
            
            if(h <= big)
                h++;
            else
                break;
        }
        
        
        return h - 1;
    }
}