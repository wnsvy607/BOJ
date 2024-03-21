import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	static int total = 0;
	static int size = 2;
	static int n = 0;
	static int[][] sea;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = stoi(br.readLine());
		sea = new int[n][n];
		int leftFish = 0;

		int y = 0, x = 0;
		for (int i = 0; i < n; i++) {
			String[] split = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				if (stoi(split[j]) == 9) {
					y = i;
					x = j;
					continue;
				}
				sea[i][j] = stoi(split[j]);
				leftFish++;
			}
		}

		int fish = 0;

		while (leftFish > 0) {

			List<Point> cands = bfs(y, x);
			if (cands.isEmpty())
				break;
			cands.sort(Comparator.naturalOrder());
			Point next = cands.get(0);
			total += next.distance;

			if (++fish == size) {
				size++;
				fish = 0;
			}

			y = next.y;
			x = next.x;

			sea[y][x] = 0;
			leftFish--;
		}

		bw.write(String.valueOf(total));
		bw.flush();
	}

	// 우, 하, 좌
	static int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

	static int stoi(String num) {
		return Integer.parseInt(num);
	}

	static class Point implements Comparable<Point> {
		int y, x, distance;

		Point(int y, int x, int distance) {
			this.y = y;
			this.x = x;
			this.distance = distance;
		}

		@Override
		public int compareTo(Point p) {
			int compare = Integer.compare(this.y, p.y);
			if (compare == 0)
				return Integer.compare(this.x, p.x);
			return compare;
		}
	}

	static List<Point> bfs(int y, int x) {
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][n];
		visited[y][x] = true;
		q.add(new Point(y, x, 0));

		List<Point> result = new ArrayList<>();

		boolean found = false;
		int min = Integer.MAX_VALUE;

		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int i = 0; i < 4; i++) {
				int cy = p.y + dir[i][0];
				int cx = p.x + dir[i][1];
				if (cy < 0 || cx < 0 || cy >= n || cx >= n || visited[cy][cx] || sea[cy][cx] > size)
					continue;

				Point next = new Point(cy, cx, p.distance + 1);
				if (sea[cy][cx] != 0 && sea[cy][cx] < size) {
					if (!found) {
						min = next.distance;
						result.add(next);
						found = true;
					} else if (min == next.distance) {
						result.add(next);
					}
				}

				visited[cy][cx] = true;
				q.add(next);
			}
		}

		return result;
	}

}
