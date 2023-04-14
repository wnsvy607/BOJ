import java.util.*;

class Solution {
    int n, m;
    List<Integer> answer;
    int[][] map;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        n = rows;
        m = columns;
        map = new int[n][m];
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++) {
                map[i][j] = i * m + j + 1;
            }
        
        answer = new ArrayList<>();
        
        for(int[] query : queries) {
            answer.add(rotate(query));
        }
        
        
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    public int rotate(int[] query) {
        int min;
        int cy = query[2] - 1;
        int cx = query[3] - 1;
        int prev = min = map[cy - 1][cx];
        
        
        while(cx != query[1] - 1) {
            int temp = map[cy][cx];
            min = Math.min(min, temp);
            map[cy][cx] = prev;
            prev = temp;
            cx--;
        }
        
        while(cy != query[0] - 1) {
            int temp = map[cy][cx];
            min = Math.min(min, temp);
            map[cy][cx] = prev;
            prev = temp;
            cy--;
        }
        
        while(cx != query[3] - 1) {
            int temp = map[cy][cx];
            min = Math.min(min, temp);
            map[cy][cx] = prev;
            prev = temp;
            cx++;
        }
        
        while(cy != query[2] - 1) {
            int temp = map[cy][cx];
            min = Math.min(min, temp);
            map[cy][cx] = prev;
            prev = temp;
            cy++;
        }
        
        return min;
    }
}