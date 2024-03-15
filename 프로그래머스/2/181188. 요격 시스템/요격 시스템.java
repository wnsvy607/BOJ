import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        // 폭격 미사일
        Arrays.sort(targets, (int[] a, int[] b) -> {
            if (a[0] - b[0] == 0) return b[1] - a[1];
            return a[0] - b[0];
        });

        return check(targets);
    }
    
    int check(int[][] targets) {
        
        int count = 1;
        
        int s = 0;
        int e = 1000000000;
        
        for (int[] target : targets) {
            int curS = target[0];
            int curE = target[1];
            
            if (curS >= s && curE <= e) {
                s = curS;
                e = curE;
                continue;
            } 
            
            if (curS < e && curE >= e) {
                s = curS;
            }
            
            if (e <= curS) {
                s = curS;
                e = curE;
                count += 1;
            }
        }
        
        return count;
    }
}