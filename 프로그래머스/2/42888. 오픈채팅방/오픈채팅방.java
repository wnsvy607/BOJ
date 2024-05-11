import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        int len = record.length;
        String[][] history = new String[len][2];
        
        Map<String, String> nicknames = new HashMap<>();
        
        for(int i = 0; i < len; i++) {
            String[] rec = record[i].split(" ");
            


            history[i][0] = rec[0];
            history[i][1] = rec[1];
            
            if(rec[0].equals("Leave")) {   
                continue;
            }
            nicknames.put(rec[1], rec[2]);
        }
        
        List<String> answer = new ArrayList<>();
        for(int i = 0; i < len; i++) {
            if(history[i][0].equals("Change"))
                continue;
            String result = nicknames.get(history[i][1]) + "님이 ";
            result += history[i][0].equals("Enter") ? "들어왔습니다." : "나갔습니다.";
            answer.add(result);
        }
        
        return answer.toArray(new String[answer.size()]);
    }
}