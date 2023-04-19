import java.util.*;

class Solution {
    public int[] solution(int[] pg, int[] sp) {
        List<Integer> list = new ArrayList<>();
        
        int cnt = 0;
        int index = 0;
        int pointer = -1;
        boolean isContinouous = false;
        while(index < pg.length) {
            int progress = pg[index] + cnt * sp[index]; 
            if(progress >= 100) {
                if(isContinouous) {
                    list.set(pointer, list.get(pointer) + 1);
                } else {
                    list.add(++pointer, 1);
                }
                index++;
                isContinouous = true;
            } else {
                cnt++;
                isContinouous = false;
            }
                
            
        }
        

        return list.stream().mapToInt(i -> i).toArray();
    }
}