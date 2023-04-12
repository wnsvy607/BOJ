import java.util.*;

class Solution {
    
    String[] orders;
    int[] course;
    List<String> answers;
    List<String> answer;
    int max;
    
    public String[] solution(String[] orders, int[] course) {
        this.orders = orders;
        // this.course = course;
        answer = new ArrayList<>();
        answers = new ArrayList<>();
        
        
        for(int num : course) {
            max = 0;
            answers.clear();
            combi("", 0, num, 0);
            answer.addAll(answers);
        }
        
        answer.sort(Comparator.naturalOrder());
        return answer.toArray(new String[answer.size()]);
    }
    
    
    void combi(String result, int menu, int cn, int depth) {
        if(depth == cn) {
            int ordered = howMany(result);
            if(ordered < 2)
                return;
            
            if(answers.isEmpty()){
                answers.add(result);
                max = ordered;
                return;
            }
            
            if(ordered < max)
                return;
            
            if(ordered == max)
                answers.add(result);
            else {
                max = ordered;
                answers.clear();
                answers.add(result);
            }
        }
        
        for(int i = menu; i < 26; i++) {
            char ch = (char) ('A' + i);
            combi(result + ch, i + 1, cn, depth + 1);
        }
        
    }
    
    
    int howMany(String combi) {
        int cnt = 0;

        for(String order : orders) {
            boolean hasCombi = true;
            for(int i = 0; i < combi.length(); i++) {
                char ch = combi.charAt(i);
                if(order.indexOf(ch) == -1){
                    hasCombi = false;
                    break;
                }
            }
            
            if(hasCombi)
                cnt++;
        }
        
        return cnt;
        
    }

    
}