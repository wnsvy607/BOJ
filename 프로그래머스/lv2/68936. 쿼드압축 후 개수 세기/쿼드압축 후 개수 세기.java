class Solution {
    public int[] solution(int[][] arr) {
        int n = arr.length;
        
        String result = recursive(0, n - 1, 0, n - 1, arr);
        
        int zero = (int) result.chars()
            .filter(c -> c == '0')
            .count();
        
        
        int[] answer = { zero, result.length() - zero};
        return answer;
    }
    
    
    public int compress(int ys, int ye, int xs, int xe, int[][] arr) {
        int val = arr[ys][xs];
        for(int i = ys; i <= ye; i++) {
            for(int j = xs ; j <= xe; j++) {
                if(val != arr[i][j])
                    return -1;
            }
        }

        
        return val;
    }
    
    public String recursive(int ys, int ye, int xs, int xe, int[][] arr) {
        if(ys == ye)
            return Integer.toString(arr[ys][xs]);
        int val = compress(ys, ye, xs, xe, arr);
        if(val == -1) {
            int ymid = (ys + ye) / 2;
            int xmid = (xs + xe) / 2;        
            return recursive(ys, ymid, xs, xmid, arr) + recursive(ys, ymid, xmid + 1, xe, arr) 
                + recursive(ymid + 1, ye, xs, xmid, arr) + recursive(ymid + 1, ye, xmid + 1, xe, arr);
        }
        
        return Integer.toString(val);
    }
    
    
    
    
}