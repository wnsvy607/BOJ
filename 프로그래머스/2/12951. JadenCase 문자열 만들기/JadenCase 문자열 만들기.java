import java.util.*;

class Solution {
    public String solution(String s) {
        if(s.equals(" "))
            return " ";
        
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(var word: words) {
            if(word.length() < 1) {
                sb.append(' ');
                continue;
            } 
            word = word.toLowerCase();
            sb.append(Character.toUpperCase(word.charAt(0)));
            if(word.length() > 1)
                sb.append(word.substring(1, word.length()));
            sb.append(' ');
        }
        
        sb.delete(s.length(), s.length() + 1);
        
        return sb.toString();
    }
}