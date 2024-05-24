class Solution {
    public long[] solution(long[] numbers) {
        long[] result = new long[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            long num = numbers[i];
            
            long y = f(num);
            
            result[i] = y;
        }
        
        
        return result;
    }
    
    long f(long x) {
        
        // 2^10 ~= 10^3
        // 2^50 ~= 10^15
        
        int[] bits = new int[51];
        
        int idx = 0;
        while(x > 0) {
            bits[idx++] = (int) (x % 2);
            x = x / 2;
        }
        
        int target = 0;
        while(bits[target] != 0) {
            target++;
        }
        
        bits[target] = 1;
        if(target > 0)
            bits[target - 1] = 0;
        
        long res = 0;
        long radix = 1;
        for(int i = 0; i < 51; i++) {
            if(bits[i] == 1)
                res += radix; 
            radix *= 2;
        }
        
        return res;
    }
}