import java.util.*;

class Solution {
    int len;
    boolean[] visited;
    List<String> routes;
    
    public String[] solution(String[][] tickets) {
        len = tickets.length;
        
        visited = new boolean[len];
        routes = new ArrayList<>();
        dfs("ICN", "ICN", tickets, 0);
        
        Collections.sort(routes);
        
        String[] answer = routes.get(0).split(" ");
    
        return answer;

    }
    
    public void dfs(String start, String result, String[][] tickets, int depth) {
        if(depth == len)
            routes.add(result);
        
        for(int i = 0 ; i < len ; i++) {
            if(tickets[i][0].equals(start) && !visited[i]) {
                visited[i] = true;
                dfs(tickets[i][1], result + " " + tickets[i][1], tickets, depth + 1);
                visited[i] = false;   
            }
        }
    }
}