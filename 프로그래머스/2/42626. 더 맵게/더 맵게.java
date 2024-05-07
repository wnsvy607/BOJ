import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> foods = new PriorityQueue<>();
        
        for(int food : scoville) {
            foods.offer(food);
        }
        
        int count = 0;
        while(foods.size() > 1 && foods.peek() < K) {
            int first = foods.poll();
            int second = foods.poll();
            foods.offer(first + second * 2);
            count++;
        }
        
        if(foods.peek() < K)
            return -1;
        
        return count;
    }
}