class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int count = getCount(h2, m2, s2) - getCount(h1, m1, s1);
        if(s1 == 0 && m1 == 0) count++;
        return count;
    }
    
    public int getCount(int h, int m , int s) {
        int mCnt = 0; int hCnt = 0; int result = -1;
        
        mCnt += h * 59 + m;
        hCnt += h * 60 + m;
        
        double mDegree = m * 6;
        double hDegree = 30 * (h % 12) + 0.5 * m;
        if(mDegree <= 5.9 * s) mCnt++;
        if(hDegree <= (6 - 1 / 120) * s) hCnt++;
        
        if(h >= 12) {
            hCnt--;
            result--;
        }
        
        result += mCnt + hCnt;
        return result;
    }
}