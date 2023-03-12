class Solution {
    public int[] solution(int num, int total) {
        int x = ( num * ( num - 1 ) ) / 2;
        int dif = (total - x) / num;

        int[] answer = new int[num];
        for (int i = 0 ; i < num ; i++ ) {
            answer[i] = dif + i;
        }
        
        return answer;
    }
}