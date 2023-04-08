class Solution {
    public int[] solution(int brown, int yellow) {
        
        int width = yellow;
        int height = 1;
        while(width >= height) {
            if(width * 2 + height * 2 + 4 == brown)
                break;
            else {  
                height++;
                while(yellow % height != 0) {
                    height++;
                }
                width = yellow / height;
            }
                
        
        }
        
        
        int[] answer = {width + 2, height + 2};
        return answer;
    }
}