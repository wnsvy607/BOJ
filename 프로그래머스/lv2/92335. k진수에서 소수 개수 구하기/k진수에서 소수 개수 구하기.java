class Solution {
    public int solution(int n, int k) {
        String num = "";
        
        
        //21  12 0
        //7  4  1
        //2  1  1
        //0
        while(n != 0) {
            num = n % k + num;
            n = (int) (n / k);
        }
        
        int answer = 0;        
        String temp = "";
        
        String[] nums = num.split("0");
        
        for(String str : nums) {
            if(str.isEmpty())
                continue;
            
            Long N = Long.parseLong(str);
            if(N < 2)
                continue;
            
            boolean isPrime = true;
            for(int i = 2; i <= Math.sqrt(N); i++){
                if(N % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            
            if(isPrime)
                answer++;           
            
        }
        
        

        return answer;
    }
}