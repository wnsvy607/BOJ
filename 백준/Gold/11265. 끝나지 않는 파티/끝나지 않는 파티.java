import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int N = 0;
	static int M = 0;
	static int[][] roads;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] nm = br.readLine().split(" ");
		N = stoi(nm[0]);
		M = stoi(nm[1]);
		roads = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < s.length; j++) {
				roads[i][j] = stoi(s[j]);
			}
		}

		for (int t = 0; t < N; t++) {
			for (int s = 0; s < N; s++) {
				if (t == s)
					continue;
				for (int e = 0; e < N; e++) {
					if (t == e || s == e)
						continue;
					roads[s][e] = Math.min(roads[s][e], roads[s][t] + roads[t][e]);
					// System.out.println(s + ", " + e);
				}
			}
		}

		for (int i = 0; i < M; i++) {
			String[] s = br.readLine().split(" ");
			int start = stoi(s[0]);
			int dest = stoi(s[1]);
			int within = stoi(s[2]);
			if (within < getMinTime(start - 1, dest - 1)) {
				bw.write("Stay here");
			} else {
				bw.write("Enjoy other party");
			}
			if (i != M - 1)
				bw.newLine();
		}

		bw.flush();
	}

	static int getMinTime(int start, int dest) {
		return roads[start][dest];
	}

	static class Node implements Comparable<Node> {
		int idx;
		int distance;

		public Node(int idx, int distance) {
			this.idx = idx;
			this.distance = distance;
		}

		@Override
		public int compareTo(Node node) {
			return Integer.compare(this.distance, node.distance);
		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static String itos(int i) {
		return Integer.toString(i);
	}

}