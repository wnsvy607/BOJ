import java.util.*;

class Solution {    
    
    public int solution(String s) {
        String[] eng = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i = 0; i < 10; i++) 
            s = s.replace(eng[i], ((Integer)i).toString());
        
        return Integer.parseInt(s);
    }
}