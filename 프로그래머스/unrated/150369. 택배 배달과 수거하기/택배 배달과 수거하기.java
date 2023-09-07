class Solution {
    public long solution(int cap, int n, int[] del, int[] pick) {
        long answer = 0;
        
        int lastD = n - 1;
        while(lastD != -1 && del[lastD] == 0)
            lastD--;
        
        int lastP = n - 1;        
        while(lastP != -1 && pick[lastP] == 0)
            lastP--;
        
        
        while(lastD != -1 || lastP != -1) {
            // 출발
            answer += (Math.max(lastD, lastP) + 1) * 2;
            
            int leftD = cap;
            int i;
            for(i = lastD; i >= 0 ;i--) {
                if(leftD == 0 && del[i] > 0) 
                    break;
                
                
                if(leftD < del[i]) {
                    del[i] -= leftD;
                    break;
                } else {
                    leftD -= del[i];
                    del[i] = 0;
                } 
            }
            if(i == 0 && del[i] == 0)
                lastD = -1;
            else
                lastD = i;
            
            
            
            int leftP = cap;
            int j;
            // 복귀
            for(j = lastP; j >=0 ;j--) {
                if(leftP == 0 && pick[j] > 0)
                    break;
                
                if(leftP < pick[j]){
                    pick[j] -= leftP;
                    break;
                } else {
                    leftP -= pick[j];
                    pick[j] = 0;
                }
            }
            if(j == 0 && pick[j] == 0)
                lastP = -1;
            else
                lastP = j;  
        }
        
        return answer;
    }
}