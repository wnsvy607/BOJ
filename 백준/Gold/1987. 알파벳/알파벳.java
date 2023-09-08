import java.io.*;

public class Main {

	static int maxVal = 0;
	static int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String first = br.readLine();
		String[] s = first.split(" ");
		int r = Integer.valueOf(s[0]);
		int c = Integer.valueOf(s[1]);
		char[][] map = new char[r][c];
		boolean[] visited = new boolean[26];

		for (int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
		}

		visited[uCToI(map[0][0])] = true;
		dfs(map, visited, 0, 0, 1);
		System.out.println(maxVal);
		br.close();
	}

	static void dfs(char[][] map, boolean[] visited, int y, int x, int result) {
		boolean noWay = true;

		for (int i = 0; i < 4; i++) {
			int cy = y + dir[i][0];
			int cx = x + dir[i][1];

			if(Math.min(cy,cx) < 0 || cy >= map.length || cx >= map[0].length)
				continue;

			int alpha = uCToI(map[cy][cx]);
			if(visited[alpha])
				continue;
			visited[alpha] = true;
			dfs(map, visited, cy, cx, result + 1);
			visited[alpha] = false;
			noWay = false;
		}

		if (noWay)
			maxVal = Math.max(maxVal, result);
	}

	static int uCToI(char upperCase) {
		return upperCase - 'A';
	}
}
