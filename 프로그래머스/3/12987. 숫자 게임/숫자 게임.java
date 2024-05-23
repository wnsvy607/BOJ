import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        
        TreeSet<Integer> set = new TreeSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < B.length; i++) {
            set.add(B[i]);
            map.put(B[i] , map.getOrDefault(B[i], 0) + 1);
        }
        
        
        for(int i = 0; i < A.length; i++) {
            Integer idx = set.higher(A[i]);
            if(idx == null)
                continue;
            
            int count = map.get(idx);
            if(count == 1) {
                set.remove(idx);
            } else {
                map.put(idx, count - 1);
            }
            answer++;
        }
        
        
        return answer;
    }
}