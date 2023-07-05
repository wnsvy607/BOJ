class Solution {
    public int solution(String s) {
        int a, b;
        int cnt = 0;
        while(s.length() > 0) {
            char x = s.charAt(0);
            a = 0; b = 0;
            int i;

            for(i = 0; i < s.length(); i++) {
                if(x == s.charAt(i))
                    a++;
                else
                    b++;
                
                if(a == b) 
                    break;           
            }
            cnt++;
            if(a + b == s.length())            
                break;
            if(a == b) 
                s = s.substring(i + 1);
            
        }
        return cnt;
    }
}