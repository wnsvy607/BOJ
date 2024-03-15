import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        boolean[][] edges = new boolean[n + 1][n + 1];
        for(int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            edges[v1][v2] = true;
            edges[v2][v1] = true;
        }
        
        for(int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            edges[v1][v2] = false;
            edges[v2][v1] = false;
            boolean[] visited = new boolean[n+1];
            int r1 = bfs(n, visited, edges, v1);
            int r2 = bfs(n, visited, edges, v2);
            edges[v1][v2] = true;
            edges[v2][v1] = true;
            answer = Math.min(Math.abs(r1 - r2), answer);
        }
        
        
        return answer;
    }
    
    
    int bfs(int len, boolean[] visited, boolean[][] edges, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        int count = 0;
        
        while(!q.isEmpty()) {
            int node = q.poll();
            count++;
            
            for(int i = 1; i <= len; i++) {
                if(visited[i])
                    continue;
                
                if(edges[node][i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
            
        }

        return count;
         
    }
}