class Solution {
    
    static int s = 1, e = 1, count = 0;
    
    public int solution(int n) {
        int sum = 1;
        
        while(s <= n && e <= n) {
            
            if(sum < n){
                sum += ++e;
                continue;
            }
            if(sum == n)
                count++;
            sum -= s++;
        }
        
        
        return count;
    }
}