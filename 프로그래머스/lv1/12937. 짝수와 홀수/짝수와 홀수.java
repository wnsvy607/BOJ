class Solution {
    public String solution(int num) {
        if(Math.abs(num) % 2 == 1)
            return "Odd";
        return "Even";
    }
}