import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stk = new Stack<>();
        
        for(char ch : s.toCharArray()) {
            if(stk.isEmpty())
                stk.add(ch);
            else if(stk.peek() == '(' && ch == ')')
                stk.pop();
            else
                stk.add(ch);
            
        }
        
        
        if(!stk.isEmpty())
            answer = false;
        
        return answer;
    }
}