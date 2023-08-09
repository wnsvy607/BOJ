import java.util.*;

class Solution {
    public int[] solution(long n) {
        String str = String.valueOf(n);
        int len = str.length();
        int[] arr = new int[len];
        
        for(int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(str.substring(len-i-1, len -i));
        }
        
        
        
        return arr;
    }
}