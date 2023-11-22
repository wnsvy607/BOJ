import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int len = survey.length;
        Map<String, Integer> map = new HashMap<>();
        String[][] arr = {{"R", "T"}, {"C", "F"}, {"J", "M"}, {"A", "N"}};
        
        
        
        for(String[] a : arr) {
            for(String ch : a ) {
                map.put(ch, 0);            
            }
        }
        
        
    
        for(int i = 0; i < len; i++ ) {
            String sur = survey[i];
            String f = sur.substring(0, 1);
            String b = sur.substring(1, 2);
            int choice = choices[i];
            
            if(choice < 4) {
                map.put(f, map.get(f) + 4 - choice);
                continue;
            }
            
            if(choice > 4) {
                map.put(b, map.get(b) + choice - 4);
            }
            
            
        }
        
        StringBuilder sb = new StringBuilder();
        for(String[] type : arr) {
            int fscore = map.get(type[0]);
            int bscore = map.get(type[1]);
            
            if(fscore >= bscore) {
                sb.append(type[0]);
            } else {
                sb.append(type[1]);
            }
            
        }
        
        return sb.toString();
    }
}