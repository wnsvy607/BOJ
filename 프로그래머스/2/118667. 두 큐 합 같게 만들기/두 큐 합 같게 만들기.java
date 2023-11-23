import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int len = queue1.length + queue2.length;
        int[] arr = new int[len];
        
        long t1 = 0L;
        long t2 = 0L;
        
        for(int i = 0; i < queue1.length; i++) {
            arr[i] = queue1[i];
            t1 += (long) queue1[i];
        }
        for(int i = 0; i < queue2.length; i++) {
            arr[i + queue1.length] = queue2[i];
            t2 += (long )queue2[i];
        }
        if((t1 + t2) % 2 == 1)
            return -1;
        
        Long target = (t1 + t2) / 2;
        
        int count = 0;
        int s = 0;
        int e = queue1.length;
        
        
        while(target != t1 && count < (2 * len)) {
            if(t1 > t2){
                int pop = arr[s++];
                t1 -= (long) pop;
                t2 += (long) pop;
                if(s == len)
                    s = 0;
            }
            else {
                int pop = arr[e++];
                t2 -= (long) pop;
                t1 += (long) pop;
                if(e == len)
                    e = 0;
            }    
        
            count++;
        }
        

        
        if(count >= (2 * len))
            return -1;
            
        return count;
    
            
    }
}