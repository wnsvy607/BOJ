import java.util.*;

class Solution {
    
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    int answer = -1;
    
    
    public int solution(int[][] maps) {
        

        boolean[][] visited = new boolean[maps.length][maps[0].length];
        int[][] valueMap = new int[maps.length][maps[0].length];
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        visited[0][0] = true;
        valueMap[0][0] = 1;
        valueMap[maps.length - 1][maps[0].length - 1] = -1;
        
        
        while(q.peek() != null ) {
            Pair pair = q.peek();
            
            for(int i = 0; i < 4 ; i++) {
                int cx = pair.x + dx[i];
                int cy = pair.y + dy[i];

                if(cy < 0 || cx < 0|| cy >= maps.length || cx >= maps[0].length)
                    continue;

                if(!visited[cy][cx] && maps[cy][cx] == 1) {
                    q.add(new Pair(cy, cx));
                    if(valueMap[cy][cx] < 1)
                        valueMap[cy][cx] = valueMap[pair.y][pair.x] + 1;
                    else
                        valueMap[cy][cx] = Math.min(valueMap[cy][cx], valueMap[pair.y][pair.x] + 1);
                    visited[cy][cx] = true;
                }
            }
            
            q.poll();        
        }
        
        
        return valueMap[maps.length - 1][maps[0].length - 1];
    }
    
}

class Pair {
    int y;
    int x;
    
    public Pair(int y, int x) {
        this.y = y;
        this.x = x;
    }
}