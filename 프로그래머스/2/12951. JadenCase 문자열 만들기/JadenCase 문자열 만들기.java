import java.util.*;

class Solution {
    public String solution(String s) {
        // s == " " 일 경우 처리가 필요없음
        if(s.isBlank())
            return " ";
        
        
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(var word: words) {
            // 문자 처음과 끝 띄어쓰기 핸들링
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