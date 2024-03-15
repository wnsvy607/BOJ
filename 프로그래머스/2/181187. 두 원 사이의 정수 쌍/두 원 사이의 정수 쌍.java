class Solution {
    
    public long solution(int r1, int r2) {
        return innerSpot(r2, r1);
    }
    
    long innerSpot(int r2, int r1) {
        long result = 0L;
        
        Long lr2 = Long.valueOf(r2);
        Long lr1 = Long.valueOf(r1);
        
        for(long y = 1; y <= lr2; y++) {
            long x = (long) Math.sqrt((lr2 - y) * (lr2 + y));
            long buffer = (x * 2) + 1;
            if(y < lr1) {
                double x2 = Math.sqrt((lr1 - y) * (lr1 + y));
                if(isInteger(x2)) {
                    buffer += 2;
                }
                buffer -= (Math.floor(x2) * 2) + 1;
            }
            result += buffer * 2;
        }
        
        // 가운데 라인 계산
        result += (lr2 - lr1 + 1) * 2;
        return result;
    }
    
    boolean isInteger(double number) {
        return number % 1 == 0.0;
    }
    
}