class Solution
{
    

    
    
    public int solution(int [][]board)
    {
        int m = board.length, n = board[0].length;
        int dp[][] = new int[m + 1][n + 1];
        int max = 0;
        
        
        for(int i = 1; i < m + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                if(board[i-1][j-1] == 0)
                    continue;
                int res = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                dp[i][j] = res + 1;
                max = Math.max(dp[i][j], max);
            }
        }
            

        return max * max;
    }

    
    
    
}