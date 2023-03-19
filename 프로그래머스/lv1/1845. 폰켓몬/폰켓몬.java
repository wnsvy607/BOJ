import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> monMap = new HashMap<>();
        
        for (int i = 0 ; i < nums.length; i ++) {
            monMap.put(nums[i], monMap.getOrDefault(nums[i], 0) + 1); 
        }
        
        if(monMap.size() <= nums.length / 2 )
            return monMap.size();
        else
            return nums.length / 2;
        
    }
}