import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = stoi(br.readLine());
		int M = stoi(br.readLine());

		List<Edge>[] edges = new List[N + 1];

		for (int i = 0; i < N + 1; i++) {
			edges[i] = new ArrayList<>();
		}


		for (int i = 0; i < M; i++) {
			String[] bus = br.readLine().split(" ");

			int from = stoi(bus[0]);
			int to = stoi(bus[1]);
			int cost = stoi(bus[2]);

			Edge edge = new Edge(to, cost);

			edges[from].add(edge);
		}

		String[] point = br.readLine().split(" ");
		int start = stoi(point[0]);
		int dest = stoi(point[1]);


		PriorityQueue<Edge> pq = new PriorityQueue<>();
		long[] dist = new long[N + 1];
		boolean[] visited = new boolean[N + 1];
		Arrays.fill(dist, Long.MAX_VALUE);
		dist[start] = 0L;

		pq.add(new Edge(start, 0));

		while (!pq.isEmpty()) {
			Edge edge = pq.poll();

			int from = edge.to;

			if(visited[from])
				continue;
			visited[from] = true;

			for(Edge next : edges[from]) {

				if(dist[next.to] <= dist[from] + next.cost)
					continue;

				dist[next.to] = dist[from] + next.cost;

				pq.offer(new Edge(next.to, dist[next.to]));
			}

		}

		bw.write(Long.toString(dist[dest]));

		bw.flush();
	}


	static class Edge implements Comparable<Edge> {

		int to;
		long cost;

		public Edge(int to, long cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge edge) {
			return Long.compare(this.cost, edge.cost);
		}
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}

}