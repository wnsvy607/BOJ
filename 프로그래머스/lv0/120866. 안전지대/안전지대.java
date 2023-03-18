class Solution {
    
    int[] dx = {1,1,-1,-1,1,0,-1,0};
    int[] dy = {1,-1,1,-1,0,1,0,-1};
    
    
    public int solution(int[][] board) {
        int answer = 0;

        for (int i = 0 ; i < board.length ; i ++) {
            for (int j = 0 ; j < board.length ; j ++) {
                if(isSafe(board, i, j)) answer++;
            }
        }
    
        return answer;
    }
    
    
    public boolean isSafe(int[][] board, int x, int y) {
        int len = board.length;
        if(board[x][y] == 1) return false;
        
        for (int i = 0 ; i < 8 ; i ++) {
            int cx = x + dx[i];
            int cy = y + dy[i];
            if(cx < 0 || cy < 0 || cx >= len || cy >= len) continue;
            if(board[cx][cy] == 1) return false;
            
        }
        
        return true;
    }
    
    
    
}