import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> list = new ArrayList<>();
        
        
        Map<String, Integer> dic = new HashMap<>();
        
        for(int i = 0; i < 26; i++) {
            dic.put(Character.toString('A' + i), i + 1);
        }
        
        String buffer = "";
        int count = 27;
        
        for(int i = 0; i < msg.length(); i++) {
            char ch = msg.charAt(i);
            String word = buffer + ch;
            
            // 사전에 있으면 다음 것까지 있는지 확인한다.
            if(dic.containsKey(word)) {
                buffer = word;
                continue;
            }
            
            int idx = dic.get(buffer);
            list.add(idx);
            dic.put(word, count++);
            buffer = "";
            i--;
        }
        int idx = dic.get(buffer);
        list.add(idx);
        // System.out.println(dic);
        
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}