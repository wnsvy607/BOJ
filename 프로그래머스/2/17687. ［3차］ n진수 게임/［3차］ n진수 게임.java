import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        int num = 1;
        int lim = t * m;
        Stack<Character> stk = new Stack<>();
        stk.add('0');
        char[] ch = new char[lim];
        
        
        for(int i = 0; i < lim; i++) {
            if(stk.isEmpty()) {
                int temp = num++;
                while(temp > 0) {
                    int mod = temp % n;
                    stk.add(getChar(mod, n));
                    temp = temp / n;
                }
            }
            ch[i] = stk.pop();
        }
        
        for(int i = 0; i < t; i++) {
            answer += ch[m * i + p - 1];
        }
        
        
        return answer.toUpperCase();
    }
    
    char getChar(int mod, int n) {
        return Character.forDigit(mod, n); 
    }
    
    
}