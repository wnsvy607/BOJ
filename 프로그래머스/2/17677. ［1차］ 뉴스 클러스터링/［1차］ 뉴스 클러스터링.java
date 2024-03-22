import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> A = getCollection(str1);
        Map<String, Integer> B = getCollection(str2);
        
        Map<String, Integer> common = new HashMap<>(A);
        
        
        for(var el: B.entrySet()) {
            String key = el.getKey();
            if(common.containsKey(key)) {
                common.put(key, Math.min(common.get(key), el.getValue()));
            } 
        }
        
        for(var el: A.entrySet()) {
            String key = el.getKey();
            if(common.containsKey(key) && !B.containsKey(key)) 
                common.remove(key);
        }
        
        int c = 0;
        
        for(var el: common.entrySet()) {
            c += el.getValue();
        }
        
        
        Map<String, Integer> sum = new HashMap<>(A);
        
        for(var el: B.entrySet()) {
            String key = el.getKey();
            int value = el.getValue();
            if(sum.containsKey(key)) {
                sum.put(key, Math.max(sum.get(key), value));
            } else {
                sum.put(key, value);
            }
        }
        
        int s = 0;
        
        for(var el: sum.entrySet()) {
            s += el.getValue();
        }
        
        if(s == 0)
            return 65536;
        
        double answer = 65536 * c / s;
        
        return (int) answer;
    }
    
    public Map<String, Integer> getCollection(String str) {
        Map<String, Integer> result = new HashMap<>();
        int len = str.length() - 1;
        for(int i = 0; i < len; i++) {
            String element = str.substring(i, i + 2).toUpperCase();
            if(!element.matches("[A-Z]{2}+")) {
                continue;
            }
            
            result.put(element, result.getOrDefault(element, 0) + 1);
        }
        return result;
    }
}