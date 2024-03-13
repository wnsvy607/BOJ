import java.util.*;

class Solution {
    
    Set<Integer> result = new HashSet<>();
    int len;
    
    public int solution(String numbers) {
        int[] arr = new int[numbers.length()];
        len = numbers.length();
        for(int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(numbers.substring(i, i + 1));
        }
        
        for(int i = 1; i < len + 1; i++) {
            permu(arr, new boolean[len], i, "");            
        }
        

        return result.size();
    }
    
    
    void permu(int[] arr, boolean[] visited, int h, String result) {
        if(h == 0) {
            checkIfPrime(result);
            return;            
        }
        
        for(int i = 0; i < len; i++) {
            if(visited[i])
                continue;
            
            visited[i] = true;
            permu(arr, visited, h - 1, result + arr[i]);
            visited[i] = false;
        }
        
    }
    
    void checkIfPrime(String num) {
        int number = Integer.parseInt(num);
        if(number < 2)
            return;
        
        for(int i = 2; i < number; i++) {
            if(number % i == 0)
                return;
        }
        result.add(number);
    }
    
}