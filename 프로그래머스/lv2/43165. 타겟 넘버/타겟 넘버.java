class Solution {
    int t;
    int[] n;
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        n = numbers;
        t = target;
        dfs(0, 0, 0);
        return answer;
    }
    
    
    public void dfs(int result, int index, int depth) {
        if(depth == n.length){
            if(result == t)
                answer++;
            return;
        }
        
        dfs(result + n[index], index + 1, depth + 1);
        dfs(result - n[index], index + 1, depth + 1);

    }
}