import java.util.*;

class Solution {
    
    int baseTime;
    int baseFee;
    int timeUnit;
    int feeUnit;
    
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> accTime = new TreeMap<>();
        Map<String, Integer> in = new HashMap<>();
        
        baseTime = fees[0];
        baseFee = fees[1];
        timeUnit = fees[2];
        feeUnit = fees[3];
        
        
        
        // 1. 입차는 스택에 넣으며, 출차시 입차를 제거, 시간을 더한다.
        for(String rec : records ) {
            String[] info = rec.split(" ");
            int time = toMinutes(info[0]);
            String number = info[1];
            
            if(info[2].equals("IN")) {
                in.put(number, time);
            } else {
                int inTime = in.get(number);
                in.remove(number);
                int parkingTime = time - inTime;
                
                accTime.put(number, accTime.getOrDefault(number, 0) + parkingTime);
            }
        }        
        // 3. 스택에 남은 입차기록을 23:59에 출차한 것으로 처리하여 누적 시간에 더한다.
        for(Map.Entry<String, Integer> e  : in.entrySet()) {
            String number = e.getKey();
            int inTime = e.getValue();
            int outTime = 23 * 60 + 59;
            int parkingTime = outTime - inTime;
            accTime.put(number, accTime.getOrDefault(number, 0) + parkingTime);
        }

        
        // 4. 정답 리스트에 요금을 계산하여 넣는다.
        List<Integer> answer = new ArrayList<>();
        for(Map.Entry<String, Integer> e : accTime.entrySet()) {
            int totalTime = e.getValue();
            answer.add(calFee(totalTime));
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    public Integer toMinutes(String time) {
        String[] t = time.split(":");
        
        int h = Integer.parseInt(t[0]); 
        int m = Integer.parseInt(t[1]);
        
        return h * 60 + m;     
    }
    
    public Integer calFee(int parkingTime) {
        if(baseTime >= parkingTime)
            return baseFee;
        
        int chargedTime = (parkingTime - baseTime) / timeUnit;
        if( (parkingTime - baseTime) % timeUnit != 0)
            chargedTime++;
            
        return chargedTime * feeUnit + baseFee;       
        
    }
    
    
    
}