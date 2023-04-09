class Solution {
    int[][] pos;
    int[] way = {-1,0,-1,1,0,-1,1,0,-1,1};
    int[][] numPos = new int[][]{ {0 , 1}, 
                      {3, 0}, {3, 1}, {3, 2},
                      {2, 0}, {2, 1}, {2, 2},
                      {1, 0}, {1, 1}, {1, 2}};
    
    public String solution(int[] nums, String hand) {
        String answer = "";
        pos = new int[][]{ {0, 0}, {0, 2}};
        
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int h = way[num];
            int y = numPos[num][0];
            int x = numPos[num][1];
            
            //가운데면 가까운 손을 찾는다.
            if(h == -1)
                h = findCloserHand(y, x, hand);
            
            pos[h][0] = y;
            pos[h][1] = x;
            
            if(h == 0)
                answer += "L";
            else
                answer += "R";
            
        }
    
        return answer;
    }
    
    int findCloserHand(int y, int x, String hand) {
        int ly = pos[0][0];
        int lx = pos[0][1];
        
        int ry = pos[1][0];
        int rx = pos[1][1];
        
        int ld = Math.abs(ly - y) + Math.abs(lx - x);
        int rd = Math.abs(ry - y) + Math.abs(rx - x);
        
        if(ld < rd)
            return 0;
        else if(ld > rd)
            return 1;
        // 어느 손잡이 인지 비교
        else {
            if(hand.equals("left"))
                return 0;
            else
                return 1;
        }
            
        
    }
    
    
}