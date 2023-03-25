import java.util.*;
class Solution {
    
    private static int answer = 1;
    
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        

        
        for(int i = 0; i < clothes.length ; i++) {
            map.put(clothes[i][1] , map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        map.entrySet().forEach(e -> answer *= (e.getValue() + 1));
        
        return answer - 1;
        
        
    }
}