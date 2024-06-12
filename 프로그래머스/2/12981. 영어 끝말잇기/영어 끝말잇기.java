import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        
        Set<String> set = new HashSet<>();
        
        int idx = 1;
        String prev = words[0];
        set.add(prev);
        
        while(idx < words.length) {
            String word = words[idx];
            if(set.contains(word) || prev.charAt(prev.length() - 1) != word.charAt(0)) {
                return new int[]{(idx % n) + 1, (idx / n) + 1};
            }
            set.add(word);
            prev = word;
            idx++;
        }
        
        
        


        return new int[]{0 , 0};
    }
}