import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        
        int[] onGoing = new int[N+2];
        int[] total = new int[N+2];
        
        for(int stage: stages) {
            onGoing[stage]++;
            for(int i = 1; i <= stage; i++) {
                total[i]++;
            }
        }
        
        double[][] result = new double[N][2];
            
        for(int i = 1; i <= N; i++) {
            result[i-1][0] = (double) i;
            if(total[i] == 0)
                result[i-1][1] = 0D;
            else {
                double rate = ((double) onGoing[i]) / total[i];
                result[i-1][1] = rate;                
            }
        }
        
        Arrays.sort(result, (a, b) -> {
            if(a[1] == b[1]) 
                return (int) (a[1] - b[1]);
            
            if(a[1] > b[1])
                return -1;
            return 1;
        });
        
        int[] answer = new int[N];        
        for(int i = 0; i < N; i++) {
            answer[i] = (int) result[i][0];
        }
        
        return answer;
    }
}