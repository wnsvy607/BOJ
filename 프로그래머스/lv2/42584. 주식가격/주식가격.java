import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Price> stk = new Stack<>();
        int[] answer = new int[prices.length];
        
        for(int i = 0; i < prices.length - 1; i++) {
            while(!stk.isEmpty() && stk.peek().price > prices[i]) {
                Price p = stk.pop();
                answer[p.sec] = i - p.sec;
            }
            stk.add(new Price(prices[i], i));
        }
        
        for(Price p : stk) {
            answer[p.sec] = prices.length - 1 - p.sec;
        }
        answer[prices.length - 1] = 0;
        
        return answer;
    }
    
    class Price {
        int price;
        int sec;
        
        public Price(int p, int s) {
            price = p;
            sec = s;
        }
    }
}