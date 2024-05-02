import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        TreeSet<Integer> set = new TreeSet<>();
        
        for(var op : operations) {
            String[] split = op.split(" ");
            int val = Integer.parseInt(split[1]);
            
            if(split[0].equals("I")) {
                set.add(val);
            } else if(val == 1) {
                set.pollLast();
            } else {
                set.pollFirst();
            }
            
        }
        
        if(set.isEmpty())
            return new int[]{0, 0};
        
        int max = set.pollLast();
        if(set.isEmpty())
            return new int[]{max , max};
        int min = set.pollFirst();
        
        return new int[]{max , min};
    }

}