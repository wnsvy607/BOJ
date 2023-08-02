class Solution {
    String[] arr = {"aya", "ye", "woo", "ma"};
    
    public int solution(String[] babbling) {
        int answer = 0;
        for(String word : babbling) {
            
            boolean isRepeated = false;
            for(String available : arr) {
                if(word.contains(available + available)) {
                    isRepeated = true;
                    break;
                }
            }
            
            if(isRepeated)
                continue;
            
            for(String available : arr) {
                word = word.replace(available, " ");
            }
            
            if(word.replace(" ", "").length() == 0)
                answer++;
            
        }
        
        
        return answer;
    }
}