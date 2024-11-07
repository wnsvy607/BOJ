import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = stoi(br.readLine());

		for (int t = 0; t < T; t++) {

			String[] s = br.readLine().split(" ");
			int N = stoi(s[0]);
			int M = stoi(s[1]);
			String[] imps = br.readLine().split(" ");

			Queue<Doc> q = new LinkedList<>();
			TreeSet<Doc> set = new TreeSet<>();
			int max = 0;

			for (int i = 0; i < N; i++) {
				int imp = stoi(imps[i]);
				Doc doc = new Doc(i, imp);
				q.add(doc);
				set.add(doc);
				max = Math.max(max, imp);
			}

			int order = 1;

			while (!q.isEmpty()) {

				while (q.peek().imp != max) {
					q.add(q.poll());
				}

				Doc doc = q.poll();
				set.remove(doc);

				if (doc.idx == M)
					break;

				max = set.first().imp;
				order++;
			}

			bw.write(itos(order));

			if (t != T - 1)
				bw.newLine();
		}

		bw.flush();
	}

	static class Doc implements Comparable<Doc> {
		int idx;
		int imp;

		public Doc(int idx, int imp) {
			this.idx = idx;
			this.imp = imp;
		}

		@Override
		public int compareTo(Doc doc) {
			if (this.imp == doc.imp)
				return Integer.compare(this.idx, doc.idx);
			return Integer.compare(doc.imp, this.imp);
		}

	}

	static String itos(int n) {
		return Integer.toString(n);
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}

}