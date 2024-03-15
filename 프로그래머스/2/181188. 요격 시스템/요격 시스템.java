import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));
        
        int bound = targets[0][1];
        
       for(int[] target : targets){
            if(target[0] >= bound){
                answer++;
                bound = target[1];
            }
        }

        return answer;
    }

}