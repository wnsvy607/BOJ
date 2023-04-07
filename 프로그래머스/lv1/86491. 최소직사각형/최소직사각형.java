import java.util.*;

class Solution {
    int area = 1000000;
    
    public int solution(int[][] sizes) {
        int w = 1;
        int h = 1;
        for(int i = 0; i < sizes.length; i++) {
            if(sizes[i][0] < sizes[i][1]) {
                //가로보다 세로가 길면 회전
                int width = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = width;
            }
            w = Math.max(w, sizes[i][0]);
            h = Math.max(h, sizes[i][1]);
        }
        
        return w * h;
    }
}