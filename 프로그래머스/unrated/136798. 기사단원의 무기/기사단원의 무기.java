class Solution {
    public int solution(int number, int limit, int power) {
        //1. number 까지의 약수를 구한다.
        int[] divisor = new int[number + 1];
        divisor[1] = 1;
        for(int i = 2; i <= number; i++) {
            int cnt = 0;
            // j * j <= i인 지점까지만 검사 (효율성)
            for(int j = 1; j * j <= i; j++) {
                if(j * j == i)
                    cnt++;
                else if(i % j == 0)
                    cnt += 2;
            }
            divisor[i] = cnt;
        }
        
        int totalWeight = 0;
        for(int i = 1; i <= number; i++) {
            // 2-1. limit을 초과하면 공격력이 power인 무기를 구매한다.
            if(divisor[i] > limit)
                totalWeight += power;
            // 2-2. 초과하지 않으면 약수의 개수만큼 더한다.
            else
                totalWeight += divisor[i];  
        }
        
        return totalWeight;
    }
}