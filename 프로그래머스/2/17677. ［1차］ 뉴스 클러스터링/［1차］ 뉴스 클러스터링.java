import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        Map<String, Integer> A = new HashMap<>();
        Map<String, Integer> B = new HashMap<>();
        Set<String> set = new HashSet<>();
        
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        // System.out.println(str1);
        // System.out.println(str2);
        
        
        for(int i = 0; i < str1.length() - 1; i++) {
            String el = str1.substring(i, i + 2);
            if(!el.matches("[a-zA-Z]+"))
                continue;
            System.out.println(el);
            A.put(el, A.getOrDefault(el, 0) + 1);            
            set.add(el);
        }
        
        for(int i = 0; i < str2.length() - 1; i++) {
            String el = str2.substring(i, i + 2);
            if(!el.matches("[a-zA-Z]+"))
                continue;
            B.put(el, B.getOrDefault(el, 0) + 1);
            set.add(el);
        }        
        
        if(set.isEmpty())
            return 65536;
        
        int intersection = 0;
        
        for(var el : set) {
            if(A.containsKey(el) && B.containsKey(el)) {
                intersection += Math.min(A.get(el), B.get(el));
            }
        }
        
        int union = 0;
        for(var el : set) {
            int a = A.containsKey(el) ? A.get(el) : 0;
            int b = B.containsKey(el) ? B.get(el) : 0;
            
            union += Math.max(a, b);

        }
        
        
        
        return 65536 * intersection / union;
    }
}