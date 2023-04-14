import java.util.*;

class Solution {
    int[][] cMap;
    int answer = 0;
    int n;
    boolean[] visited;
    
    
    
    public int solution(int n, int[][] computers) {
        cMap = computers;
        this.n = n;
        visited = new boolean[n];
        
        
        // Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < n;  i++) {
            DFS(i);
        }
        return answer;
    }
    
    
    public void DFS(int node) {
        // 탈출
        if(!visited[node])
            answer++;
        
        // 수행
        for(int i = 0; i < n; i++) {
            if(i == node)
                continue;
            
            if(!visited[i] && cMap[node][i] == 1) {
                visited[i] = true;
                DFS(i);
            }
        }
        
        
        
        
        
    }
}