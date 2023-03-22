import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String player : participant){
            map.put(player, map.getOrDefault(player, 0) + 1);
        }
        
        for (String player : completion){
            map.put(player, map.get(player) - 1);
        }

        
        Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry<String, Integer> next = iter.next();
            
            if( next.getValue() > 0 ) {
                return next.getKey();
            }
        }
        
        return "";

    }
}