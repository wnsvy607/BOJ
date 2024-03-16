import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int pickNum = picks[0] + picks[1] + picks[2];
        int interval = Math.min((int) Math.ceil((double) minerals.length / 5), pickNum);
        int len = interval == pickNum ? pickNum * 5 : minerals.length;
        String[] mine = new String[len];
        
        for(int i = 0; i < len; i++) {
            mine[i] = minerals[i];
        }
        
        // [i][0] 원래 인덱스 [i][1] 돌곡괭이 적용시 피로도
        int[][] f = new int[interval][2];
        
        List<Integer> buffer = new ArrayList<>();
        for(int i = 0; i < interval; i++) {
            buffer.clear();
            f[i][0] = i;
            
            for(int j = i * 5; j < i * 5 + 5 && j < len ; j++) {
                buffer.add(mtoi(mine[j]));
            }
            f[i][1] = calFatigue(2, buffer);
        }
        
        Arrays.sort(f, (a,b) -> Integer.compare(b[1], a[1]));
        
        for(int i = 0; i < interval; i++) {
            int s = f[i][0];
            buffer.clear();
            for(int j = s * 5; j < s * 5 + 5 && j < len ; j++) {
                buffer.add(mtoi(mine[j]));
            }
            int t = calFatigue(select(picks), buffer);
            
            answer +=  t;
        }
                
        return answer;
    }
    
    // 다 0 철 1 돌 2
    int[][] convert = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
    
    int calFatigue(int pick, List<Integer> minerals) {
        int result = 0;
        for(int mineral : minerals) {
            result += convert[pick][mineral];
        }
        
        return result;
    }
    
    int mtoi(String mineral) {
        if(mineral.equals("diamond"))
            return 0;
        if(mineral.equals("iron"))
            return 1;
        return 2;
    }
    
    int select(int[] picks) {
        int pick = 2;
        if(picks[1] > 0)
            pick = 1;
        if(picks[0] > 0)
            pick = 0;
        picks[pick]--;
        return pick;
    }
    
}