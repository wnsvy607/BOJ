class Solution {
    public int[] solution(int[] sequence, int k) {

        int len = sequence.length;
        int[] answer = {0, len};
        int s = len - 1; int e = len - 1;
        int sum = sequence[len - 1];
        
        while(e > -1 && s > -1) {
            while(sum < k && s != 0) {
                sum += sequence[--s];
            }
            
            if(sum == k && e - s <= answer[1] - answer[0]) {
                answer[0] = s;
                answer[1] = e;
            }
            
            sum -= sequence[e];
            e--;
        }
        
        
        
        return answer;        
    }
}