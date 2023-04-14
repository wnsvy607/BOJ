import java.util.*;

class Solution {
    int[][] map;
    int answer = -1;
    int n, m;
    int[] dy = {0,0,1,-1};
    int[] dx = {1,-1,0,0};
    
    public int solution(int[][] maps) {
        map = maps;
        n = maps.length;
        m = maps[0].length;
        
        BFS();        
        return answer;
    }
    
    
    public void BFS() {
        int[][] visited = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(0, 0));
        visited[0][0] = 1;
        
        while(!q.isEmpty()) {
            Pair pa = q.poll();   
            if(pa.y == n - 1 && pa.x == m - 1) {  
                answer = visited[pa.y][pa.x];
                return;
            }
            
            for(int i = 0; i < 4; i++) {
                int cy = dy[i] + pa.y;
                int cx = dx[i] + pa.x;
                if(cy < 0 || cx < 0 || cy >= n || cx >= m)
                    continue;
                
                if(visited[cy][cx] == 0 && map[cy][cx] == 1) {
                    visited[cy][cx] = visited[pa.y][pa.x] + 1;
                    q.add(new Pair(cy, cx));
                }
                
            }
        }
        
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
