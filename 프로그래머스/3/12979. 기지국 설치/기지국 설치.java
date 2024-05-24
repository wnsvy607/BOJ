class Solution {
    public int solution(int n, int[] stations, int w) {
        int count = 0;
        int len = stations.length;
        int prev = 0;
        for(int i = 0; i < len; i++) {
            int station = stations[i];
            int end = station - w - 1;
            
            if(prev + 1 <= end) {
                count += getNecessary(prev + 1, end, w);
            }
                
            prev = Math.min(station + w, n);
        }
        
        if(prev != n) {
            count += getNecessary(prev + 1, n, w);
        }
        
        return count;
    }
    
    int getNecessary(int start, int end, int w) {
        int coverage = end - start + 1;
        return (int) Math.ceil(coverage / (2 * w + 1d));
    }
    
}