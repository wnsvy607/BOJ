import java.util.*;
import java.util.stream.*;

class Solution {
    int[] patternB = {1, 3, 4, 5};
    int[] patternC = {3, 1, 2, 4, 5};
    
    public int[] solution(int[] answers) {
        
        int A = 0, B = 0, C = 0;

        for(int i = 0; i < answers.length; i++) {
            
            if(answers[i] == i % 5 + 1)
                A++;
            
            if(i % 2 == 0){
                if(answers[i] == 2)
                    B++;
                }
            else if(patternB[(((i - 1) / 2) % 4)] == answers[i])
                B++;
            
            if(patternC[((int) i / 2) % 5] == answers[i])
                C++;
        }
        
        int max = Math.max(A, B);
        max = Math.max(max, C);
        
        List<Integer> list = new ArrayList<>();
        
        if(A == max)
            list.add(1);
        if(B == max)
            list.add(2);
        if(C == max)
            list.add(3);

        return list.stream().mapToInt(i -> i).toArray();
    }
}