import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		int N = stoi(s[0]);
		int K = stoi(s[1]);

		Queue<Integer> q = new LinkedList<>();
		List<Integer> list = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			list.add(i);
		}

		int now = 0;
		while (!list.isEmpty()) {
			now = (--now + K) % list.size();
			Integer removed = list.remove(now);
			q.add(removed);

		}


		bw.write("<");
		while (!q.isEmpty()) {
			Integer val = q.poll();
			bw.write(itos(val));
			if(!q.isEmpty())
				bw.write(", ");
		}

		bw.write(">");
		bw.flush();

	}


	static String itos(int n) {
		return Integer.toString(n);
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}

}