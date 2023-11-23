class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        
        
    
        int goalA = 0;
        int goalB = 0;
        for(int i = 0; i < problems.length; i++) {
            goalA = Math.max(problems[i][0], goalA);
            goalB = Math.max(problems[i][1], goalB);
        }
        
        if(goalA <= alp && goalB<=cop){
            return 0;
        }
        
        if(alp >= goalA){
            alp = goalA;
        }
        
        if(cop >=goalB){
            cop = goalB;
        }
        
        int[][] dp = new int[220][220];
        
        for(int i = alp; i < 200; i++) {
            for(int j = cop; j < 200; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[alp][cop] = 0;
    
        
        for(int i = alp; i < 181; i++) {
            for(int j = cop; j < 181; j++) {
                dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j] + 1);
                dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j] + 1);
                
                for(int[] prob : problems) {
                    if(i >= prob[0] && j >= prob[1]) {
                        int a = i + prob[2];
                        if(a > goalA)
                            a = goalA;
                        int b = j + prob[3];
                        if(b > goalB)
                            b = goalB;
                        
                        dp[a][b] = Math.min(dp[a][b], dp[i][j] + prob[4]);   
                    }
                }
                
            }
        }
        
        
        
        
        return dp[goalA][goalB];
    }
}