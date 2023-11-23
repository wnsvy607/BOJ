class Solution {
    
    int[] sale = {10, 20, 30, 40}; 
    int[][] users;
    int[] emoticons;
    int maxEplus = 0;
    int maxRevenue = 0;
    
    
    public int[] solution(int[][] u, int[] e) {
        users = u;
        emoticons = e;

        int len = emoticons.length;
        int[] arr = new int[len];
        combi(arr, len, 0);
        int[] answer = {maxEplus, maxRevenue/100};
        return answer;
    }
    
    // 완전탐색
    void combi(int[] arr, int r, int idx) {
        if(r == 0) {
            cal(arr, idx);
            return;
        }
        
        for(int i = 1; i < 5; i++) {
            arr[idx] = sale[i-1];
            combi(arr, r - 1, idx + 1);
        }
    }
    
    // 계산
    void cal(int[] combi, int len) {      
        int eplus = 0;
        int revenue = 0;
        
        for(int[] user :users) {
            int ms = user[0];
            int mp = user[1] * 100;
            
            int cost = 0;
            
            for (int i = 0; i < len; i++) {
                if (combi[i] >= ms) {
                    cost += emoticons[i] * (100 - combi[i]);   
                }
            }
            
            if(cost >= mp)
                eplus++;
            else
                revenue += cost;
        }
        
        if(eplus > maxEplus) {
            maxEplus = eplus;
            maxRevenue = revenue;
        }
        else if(eplus == maxEplus && revenue > maxRevenue) {
            maxRevenue = revenue;
        }
        
        
    }
    
}