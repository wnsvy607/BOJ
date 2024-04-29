import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> need = new HashMap<>();
        Map<String, Integer> items = new HashMap<>();
        for(int i = 0; i < want.length; i++) {
            need.put(want[i], number[i]);
        }
        int len = discount.length;
        
        for(int i = 0; i < 10; i++) {
            items.put(discount[i], items.getOrDefault(discount[i], 0) + 1);
        }
        if(check(need, items))
            answer++;
        
        for(int s = 1; s < len - 9; s++) {
            // 삭제
            int prev = items.get(discount[s - 1]);
            if(prev > 1)
                items.put(discount[s - 1], prev - 1);
            else
                items.remove(discount[s - 1]);
            
            // 추가
            items.put(discount[s + 9], items.getOrDefault(discount[s + 9], 0) + 1);
            
            if(check(need, items)) {
                answer++;
            }
        }

        return answer;
    }
    
    boolean check(Map<String, Integer> need, Map<String, Integer> items) {
        
        for(var e : need.entrySet()) {
            if(!items.containsKey(e.getKey()))    
                return false;
            
            int ava = items.get(e.getKey());
            
            if(e.getValue() > ava) {
                return false;
            }
            
        }
        
        return true;
    }
    
    
}