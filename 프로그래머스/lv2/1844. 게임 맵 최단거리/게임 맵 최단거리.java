import java.util.*;

class Solution {
    
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    int answer = -1;
    
    
    public int solution(int[][] maps) {
        

        boolean[][] visited = new boolean[maps.length][maps[0].length];
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, 1));
        visited[0][0] = true;
        
        
        while(q.peek() != null ) {
            Pair pair = q.peek();
            if(pair.y == maps.length - 1 && pair.x == maps[0].length - 1) 
                return pair.depth;
            
            for(int i = 0; i < 4 ; i++) {
                int cx = pair.x + dx[i];
                int cy = pair.y + dy[i];

                if(cy < 0 || cx < 0|| cy >= maps.length || cx >= maps[0].length)
                    continue;

                if(!visited[cy][cx] && maps[cy][cx] == 1) {
                    q.add(new Pair(cy, cx, pair.depth + 1));
                    visited[cy][cx] = true;
                }
            }
            
            q.poll();        
        }
        
        
        return answer;
    }
    
}

class Pair {
    int y;
    int x;
    int depth;
    
    public Pair(int y, int x, int depth) {
        this.y = y;
        this.x = x;
        this.depth = depth;
    }
}