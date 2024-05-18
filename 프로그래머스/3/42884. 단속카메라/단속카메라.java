import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int limit = Integer.MIN_VALUE;
        for(int i = 0; i < routes.length; i++) {
            if(limit < routes[i][0]) {
                count++;
                limit = routes[i][1];
            }            
        }
        
        return count;
    }
    
}