import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {        
        Map<Integer, Tan> map = new HashMap<>();
        
        for(int t : tangerine) {
            Tan tan = map.getOrDefault(t, new Tan(t));
            tan.add();
            map.put(t, tan);    
        }
        
        PriorityQueue<Tan> pq = new PriorityQueue<>();
        
        for(var entry : map.entrySet()) {
            pq.add(entry.getValue());
        }
        
        int count = 0, now = 0;
        while(now < k) {
            now += pq.poll().value;
            count++;
        }
        
        return count;
    }
    
    
    class Tan implements Comparable<Tan> {
        int size;
        int value;
        
        Tan(int s) {
            size = s;
            value = 0;
        }
        
        @Override
        public int compareTo(Tan t) {
            return Integer.compare(t.value, this.value);
        }
        
        void add() {
            this.value++;
        }
        
    }
}