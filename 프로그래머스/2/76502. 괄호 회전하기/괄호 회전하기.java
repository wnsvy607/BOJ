import java.util.*;

class Solution {
    public int solution(String s) {
        int cnt = 0;
        
        
        
        for(int i = 0; i < s.length(); i++) {
            String temp = s.substring(1, s.length()) + s.charAt(0);
            s = temp;
            // System.out.println(s);
            
            if(isRight(s))
                cnt++;
        }
        
        
        return cnt;
    }
    
    Stack<Character> stk = new Stack<>();
    
    boolean isRight(String s) {
        stk.clear();
        
        for(char ch : s.toCharArray()) {
            
            if(ch == ']') {
                if(stk.isEmpty() || stk.peek() != '[')
                    return false;
                stk.pop();
                
            } else if(ch == ')') {
                if(stk.isEmpty() || stk.peek() != '(')
                    return false;
                stk.pop();
                
            } else if(ch == '}') {
                if(stk.isEmpty() || stk.peek() != '{')
                    return false;
                stk.pop();
                
            } else if(ch == '[') {
                stk.add('[');
                
                
            } else if(ch == '(') {
                stk.add('(');
                
                
            } else if(ch == '{') {
                stk.add('{');
                
            }
            
            
        }
        
        return stk.isEmpty();
    }
}