

class Solution {
    
    public int solution(int[] arr) {
        int answer = arr[0];
        
        for(int i = 1; i < arr.length; i++) {
            answer = getLCM(answer, arr[i]);
        }
          
        return answer;
    }
    
    int getGCD(int a, int b) {
        int c;
        
        while(b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        
        return a;
    }
    
    int getLCM(int a, int b) {
        return a * b / getGCD(a, b);
    }
}