import java.util.*;

class Solution {
    
    Set<String> set;
    
    public int solution(String word) {
        set = new TreeSet<>();
        recur(5, "");
        set.remove("");
        
        var it = set.iterator();
        int count = 0;
        while(it.hasNext()) {
            if(it.next().equals(word))
                break;
            count++;
        }
        
        return count + 1;
    }
    
    String[] str = {"", "A", "E", "I", "O", "U"};
    
    void recur(int r, String result) {
        if(r == 0) {
            set.add(result);
            return;
        }
        
        for(int i = 0; i < 6; i++) {
            recur(r - 1, result + str[i]);
        }
    }
}