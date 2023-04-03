import java.util.*;

class Solution {
    int n;
    boolean[][] map;
    int[] visited;
    
    
    public int solution(String begin, String target, String[] words) {
        n = words.length;
        visited = new int[n + 1];
        map = new boolean[n + 1][n + 1];
        
        // 0번째 행, 열 만들기
        for(int i = 0; i < n; i++) {
            if(isChangable(begin, words[i])) {
                map[0][i + 1] = true;
                map[i + 1][0] = true;                
            }
        }
        
        // 1 ~ n번째 행, 열 만들기
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(isChangable(words[i], words[j])) {
                    map[i + 1][j + 1] = true;
                    map[j + 1][i + 1] = true;
                }
                
            }
        }
        
        
        Queue<Integer> q = new LinkedList<>();
        q.add(-1);
        visited[0] = 1;
        
        while(q.peek() != null) {
            
            // words 기준
            int cur = q.peek();
            String curStr = "";
            if(cur == -1) {
                curStr = begin;
                cur = 0;
            }
            else 
                curStr = words[cur - 1];
            
            if(curStr.equals(target))
                return visited[cur] - 1;
            
            for(int i = 0; i < n; i++) {
                if(visited[i + 1] < 1 && map[cur][i + 1]) {
                    visited[i + 1] = visited[cur] + 1;
                    q.add(i + 1);
                }
            }
            
            
            
            q.poll();
        }
        
        return 0;
    }
    
    public boolean isChangable(String a, String b) {
        int cnt = 0;
        for(int i = 0; i < a.length() ; i++) {
            if(a.charAt(i) != b.charAt(i))
                cnt++;
        }
        if(cnt < 2)
            return true;
        
        return false;
    }
}