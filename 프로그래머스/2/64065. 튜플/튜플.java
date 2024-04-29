import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        
        s = s.substring(1, s.length() - 1);
        
        List<String[]> subsets = new ArrayList<>();
        
        for(var str : s.split("},")) {
            String[] subset = str.replaceAll("[{}]", "").split(",");            
            subsets.add(subset);
        }
        
        subsets.sort((a, b) -> Integer.compare(a.length, b.length));
        
        Set<String> found = new HashSet<>();
        int[] tuple = new int[subsets.size()];
        
        for(int i = 0; i < subsets.size(); i++) {
            String e = "";
            for(String el : subsets.get(i)) {
                if(!found.contains(el))
                    e = el;   
            }            
            found.add(e);
            tuple[i] = Integer.parseInt(e);
        }
        
        return tuple;
    }
}