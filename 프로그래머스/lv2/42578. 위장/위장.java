import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        

        
        for(int i = 0; i < clothes.length ; i++) {
            map.put(clothes[i][1] , map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        int answer = 1;
        
        Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
        
        while(iter.hasNext()) {
            int n = iter.next().getValue();
            answer *= (n + 1);
        }
        
        
        return answer - 1;
        
        
    }
}