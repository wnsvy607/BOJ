import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {        
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        TreeSet<Cache> pq = new TreeSet<>();
        Map<String, Cache> db = new HashMap<>();
        
        int time = 0;
        int cost = 0;
        

        for(String city : cities) {
            // 캐시 미스
            String key = city.toLowerCase();
            
            if(!db.containsKey(key)) {
                // 캐시에 더 넣을 공간이 없을 때
                if(pq.size() > cacheSize - 1) {
                    Cache r = pq.pollFirst();    
                    db.remove(r.key);
                }
                // 새로운 캐시 삽입
                Cache c = new Cache(key, time);
                db.put(key, c);
                pq.add(c);
                cost += 5;
            } 
            // 캐시 히트
            else {
                // 캐시 업데이트
                pq.remove(db.get(key));
                Cache nc = new Cache(key, time);
                db.put(key, nc);
                pq.add(nc);
                cost++;    
            }
            time++;
        }
        
        
        return cost;
    }
    
    class Cache implements Comparable<Cache> {
        String key;
        int time;
        
        Cache(String k, int t) {
            key = k;
            time = t;
        }
        
        @Override
        public int compareTo(Cache c) {
            if(this.time == c.time)
                return this.key.compareTo(c.key);
            return Integer.compare(this.time, c.time);
        }
        
        @Override
        public boolean equals(Object o) {
            Cache c = (Cache) o;
            return this.key.equals(c.key) && time == c.time;
        }
        
		@Override
		public int hashCode() {
			return Objects.hash(key);
		}
        
    }
}