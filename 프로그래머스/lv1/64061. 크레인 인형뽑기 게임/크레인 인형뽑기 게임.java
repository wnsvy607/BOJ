import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stk = new Stack<>();
        
        for(int move : moves) {
            move--;
            int doll = 0;
            
            for(int i = 0; i < board.length; i++) {
                if(board[i][move] != 0) {
                    doll = board[i][move];
                    board[i][move] = 0;
                    break;
                }
            }
            if(doll == 0)
                continue;
            
            if(!stk.isEmpty()) {
                int prev = stk.pop();                
                if(prev == doll) {
                    answer += 2;                    
                } else{
                    stk.push(prev);
                    stk.push(doll);
                }
                
            } else {
                stk.push(doll);
            } 
        }
        
        return answer;
    }
}