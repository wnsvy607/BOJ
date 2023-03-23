import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();
        
        Arrays.sort(phone_book);
        
        
        for (String p : phone_book) {
            for(int i = 1 ; i < p.length() + 1 ; i++) {
                String sub = p.substring(0, i);
                if(map.containsKey(sub))
                    return false;
            }
            map.put(p, 0);
        }
        
        return true;
    }
}