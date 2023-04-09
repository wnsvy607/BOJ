import java.util.*;

class Solution {
    int[] today;
    String[] privacies;
    Map<String, Integer> map;
    
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        this.privacies = privacies;
        
        // 숫자로 맵을 만듬
        map = new HashMap<>();
        for(int i = 0; i < terms.length; i++){
            String[] term = terms[i].split(" ");
            map.put(term[0], Integer.parseInt(term[1]));
        }
        
        // 오늘의 날짜를 파싱해서 정수 배열에 담는다.
        this.today = parse(today);

        // 파기할 약관의 번호를 담는 List
        List<Integer> answers = new ArrayList<>();
        
        for(int i = 0; i < privacies.length; i++) {
            if(isExpired(i))
                answers.add(i + 1);
        }
        

        return answers.stream().mapToInt(i -> i).toArray();
    }
    
    public boolean isExpired(int i) {
        String[] pInfo = privacies[i].split(" ");
        
        //개인정보 수집일자 0-년, 1-월, 2-일
        int[] date = parse(pInfo[0]);
        
        //유효기간-월 단위
        int duration = map.get(pInfo[1]);
        
        //개인정보 수집일자에 유효기간을 더한다.
        date[1] = date[1] + duration;
        while(date[1] > 12) {
            date[1] = date[1] - 12;
            date[0] = date[0] + 1;
        }
        
        //하루를 뺀다.
        date[2] = date[2] - 1;
        if(date[2] < 1) {
            date[2] += 28;
            date[1] -= 1;            
        }
        
        if(date[1] < 0) {
            date[1] += 12;
            date[0] -= 1;
        }
        
        
        
        for(int j = 0; j < 3; j++) {
            if(today[j] < date[j])
                return false;
            else if(today[j] > date[j])
                return true;
        }
        
        return false;
    }
    
    public int[] parse(String date) {
        String[] s = date.split("\\.");
        int[] result = new int[] { Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]) };
        return result;
    }
    


}