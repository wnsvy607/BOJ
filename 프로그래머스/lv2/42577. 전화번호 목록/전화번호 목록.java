import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < phone_book.length ; i ++) {
            map.put(phone_book[i] , 0);
        }
        
        for (String p : phone_book) {
            for(int i = 1 ; i < p.length(); i++) {
                if(map.containsKey(p.substring(0, i)))
                    return false;
            }
        }
        
        return true;
    }
}