class Solution {
    
    int ch = 1;
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        
        ch = health;
        int prev = 0;
        for(int[] attack : attacks) {
            // 1. prev ~ 현재 시간(공격 시간) - 1 까지 회복 기간
            int timeToBand = attack[0] - prev - 1;
            ch += timeToBand * x + ((int) (timeToBand / t)) * y;
            if(ch > health)
                ch = health;
            prev = attack[0];
            
            // 2. 피해량 만큼 현재 체력 제외
            ch -= attack[1];
            
            if(ch <= 0)
                return -1;
        }
        
        return ch;
    }
}