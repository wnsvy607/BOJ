import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        DoubleQueue dq = new DoubleQueue();
        
        for(var op : operations) {
            var s = op.split(" ");
            
            if(s[0].equals("I"))
                dq.insert(Integer.parseInt(s[1]));
            else if(s[1].equals("1"))
                dq.removeMax();
            else
                dq.removeMin();
        }
        
        return dq.getMinAndMax();
    }
    
    class DoubleQueue {
        PriorityQueue<Integer> maxHeap;
        PriorityQueue<Integer> minHeap;
        
        DoubleQueue() {
            maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
            minHeap = new PriorityQueue<>();
        }
        
        void insert(int value) {
            maxHeap.offer(value);
            minHeap.offer(value);
        }
        
        void removeMin() {
            if(isEmpty())
                return;
            int min = minHeap.poll();
            maxHeap.remove(min);
        }
        
        void removeMax() {
            if(isEmpty())
                return;
            int max = maxHeap.poll();
            minHeap.remove(max);
        }
        
        boolean isEmpty() {
            return maxHeap.isEmpty() && minHeap.isEmpty();
        }
        
        int[] getMinAndMax() {
            if(isEmpty())
                return new int[]{0, 0};
            return new int[]{maxHeap.poll(), minHeap.poll()};
        }
        
    }
}