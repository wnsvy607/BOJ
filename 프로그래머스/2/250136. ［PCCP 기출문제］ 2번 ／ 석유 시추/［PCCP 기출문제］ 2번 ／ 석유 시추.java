import java.util.*;

class Solution {
    
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    int n;
    int m;
    int[][] par;
    int[] reserves;
    boolean[][] visited;
    int[][] map;
    int id = 1;
    
    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;

        
        // 각 덩어리의 root를 담을 배열
        par = new int[n][m];
        reserves = new int[n * m + 1];
        visited = new boolean[n][m];
        map = land;
            
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0 || visited[i][j])
                    continue;
                par[i][j] = id;
                visited[i][j] = true;
                reserves[id++] = dfs(i, j);
            }
        }
        
        int answer = 0;
        
        Set<Integer> counted = new HashSet<>();        
        for (int i = 0; i < m; i++) {
            int cnt = 0;

            for(int j = 0; j < n; j++) {
                int parent = par[j][i];
                if(counted.contains(parent))
                    continue;
                cnt += reserves[parent];
                counted.add(parent);
            }
            
            answer = Math.max(answer, cnt);
            counted.clear();
        }
        
        return answer;
    }
    
    
    int dfs(int y, int x) {
        int cnt = 1;
        
        // 순회
        for(int i = 0; i < 4; i++) {
            int cy = y + dir[i][0];
            int cx = x + dir[i][1];
            if(cy < 0 || cx < 0 || cy >= n || cx >= m || visited[cy][cx] || map[cy][cx] == 0)
                continue;
            
            visited[cy][cx] = true;
            par[cy][cx] = par[y][x];
            cnt += dfs(cy, cx);
        }
        
        return cnt;
    }
}