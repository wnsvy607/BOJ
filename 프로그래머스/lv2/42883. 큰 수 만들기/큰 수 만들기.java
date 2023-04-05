class Solution {
    public String solution(String number, int k) {

        int cursor = 0;
        while(k > 0) {
            if(k >= number.substring(cursor).length()){
                number = number.substring(0, cursor);
                break;
            }

            int max = number.charAt(cursor);
            int maxIdx = 0;
            if(max == '9'){
                cursor++;
                continue;
            }
                
            for(int i = 1; i < k + 1; i++) {
                int idx = cursor + i;
                if(max < number.charAt(idx)) {
                    max = number.charAt(idx);
                    maxIdx = i;
                    if(max == '9')
                        break;
                }
            }
            
            if(maxIdx == 0)
                cursor++;
            else {
                k -= maxIdx;
                number = number.substring(0, cursor) + number.substring(cursor + maxIdx);
            }
            
        }
        
        return number;
        
    }
}