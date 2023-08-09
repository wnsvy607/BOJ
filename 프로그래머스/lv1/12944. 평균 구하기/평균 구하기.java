class Solution {
    public double solution(int[] arr) {
        
        int total = 0;
        for(int element : arr) {
            total += element;
        }
        
        return (double) total / arr.length;
    }
}