import java.util.*;

class Solution {
    
    Set<Integer> primeNums;
    int answer = 0;
    
    public int solution(int[] nums) {
        
        primeNums = new HashSet<>();
        
        Arrays.sort(nums);
        
        int n = nums.length;
        int maxVal = nums[n-1] + nums[n-2] + nums[n-3];
        
        getPrimNums(maxVal);
        
        combi(nums, new boolean[n], n, 3, 0, 0);
        
        return answer;
    }
    
    void combi(int[] nums, boolean[] visited, int n, int r, int result, int start) {
        if(r == 0) {
            if(primeNums.contains(result)) {
                answer++;            
            }
            return;
        }
        
        for(int i = start; i < n; i++) {
            if(visited[i])
                continue;
            visited[i] = true;
            combi(nums, visited, n, r - 1, result + nums[i], i);
            visited[i] = false;
        }
    }
    
    
    
    void getPrimNums(int maxVal) {
        for(int i = 2; i <= maxVal; i++) {
            boolean isPrime = true;
            for(int j = 2; j * j <= i; j++) {
                if(i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime)
                primeNums.add(i);
        }     
    }
}