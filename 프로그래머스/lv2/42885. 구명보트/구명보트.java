import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Map<Integer, Integer> map = new TreeMap<>();
        
        int ship = 0;
        int minimum = 240;
        for(int weight : people) {
            map.put(weight, map.getOrDefault(weight, 0) + 1);
            minimum = Math.min(minimum, weight);
        }
        
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, Collections.reverseOrder());
        
        for(Integer weight : list) {
            while(map.get(weight) > 0) {
                // 제일 먼저 1명을 태운다.
                int rest = limit - weight;
                map.put(weight, map.get(weight) - 1);
                ship++; 
                
                // 남은 공간이 minimum 보다 작지 않으면 추가로 사람들을 태운다.
                if(rest >= minimum) {
                    // 탐색을 시작하는 무게는 남은 여유 무게부터 시작한다.
                    for(int wei = rest; wei >= minimum; wei--) {
                        Integer value = map.get(wei);
                        //해당 무게의 사람이 있는 경우
                        if(value != null && value > 0) {
                            //태운다.
                            map.put(wei, map.get(wei) - 1);
                            break;
                        }
                    }
                }
            }
        }
        return ship;
    }
}