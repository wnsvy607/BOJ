import java.util.*;

class Solution {
    
    Map<String, Integer> map;
    
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        map = new HashMap<>();
        
        for(int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        for(int i = 0; i < answer.length; i++) {
            answer[i] = miss(photo[i]);
        }
        
        
        return answer;
    }
    
    public int miss(String[] names) {
        int res = 0;
        
        for(String name : names) {
            res += miss(name);
        }
        
        return res;
    }
    
    public int miss(String name) {
        return map.getOrDefault(name, 0);
    }
}