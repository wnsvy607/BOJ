import java.util.*;

class Solution {
    
    Map<String, Integer> order = new HashMap<>();
    
    public String[] solution(String[] files) {
        
        for(int i = 0; i < files.length; i++) {
            order.put(files[i], i);
        }

        Arrays.sort(files, this::compare);
        
        return files;
    }
    
    
    public int compare(String a, String b) {
        String ta = a.toLowerCase();
        String tb = b.toLowerCase();
        
        String ha = ta.split("[0-9]")[0];
        String hb = tb.split("[0-9]")[0];
        if(!ha.equals(hb))
            return ha.compareTo(hb);
        
        Integer na = Integer.valueOf(ta.split("[^0-9]+")[1]);
        Integer nb = Integer.valueOf(tb.split("[^0-9]+")[1]);

        if(na != nb)
            return na.compareTo(nb);
        
        return Integer.compare(order.get(a), order.get(b));
    }
}