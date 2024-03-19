import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	static int n;
	static int m;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nm = br.readLine().split(" ");
		n = Integer.parseInt(nm[0]);
		m = Integer.parseInt(nm[1]);

		List<Point> caseList = new ArrayList<>();
		List<Point> houseList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String[] split = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				int status = Integer.parseInt(split[j]);
				if (status == 2)
					caseList.add(new Point(i, j));
				else if (status == 1)
					houseList.add(new Point(i, j));
			}
		}

		combi(caseList, 0, m, houseList, new HashSet<>());

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(Integer.toString(result));
		bw.flush();
	}

	static void combi(List<Point> caseList, int start, int h, List<Point> houseList, Set<Point> open) {
		if (h == 0) {
			result = Math.min(result, getChickenDistance(houseList, open));
			return;
		}

		for (int i = start; i < caseList.size(); i++) {
			Point p = caseList.get(i);
			open.add(p);
			combi(caseList, i + 1, h - 1, houseList, open);
			open.remove(p);
		}
	}

	static int getChickenDistance(List<Point> houseList, Set<Point> open) {
		int res = 0;

		for (Point house : houseList) {
			int min = Integer.MAX_VALUE;
			
			for(Point restaurant : open) {
				min = Math.min(min, distance(house, restaurant));
			}
			res += min;
		}
		return res;
	}
	
	static int distance(Point a, Point b) {
		return Math.abs(a.y - b.y) + Math.abs(a.x - b.x);
	}

	static class Point {
		int y;
		int x;

		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
