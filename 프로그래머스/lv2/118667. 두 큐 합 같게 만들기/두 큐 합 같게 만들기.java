import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        Long total1 = 0L;
        Long total2 = 0L;
        
        
        for(int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            total1 += queue1[i];
            q2.add(queue2[i]);
            total2 += queue2[i];
        }

        
        if((total1 + total2) % 2 == 1)
           return -1;
        if(total1 == total2)
            return 0;
        return solve(q1, q2, total1, total2);
    }
    
    
    public int solve(Queue<Integer> q1, Queue<Integer> q2, Long t1, Long t2) {
        int maxLength = q1.size() * 3;
        int cnt = 0;
        int idx = 0;
        Long target = (t1 + t2) / 2;
        
        
        while(idx < maxLength) {
            if(t1 > t2){
                int element = q1.poll();
                t1 -= element;
                t2 += element;
                q2.add(element);
                cnt++;
            }   else if(t1 < t2) {
                int element = q2.poll();
                t2 -= element;
                t1 += element;
                q1.add(element);
                cnt++;
            }
            else return cnt;
            idx++;            
        }
        
        
        return -1;
    }
}