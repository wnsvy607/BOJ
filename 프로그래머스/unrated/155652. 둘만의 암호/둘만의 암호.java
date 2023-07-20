import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String buffer = "";
        
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        
        for(int i = 0; i < skip.length(); i++) {
            char ch = skip.charAt(i);
            alphabet = alphabet.replace(String.valueOf(ch),"");
        }
        
        for(int i = 0; i < s.length(); i++) {
            int num = alphabet.indexOf(s.charAt(i)) + index;
            buffer += alphabet.charAt(num % alphabet.length());
        }
        
        
        
        
        // System.out.println(alphabet);
        
        
        return buffer;
    }
}