class Solution {
    public int solution(int[] common) {
		int answer = 0;
		int dif1 = common[2] - common[1];
		int dif2 = common[1] - common[0];

		if (common[0] == 0 || dif1 == dif2) {
			answer = common[common.length - 1] + dif1;
		} else {
			answer = (common[common.length - 1] * common[1]) / (common[0]);
		}

		return answer;

    }
}