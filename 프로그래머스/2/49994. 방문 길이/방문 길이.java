import java.util.*;
import java.awt.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        Set[][] visited = new Set[11][11];
        HashMap<Character, int[]> map = new HashMap<>();
        map.put('L', new int[]{0, -1});
        map.put('R', new int[]{0, 1});
        map.put('U', new int[]{1, 0});
        map.put('D', new int[]{-1, 0});
        
        
        for(int i = 0; i < 11; i++) {
            for(int j = 0; j < 11; j++) {
                visited[i][j] = new HashSet<>();
            }
        }
        
        
        int cy = 5;
        int cx = 5;
        int count = 0;
        
        for(var dir : dirs.toCharArray()) {
            int[] to = map.get(dir);
            
            int ty = cy + to[0];
            int tx = cx + to[1];
            
            if(ty < 0 || tx < 0 || ty > 10 || tx > 10)
                continue;
            Point p = new Point(ty, tx);
            
            if(!visited[cy][cx].contains(p)) {
                visited[cy][cx].add(p);
                visited[ty][tx].add(new Point(cy, cx));
                count++;
            } 
            
            cy = ty;
            cx = tx;
        }
        
        return count;
    }
}