import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] tws) {        
        Queue<Truck> q = new LinkedList<>();
        int len = tws.length;
        
        int now = 0;
        int onBridge = 0;
        
        q.add(new Truck(now, tws[0]));
        onBridge += tws[0];
        
        for(int i = 1; i < len; i++) {
            
            if(onBridge + tws[i] <= weight && q.size() < bridge_length) {
                q.add(new Truck(++now, tws[i]));
                onBridge += tws[i];
                while(!q.isEmpty() && q.peek().inAt + bridge_length <= now) {
                    onBridge -= q.poll().weight;
                }
                    
                continue;
            }
            
            
            while(onBridge + tws[i] > weight || q.size() >= bridge_length) {
                var truck = q.poll();
                onBridge -= truck.weight;
                now = truck.inAt + bridge_length;
            }
            
                
            q.add(new Truck(now, tws[i]));
            onBridge += tws[i];
            
        }
        
        
        Truck last = new Truck(0, 0);
        while(!q.isEmpty()) {
            last = q.poll();
        }

        
        
        return last.inAt + bridge_length + 1;
    }
    
    
    static class Truck {
        int inAt;
        int weight;
        
        public Truck(int time, int weight) {
            inAt = time;
            this.weight = weight;
        }
        
    }
}