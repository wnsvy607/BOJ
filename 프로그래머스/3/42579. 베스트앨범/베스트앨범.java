import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        int len = genres.length;
        
        Map<String, Integer> cntMap = new HashMap<>();
        Map<String, TreeSet<Song>> map = new HashMap<>();
        
        
        for(int i = 0; i < len; i++) {
            var g = genres[i];
            var p = plays[i];
            
            cntMap.put(g, cntMap.getOrDefault(g, 0) + p);
            
            if(!map.containsKey(g))
                map.put(g, new TreeSet<Song>());
            
            var song = new Song(i, p);
            
            map.get(g).add(song);
        }
        
        
        String[] ge = new String[cntMap.size()];
        
        int i = 0;
        for(var en : cntMap.entrySet()) {
            ge[i++] = en.getKey();
        }
        
        Arrays.sort(ge, (a, b) -> 
            Integer.compare(cntMap.get(b), cntMap.get(a))
        );
        
        List<Integer> res = new ArrayList<>();
        
        for(i = 0; i < ge.length; i++) {
            
            var songs = map.get(ge[i]);
            
            res.add(songs.pollFirst().idx);
            if(!songs.isEmpty())
                res.add(songs.pollFirst().idx);
                
        }
        
        return res.stream().mapToInt(a -> a).toArray();
    }
    
    static class Song implements Comparable<Song> {
        int idx;
        int play;
        
        
        Song(int idx, int play) {
            this.idx = idx;
            this.play = play;
        }
        
        
        @Override
        public int compareTo(Song s) {
            if(this.play == s.play)
                return Integer.compare(this.idx, s.idx);
            return Integer.compare(s.play, this.play);
        }
        
        
    }
    
    
}