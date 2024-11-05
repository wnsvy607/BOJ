import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		N = stoi(s[0]);
		int L = stoi(s[1]);
		int R = stoi(s[2]);

		int[][] map = new int[N][N];
		p = new int[N * N];

		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = stoi(split[j]);
			}
		}

		boolean changed = true;
		Map<Integer, Set<Integer>> uni = new HashMap<>();

		int iter = 0;
		while (changed) {
			for (int i = 0; i < N * N; i++) {
				p[i] = i;
			}
			changed = false;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < 4; k++) {
						int cy = i + dir[k][0];
						int cx = j + dir[k][1];

						if(cy < 0 || cx < 0 || cy >= N || cx >= N)
							continue;
						int dif = Math.abs(map[i][j] - map[cy][cx]);
						if(dif < L || dif > R)
							continue;
						changed = union(i, j, cy, cx) || changed;
					}
				}
			}


			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int idx = i * N + j;
					int parent = find(idx);
					if(parent != idx) {
						// 개방 연합에 대해 인구 이동
						if(!uni.containsKey(parent))
							uni.put(parent, new HashSet<>());
						uni.get(parent).add(idx);
					}
				}
			}


			for (var entry : uni.entrySet()) {
				Integer key = entry.getKey();
				Set<Integer> set = entry.getValue();
				set.add(key);

				int total = 0;
				for(int val : set) {
					int y = val / N;
					int x = val % N;
					total += map[y][x];
				}

				int size = set.size();

				for(int val : set) {
					int y = val / N;
					int x = val % N;
					map[y][x] = total / size;
				}
			}


			uni.clear();
			if (changed)
				iter++;
		}

		bw.write(itos(iter));
		bw.flush();
	}

	static int N;
	static int[] p;
	static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

	static int find(int x) {
		if(p[x] == x) return x;
		return p[x] = find(p[x]);
	}

	static boolean union(int y1, int x1, int y2, int x2) {
		int u = find(y1 * N + x1);
		int v = find(y2 * N + x2);

		if(u == v) return false;

		p[v] = u;
		return true;
	}

	static String itos(int n) {
		return Integer.toString(n);
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}

}