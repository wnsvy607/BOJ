import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        Set<Integer> set = new TreeSet<>();
        int len = numbers.length;
        for(int i = 0; i < len; i++) {
            for(int j = i + 1; j < len; j++) {
                int sum = numbers[i] + numbers[j];
                set.add(sum);
            }
        }
        
        
        return set.stream().mapToInt(i -> i).toArray();
    }
}