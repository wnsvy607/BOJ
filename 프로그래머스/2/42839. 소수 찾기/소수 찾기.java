import java.util.*;

class Solution {
    
    Set<Integer> set = new HashSet<>();
    List<Character> list = new ArrayList<>();
    
    int n;
    
    public int solution(String numbers) {
        
        char[] arr = numbers.toCharArray();
        
        
        for(char ch : arr) {
            list.add(ch);
        }
        
        n = list.size();
        boolean[] visited = new boolean[n];
        
        for(int i = 1; i <= n; i++) {
            combi(i, "", visited);
        }
        
        
        return set.size();
    }
    
    
    void combi(int r, String result, boolean[] visited) {
        if(r == 0) {
            prc(result);
            return;
        }
        
        for(int i = 0; i < list.size(); i++) {
            if(visited[i])
                continue;
            
            visited[i] = true;
            combi(r - 1, result + list.get(i), visited);
            visited[i] = false;
        }
        
    }
    
    
    void prc(String str) {
        int num = Integer.parseInt(str);
        
        if(set.contains(num) || num < 2)
            return;
        
        if(checkIfPrime(num)) {
            set.add(num);
        }
    }
    
    boolean checkIfPrime(int num) {
        int end = (int) Math.sqrt(num);
        for(int i = 2; i <= end; i++) {
            if(num % i == 0)
                return false;
        }
        
        return true;
    }
    
}