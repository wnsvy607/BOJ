import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] nums = new String[numbers.length];
        
        int index = 0;
        for(int i : numbers) {
            nums[index++] = String.valueOf(i);
        }
        
        Arrays.sort(nums, (a, b) -> {
                Long forward = Long.parseLong(a + b);
                Long back = Long.parseLong(b + a);
                if(forward > back)
                    return -1;                                        
                else if(forward == back) {
                    if(a.length() > b.length())
                        return -1;
                    else if(a.length() == b.length())
                        return 0;
                    else
                        return 1;
                }
          
                else  
                    return 1;                    
                
        });
        
        StringBuilder sb = new StringBuilder();
        for(String s : nums) {
            sb.append(s);
        }
        
        String answer = sb.toString();
        
        if(answer.charAt(0) == '0')
            return "0";
        
        return answer;
    }
}