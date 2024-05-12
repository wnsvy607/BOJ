import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];
        
        boolean[][] p = new boolean[n][m];
        
        for(int[] pud : puddles) {
            p[pud[1] - 1][pud[0] - 1] = true;
        }
        
        for(int i = 0; i < m; i++) {
            if(p[0][i])
                break;
            dp[0][i] = 1;
        }
        
        for(int i = 0; i < n; i++) {
            if(p[i][0])
                break;
            dp[i][0] = 1;
        }
        

        

        
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(p[i][j])
                    continue;
                dp[i][j] = (dp[i-1][j] + dp[i][j - 1]) % 1_000_000_007;
            }
        }
        
        return dp[n-1][m-1];
    }
}