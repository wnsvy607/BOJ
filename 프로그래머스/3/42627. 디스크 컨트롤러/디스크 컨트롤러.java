import java.util.*;

class Solution {
    
    public int solution(int[][] jobs) {
        // 전체 걸린 작업 시간
        int cur = 0, total = 0;
        
        // 다음에 수행될 작업를 가리키는 포인터
        int pointer = 0;
        
        // 요청시간 순으로 정렬
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));
        
        PriorityQueue<Job> q = new PriorityQueue<>();
        while(true) {
            if(q.isEmpty() && pointer >= jobs.length)
                break;
            // Q에 작업이 있으면
            if(!q.isEmpty()) {
                // 작업 수행
                Job job = q.poll();                
                System.out.println(cur - job.req + job.time);
                total += cur - job.req + job.time;
                cur += job.time;
                while(pointer < jobs.length && cur >= jobs[pointer][0]) {
                    q.add(new Job(jobs[pointer][0], jobs[pointer][1]));
                    pointer++;
                }
 
            } 
            // 없으면 기다렸다가 제일 먼저 요청이 들어온 것 넣기
            else {
                q.add(new Job(jobs[pointer][0], jobs[pointer][1]));
                cur = jobs[pointer][0]; 
                pointer++;
                // 동일한 시간에 요청된 것 넣기
                while(pointer < jobs.length && cur == jobs[pointer][0]) {
                    q.add(new Job(jobs[pointer][0], jobs[pointer][1]));
                    pointer++;
                }
            }

        }
        
        return (int) (total / jobs.length);
    }
    
    class Job implements Comparable<Job>  {
        
        int req;
        int time;
        
        Job(int req, int time) {
            this.req = req;
            this.time = time;
        }
        
        public int compareTo(Job job) {
            return Integer.compare(this.time, job.time);
        }
        
    }
}