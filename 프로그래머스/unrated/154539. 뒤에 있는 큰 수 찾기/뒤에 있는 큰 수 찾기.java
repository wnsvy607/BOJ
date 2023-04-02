import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Stack<Pair> stk = new Stack<>();
        
        for(int i = 0 ; i < numbers.length; i++) {
            while(!stk.empty()) {
                Pair pair = stk.peek();
                if(pair.getValue() < numbers[i]) {
                    int index = pair.getIndex();
                    answer[index] = numbers[i];
                    stk.pop();
                } else 
                    break;               
            }
            stk.push(new Pair(i, numbers[i]));
        }
        
        for(Pair rest : stk) {
            answer[rest.getIndex()] = -1;           
        }
        
        return answer;
    }
    
}

class Pair {
    
    private Integer index;
    private Integer value;
    
    public Pair(int index, int value) {
        this.index = index;
        this.value = value;
    }
    
    public Integer getIndex() {
        return this.index;
    }
    
    public Integer getValue() {
        return this.value;
    }
    
    
    
}


