import java.util.*;

class Solution {
    public int solution(int[] A, int[] B)    {
        
        Arrays.sort(A);
        Arrays.sort(B);

        int sum = 0;
        int len = A.length - 1;
        
        for(int i = 0; i <= len; i++) {
            sum += A[i] * B[len - i];
        }
        
        return sum;
    }
}