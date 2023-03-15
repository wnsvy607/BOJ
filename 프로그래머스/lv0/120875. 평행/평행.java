import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        HashMap<Double, List<Integer>> map = new HashMap<>();

        for(int i = 0 ; i < 4 ; i ++) {
            for (int j = i + 1 ; j < 4 ; j ++) {
                double x1 = dots[i][0];
                double y1 = dots[i][1];
                double x2 = dots[j][0];
                double y2 = dots[j][1];
                List<Integer> value = map.put( ((y2 - y1) / (x2 - x1)) , List.of(i, j));
                if(value != null) {
                    if(value.contains(i) || value.contains(j))
                        continue;
                    return 1;
                }

            }
        }
        
        return 0;
    }
}