import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int i = 0; i < B.length; i++) {
            map.put(B[i] , map.getOrDefault(B[i], 0) + 1);
        }
        
        
        for(int i = 0; i < A.length; i++) {
            var entry = map.higherEntry(A[i]);
            if(entry == null)
                continue;
            
            int count = entry.getValue();
            if(count == 1) {
                map.remove(entry.getKey());
            } else {
                map.put(entry.getKey(), count - 1);
            }
            answer++;
        }
        
        
        return answer;
    }
}