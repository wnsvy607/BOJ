import java.util.*;

class Solution {
	int[][] dir = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

	public int[] solution(String[][] places) {

		List<Integer> list = new ArrayList<>();
		for (String[] place : places) {
			int[][] map = new int[5][5];

			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (place[i].charAt(j) == 'P')
						map[i][j] = 1;
					else if (place[i].charAt(j) == 'X')
						map[i][j] = -1;
				}
			}
			boolean keepDistance = false;
			for (int i = 0; i < 5; i++) {
				if (keepDistance)
					break;
				for (int j = 0; j < 5; j++) {
					if (keepDistance)
						break;
					if (map[i][j] == 1 && BFS(map, i, j)) {
						list.add(0);
						keepDistance = true;
					}
				}
			}
			if (keepDistance)
				continue;

			list.add(1);

		}

		return list.stream().mapToInt(i -> i).toArray();
	}

	boolean BFS(int[][] map, int y, int x) {
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[5][5];
		q.add(new Point(y, x, 0));
		visited[y][x] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();
			if(p.dist > 2)
				continue;
			
			if (p.dist > 0 && map[p.y][p.x] == 1)
				return true;

			for (int i = 0; i < 4; i++) {
				int cy = p.y + dir[i][0];
				int cx = p.x + dir[i][1];

				if (cy > 4 || cx > 4 || cx < 0 || cy < 0)
					continue;

				if (visited[cy][cx] || map[cy][cx] == -1)
					continue;

				q.add(new Point(cy, cx, p.dist + 1));
			}
		}
		return false;
	}

	class Point {
		int y, x, dist;

		public Point(int y, int x, int dist) {
			this.y = y;
			this.x = x;
			this.dist = dist;
		}
	}
}