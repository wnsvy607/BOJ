class Solution {
    public int[] solution(int n, int s) {
        int dq = s / n;
        if(dq < 1)
            return new int[]{-1};
        int mod = s % n;
        
        
        int[] answer = new int[n];
        
        for(int i = 0; i < n - mod; i++) {
            answer[i] = dq;
        }
        
        for(int i = n - mod; i < n; i++) {
            answer[i] = dq + 1;
        }
        
        
        return answer;
    }
}