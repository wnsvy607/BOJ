class Solution {
    public String solution(String id) {
        id = id.toLowerCase();
        String answer = "";
        for(int i = 0; i < id.length(); i++) {
            char ch = id.charAt(i);
            if(Character.isAlphabetic(ch) || Character.isDigit(ch) || ch == '-' || ch == '_' || ch == '.')
                answer += ch;
        }
        
        while(answer.indexOf("..") != -1) {
            answer = answer.replace("..", ".");
        }
        
        if(answer.charAt(0) == '.')
            answer = answer.substring(1);
        
        if(answer.length() > 0 && answer.charAt(answer.length() - 1) == '.')
            answer = answer.substring(0, answer.length() - 1);
        
        if(answer.isEmpty())
            answer = "a";
        
        if(answer.length() >= 16){
            answer = answer.substring(0, 15);
            if(answer.charAt(answer.length() - 1) == '.')
                answer = answer.substring(0, answer.length() - 1);   
        }
        
        if(answer.length() <= 2)
            while(answer.length() < 3)
                answer += answer.charAt(answer.length() - 1);
        
        
        return answer;
    }
}