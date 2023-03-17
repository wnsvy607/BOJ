import java.util.ArrayList;
import java.util.Collections;

class Pair implements Comparable<Pair>{
	int start, end;

	public Pair(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public Integer length() {
		return end - start;
	}

	@Override
	public int compareTo(Pair pair) {
		if(this.start == pair.start){
			if(this.end > pair.end)
				return 1;
			else
				return -1;
		} else if(this.start > pair.start) {
			return 1;
		} else {
			return -1;
		}
	}
}

class Solution {
    public int solution(int[][] lines) {
		ArrayList<Pair> list = new ArrayList<>();
		for (int i = 0; i < 2; i++) {
			for (int j = i + 1; j < 3; j++) {
				if (lines[i][1] <= lines[j][0] || lines[i][0] >= lines[j][1])
					continue;
				else {
					int start = Math.max(lines[i][0], lines[j][0]);
					int end = Math.min(lines[i][1], lines[j][1]);
					list.add(new Pair(start, end));
				}

			}
		}

		if (list.size() == 0) {
			return 0;
		} else if (list.size() == 1) {
			return list.get(0).length();
		}

		Collections.sort(list);

		int answer = 0;
		for (int i = 1; i < list.size(); i++) {
			Pair prev = list.get(i - 1);
			Pair present = list.get(i);

			if (prev.end > present.start)
				answer += present.start - prev.start;
			else
				answer += prev.length();
			if (i == list.size() - 1)
				answer += present.length();
		}

		return answer;

    }
}