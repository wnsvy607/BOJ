import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(String key : keymap) {
            for(int i = 0; i < key.length(); i++) {
                char ch = key.charAt(i);
                if(!map.containsKey(ch) || (map.containsKey(ch) && map.get(ch) > i + 1) ) 
                {
                    map.put(ch, i + 1);
                    continue;
                }
            }
        }
        
        
        
        int[] answer = new int[targets.length];
        
        for(int i = 0; i < targets.length; i++) {
            int cnt = 0;
            String target = targets[i];
            
            for(int j = 0; j < target.length(); j++) {
                char ch = target.charAt(j);
                if(!map.containsKey(ch)) {
                    cnt = -1;
                    break;
                }
                cnt += map.get(ch);
            }
            
            answer[i] = cnt;
        }
        
        return answer;
    }
}