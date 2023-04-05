class Solution {
    
    boolean[] visited;
    int n;
    
    public int solution(String name) {
        n = name.length();
        String input = "";
        for(int i = 0; i < n; i++) {
            input += "A";
        }
        
        int cursor = 0;
        int cnt = 0;
        int move = n - 1;
        
        
        for(int i = 0; i < n ; i++) {
            char inputChar = input.charAt(i);
            char targetChar = name.charAt(i);
            if(inputChar != targetChar) {
                int dif = Math.min(Math.abs(inputChar - targetChar), 
                                   26 - Math.abs(inputChar - targetChar));
                cnt += dif;
            }
            int endAt = i + 1;
            while(endAt < n && name.charAt(endAt) == 'A')
                endAt++;
            
            
            move = Math.min(move, i * 2 + n - endAt );
            move = Math.min(move, (n - endAt) * 2 + i);
        }
        
        return cnt + move;
        
    }
    
}