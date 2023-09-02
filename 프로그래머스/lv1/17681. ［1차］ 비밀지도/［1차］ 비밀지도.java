class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] map = new String[n];
        
        for(int i = 0; i < n; i++) {
            int valA = arr1[i];
            int valB = arr2[i];
            map[i] = "";
            for(int j = 0; j < n; j++) {
                if(valA % 2 == 1 || valB % 2 == 1) {
                    map[i] = "#" + map[i];
                } else {
                    map[i] = " " + map[i];
                }
                valA = valA / 2;
                valB = valB / 2;
            }
            
        }
        
        return map;
    }
}