import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {

        Queue<Integer> q = new LinkedList<>();
        
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        HashSet<Integer>[] graph = new HashSet[n + 1];
        
        for(int[] e : edge) {
            int u = e[0];
            int v = e[1];
            if(graph[u] == null)
                graph[u] = new HashSet<>();
            if(graph[v] == null)
                graph[v] = new HashSet<>();
            graph[u].add(v);
            graph[v].add(u);
        }
        
        q.add(1);
        visited[1] = true;
        dist[1] = 1;
        int max = 0;
        
        while(!q.isEmpty()) {
            int u = q.poll();
            
            HashSet<Integer> nodes = graph[u];
            
            for(int next : nodes) {
                if(visited[next])
                    continue;
                dist[next] = dist[u] + 1;
                max = Math.max(max, dist[next]);
                q.add(next);
                visited[next] = true;
            }
        }
        
        int cnt = 0;
        for(int i = 1; i < n + 1; i++) {
            if(dist[i] == max)
                cnt++;
        }
        
        
        return cnt;
    }
}