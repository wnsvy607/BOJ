class Solution {
    public String solution(String X, String Y) {
        
        int[] xNum = new int[10]; 
        int[] yNum = new int[10]; 
        
        count(xNum, X);
        count(yNum, Y);
          
        String answer = "";
        for(int i = 9; i > -1; i--) {
            int addNum = Math.min(xNum[i], yNum[i]);
            
            String res = String.valueOf(i).repeat(addNum);
            answer += res;
        }
        
        if(answer.isBlank())
            return "-1";
        else if(answer.charAt(0) == '0')
            return "0";
        
        return answer;
    }
    
    
    void count(int[] arr, String s) {
        for(int i = 0; i < s.length(); i++) {
            int idx = stoi(s.charAt(i));
            arr[idx]++;
        }
    }
    
    
    int stoi(String s) {
        return Integer.parseInt(s);
    }
    
    int stoi(char ch) {
        return ch - '0';
    }
}