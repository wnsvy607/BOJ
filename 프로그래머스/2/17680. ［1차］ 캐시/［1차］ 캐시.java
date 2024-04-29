import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        Queue<String> q = new LinkedList<>();
        Set<String> db = new HashSet<>();
        
        int cost = 0;
        
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        for(String city : cities) {
            // 캐시 미스
            
            String key = city.toLowerCase();
            if(!db.contains(key)) {
                // 캐시에 더 넣을 공간이 없을 때
                if(q.size() >= cacheSize) {
                    if(!q.isEmpty()) {
                        String r = q.poll();    
                        db.remove(r);
                    }
                }
                // 새로운 캐시 삽입
                q.add(key);
                db.add(key);
                cost += 5;
            } 
            // 캐시 히트
            else {
                // 캐시 업데이트
                q.remove(key);
                q.add(key);
                cost++;
            }
            
        }
        
        
        return cost;
    }
    
}