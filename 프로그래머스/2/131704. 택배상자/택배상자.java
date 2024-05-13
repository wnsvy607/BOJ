import java.util.*;

class Solution {
    public int solution(int[] order) {
        
        Stack<Integer> temp = new Stack<>();
        
        int count = 0;
        int n = order.length;
        int next = 1;
        for(int box : order) {
            while(box >= next) {
                temp.add(next++);
            }
                        
            if(temp.pop() != box) {
                break;
            }
            
            count++;
        }
        
        
        return count;
    }
}