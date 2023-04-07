import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int[][] clist) {
        List<Integer> ansList = new ArrayList<>();
        
        
        for(int[] command : clist) {
            int start = command[0] - 1;
            int end = command[1];
            
            // 자동 정렬되는 TreeMap에 집어 넣는다.
            Map<Integer, Integer> map = new TreeMap<>();
            for(int i = start; i < end; i++) {
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }
            List<Integer> targetList = new ArrayList<>();
            for(Integer key : map.keySet()) {
                while(map.get(key) > 0) {
                    targetList.add(key);
                    map.put(key, map.get(key) - 1);
                }
            }
            
            ansList.add(targetList.get(command[2] - 1));
            
        }
        
        
        return ansList.stream().mapToInt(i -> i).toArray();
    }
}