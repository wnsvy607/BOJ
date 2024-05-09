class Solution {
    public int solution(int[] tp) {
        
        int[][] bounds = new int[10_001][2];
        
        
        int left = 0;
        int right = 1;
        int s = tp[0];
        
        for(int i = 1; i < tp.length; i++) {
            if(bounds[tp[i]][0] == 0 && tp[i] != s) {
                bounds[tp[i]][0] = i;
                right++;
            }
                
            bounds[tp[i]][1] = i;
        }
        
        int count = 0;
        
        for(int i = 0; i < tp.length; i++) {
            // i번째를 왼쪽으로 옮긴다.
            int top = tp[i];
            
            // i번째 토핑의 마지막이었을 경우
            if(bounds[top][1] == i) {
                right--;
            }
            
            // i번째 토핑의 시작일 경우
            if(bounds[top][0] == i) {
                left++;
            }
            
            if(left == right)
                count++;
        }
        
        return count;
    }
}