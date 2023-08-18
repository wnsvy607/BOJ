class Solution {
    public int solution(String dr) {
        
        int[] result = new int[3];

        int cur = 0;
        while(dr.length() != 0) {
            Integer score;
            if(dr.substring(0, 2).equals("10")) {
                score = 10;
                dr = dr.substring(2, dr.length());
            } else {
                score = stoi(dr.substring(0, 1));
                dr = dr.substring(1, dr.length());
            }
            
            char ch = dr.charAt(0);
            if(ch == 'D')
                score = (int) Math.pow(score, 2);
            else if(ch == 'T')
                score = (int) Math.pow(score, 3);
            if(dr.length() > 1){
               String next = dr.substring(1, 2);
                if(!next.matches("[0-9]")) {
                    if(next.equals("*")) {
                        if(cur != 0)
                            result[cur - 1] *= 2;
                        score *= 2;
                    } else {
                        score *= -1;                    
                    }
                    dr = dr.substring(2, dr.length());                
                } else {
                    dr = dr.substring(1, dr.length());                
                }
            } else {
                dr = dr.substring(1, dr.length());
            }
     
            result[cur++] = score;
        }
        
        int answer = 0;
        for(int i = 0; i < 3; i++) {
            answer += result[i];
        }
        return answer;
    }
    
    int stoi(String s) {
        return Integer.parseInt(s);
    }
}