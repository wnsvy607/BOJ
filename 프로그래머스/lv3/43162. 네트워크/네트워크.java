class Solution {
    int[][] graph;
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        graph = computers;
        int network = 0;
        
        for(int i = 0; i < n ; i++) {
            if(visited[i]) continue;
            
            dfs(i, n);
            network++;
        }
        
        return network;
    }
    
    public void dfs(int start, int n) {
        visited[start] = true;
        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;    
            if(graph[start][i] == 1)
                dfs(i, n);
        }
        
    } 
}