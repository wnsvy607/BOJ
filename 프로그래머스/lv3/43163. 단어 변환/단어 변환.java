import java.util.*;
import java.util.stream.*;

class Solution {
    int answer = -1;
    int[] visited;
    List<int[]> lists;
    int tIdx = -1;
    
    
    public int solution(String begin, String target, String[] w) {
        
        List<String> words = Arrays.stream(w).collect(Collectors.toList());
        words.add(begin);
        lists = new ArrayList<>();
        visited = new int[words.size()];
        
        int tempIdx = 0;
        for(String a : words) {
            if(a.equals(target))
                tIdx = tempIdx;
            List<Integer> list = new ArrayList<>();
            int index = 0;
            for(String b : words) {
                if(isChangeable(a,b))
                    list.add(index);
                index++;
            }
            lists.add(list.stream().mapToInt(i -> i).toArray());
            tempIdx++;
        }
        
        if(tIdx == -1)
            return 0;
        BFS(w.length);
        
        return answer;
    }
    
    public void BFS(int start) {
        
        Queue<Integer> q = new LinkedList<>();
            
        q.add(start);
        visited[start] = 1;
        
        while(!q.isEmpty()){
            int node = q.poll();
            if(node == tIdx)
                answer = visited[node] - 1;
            
            for(int v : lists.get(node)) {
                if(visited[v] == 0) {
                    visited[v] = visited[node] + 1;
                    q.add(v);
                }    
            }
        }
    }
    
    
    public boolean isChangeable(String a, String b) {
        int cnt = 0;
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i))
                cnt++;
        }
        if(cnt == 1)
            return true;
        
        return false;
    }
}