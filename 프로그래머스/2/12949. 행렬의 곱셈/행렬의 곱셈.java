class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int r1 = arr1.length;
        int c1 = arr1[0].length;
        int r2 = arr2.length;
        int c2 = arr2[0].length;
        
        int[][] answer = new int[r1][c2];
        
        for(int y = 0; y < r1; y++) {
            
            for(int x = 0; x < c2; x++){
                int sum = 0;
                for(int i = 0; i < c1; i++) {
                    sum += arr1[y][i] * arr2[i][x];
                }
                
                answer[y][x] = sum;
            }
        }

        
        
        
        return answer;
    }
}