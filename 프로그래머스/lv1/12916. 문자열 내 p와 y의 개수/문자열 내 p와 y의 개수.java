class Solution {
    boolean solution(String s) {
        
        s = s.toLowerCase();
        
        int p = 0;
        int y = 0;
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == 'p')
                p++;
            if(ch == 'y')
                y++;
        }
        

        return p == y;
    }
}