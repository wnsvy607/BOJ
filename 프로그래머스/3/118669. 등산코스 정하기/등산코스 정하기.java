import java.util.*;

class Solution {

	ArrayList<Node>[] graph;

	public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
		graph = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		Set<Integer> gateSet = new HashSet<>();
		Set<Integer> summitSet = new HashSet<>();
		for (int gate : gates) {
			gateSet.add(gate);
		}
		for (int summit : summits) {
			summitSet.add(summit);
		}

		for (int[] path : paths) {
			int i = path[0];
			int j = path[1];
			int cost = path[2];
			if (!summitSet.contains(i) && !gateSet.contains(j))
				graph[i].add(new Node(j, cost));
			if (!summitSet.contains(j) && !gateSet.contains(i))
				graph[j].add(new Node(i, cost));
		}

		return search(n, gateSet, summitSet);
	}

	int[] search(int n, Set<Integer> gates, Set<Integer> summits) {

		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[n + 1];

		for (Integer gate : gates) {
			pq.add(new Node(gate, 0));
		}

		int s = Integer.MAX_VALUE;
		int value = Integer.MAX_VALUE;

		while (!pq.isEmpty()) {
			Node node = pq.poll();
			if (visited[node.index])
				continue;
			visited[node.index] = true;

			if (summits.contains(node.index)) {
				if (value == node.cost) {
					s = Math.min(node.index, s);
				} else if (value > node.cost) {
					s = node.index;
					value = node.cost;
				}
			}

			for (Node next : graph[node.index]) {
				if (!visited[next.index]) {
					pq.offer(new Node(next.index, Math.max(next.cost, node.cost)));
				}
			}
		}

		return new int[] {s, value};

	}

	class Node implements Comparable<Node> {
		int index;
		int cost;

		Node(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node node) {
			return Integer.compare(this.cost, node.cost);
		}
	}

}