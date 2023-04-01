import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    int answer = 0;
    
    public int solution(String numbers) {
            
        recursive("", numbers);
        
        for(Integer num : set) {
            if(num <= 1)
                continue;
            boolean isPrimary = true;
            for(int i = 2; i < (int) Math.sqrt(num) + 1 ; i++) {
                if(num % i == 0) {
                    isPrimary = false;
                    break;                    
                }
            }
            if(isPrimary)
                answer++;
        }
          
        return answer;
        
    }
    
    public void recursive(String combi, String others) {
        if(!combi.equals(""))
            set.add(Integer.valueOf(combi));
        
        for(int i = 0; i < others.length(); i++) {
            recursive(combi + others.charAt(i), others.substring(0, i) + others.substring(i + 1));
        }
    }
    
    
}