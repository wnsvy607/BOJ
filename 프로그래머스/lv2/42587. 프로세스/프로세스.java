import java.util.*;

class Solution {
    int answer = 0;
    
    public int solution(int[] priorities, int location) {
        
        Queue<Process> q = new LinkedList<>();
        
        for(int i = 0; i < priorities.length ; i++)
            q.add(new Process(priorities[i],i));
        
        int cnt = 0;
        while(!q.isEmpty()) {
            Process process = q.poll(); 
            
            if(q.stream().anyMatch(other -> process.priority < other.priority)) {
                q.add(process);
            } else if(location == process.index) {
                answer = cnt + 1;
                break;
            } else {
                cnt ++;
            }
            
        }
        
        
        return answer;
    }
    
    class Process {
        int priority;
        int index;
        
        public Process(int p, int i) {
            priority = p;
            index = i;
        }
    }
}


