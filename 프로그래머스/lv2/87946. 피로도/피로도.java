class Solution {
    int[][] dun;
    int p;
    boolean[] visited;
    int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        p = k;
        dun = dungeons;
        visited = new boolean[dun.length];
        dfs(p, 0);
        
        
        return answer;
    }
    
    public void dfs(int rest, int depth) {
        if(rest < 0 || depth == dun.length){
            answer = Math.max(answer, depth);
            return;            
        }
        
        for(int i = 0; i < dun.length ; i++) {
            if(!visited[i] && rest >= dun[i][0]) {
                visited[i] = true;
                dfs(rest - dun[i][1], depth + 1);
                visited[i] = false;
            }
        }
        
        answer = Math.max(answer, depth);
    }
    
    
    
}