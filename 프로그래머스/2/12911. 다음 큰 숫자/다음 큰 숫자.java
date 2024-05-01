import java.util.*;

class Solution {
    public int solution(int n) {
        int next = n + 1;
        int one = count(n);
        
        while(count(next) !=  one) {
            next++;
        }
        

        return next;
    }
    
    int count(int n) {
        int num = 0;
        while(n > 0) {
            if(n % 2 == 1)
                num++;
            n = n / 2;
        }
        
        return num;
    }
}