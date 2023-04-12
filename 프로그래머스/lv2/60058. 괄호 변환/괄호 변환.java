import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = recursive(p);
        
        return answer;
    }
    
    String recursive(String p) {
        if(p.equals(""))
            return "";
        
        int L = 0, R = 0;
        int index = -1;
        for(int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '(')
                L++;
            else
                R++;
            if(L == R) {
                index = i;
                break;
            }
        }
        
        String u = p.substring(0, index + 1);
        String v = recursive(p.substring(index + 1));
        if(!isRight(u)) {
            String tmp = "";
            for(int i = 1; i < u.length() - 1; i++){
                if(u.charAt(i) == '(')
                    tmp += ')';
                else
                    tmp += '(';
            }
            
            return "(" + v + ")" + tmp;
        }
        
        return u + v;
    }
    
    boolean isRight(String p) {
        Stack<Character> stk = new Stack<>();
        
        for(int i = 0; i < p.length() ; i++) {
            char ch = p.charAt(i);
            if(ch == '(')
                stk.add('(');
            else if(stk.isEmpty())
                return false;
            else
                stk.pop();
        }
        
        return true;
    }
}