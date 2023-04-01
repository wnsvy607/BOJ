import java.util.*;

class Solution {
    private Set<String> set = new HashSet<>();
    
    public int solution(String numbers) {
        
        boolean[] visited = new boolean[numbers.length()];
        perm(numbers, "", visited, 0, 0);
        int answer = 0;
        
        for(String s : set) {
            int num = Integer.parseInt(s);
            if(num <= 1)
                continue;
            boolean isPrimary = true;
            for(int i = 2; i < (int) Math.sqrt(num) + 1 ; i++) {
                if(num % i == 0) {
                    isPrimary = false;
                    break;                    
                }
            }
            if(isPrimary)
                answer++;
        }
        
        
        return answer;
        
    }
    
    public void perm(String numbers, String num, boolean[] visited, int index, int depth) {
        if(depth == numbers.length()) 
            return;            
        
        for(int i = index; i < numbers.length(); i++) {
            if(visited[i])
                continue;
            String start = Integer.toString(Integer.parseInt(num + numbers.charAt(i)));           
            set.add(start);
            visited[i] = true;
            perm(numbers, start, visited, 0, depth + 1);
            visited[i] = false;
        }   
    }
    
    
}