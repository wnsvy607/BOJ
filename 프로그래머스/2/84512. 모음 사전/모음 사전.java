class Solution {
    
    String target;
    char[] cand = {'A', 'E', 'I', 'O', 'U'};
    int order;
    int answer;
    public int solution(String word) {
        
        target = word;
        order = -1;
        recursive(5, false, "");
        
        return answer;
    }
    
    void recursive(int h, boolean blank, String result) {
        if(answer > 0)
            return;
        if(h == 0) {
            order++;
            if(result.replace(" ", "").equals(target))
                answer = order;
            return;
        }
        
        recursive(h - 1, true, result + ' ');
        
        if(!blank) {
            for(int i = 0; i < 5; i++) {
                recursive(h - 1, false, result + cand[i]);
            }      
        }
        
    }
}