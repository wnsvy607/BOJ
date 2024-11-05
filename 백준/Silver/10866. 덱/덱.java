import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		int N = stoi(s[0]);

		Deque<Integer> dq = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			String op = br.readLine();
			if (op.startsWith("push")) {
				int X = stoi(op.split(" ")[1]);
				if (op.startsWith("push_front")) {
					dq.offerFirst(X);
				} else {
					dq.offerLast(X);
				}

			} else if (op.startsWith("pop")) {
				if (dq.isEmpty()) {
					bw.write("-1");
				} else if (op.equals("pop_front")) {
					bw.write(itos(dq.pollFirst()));
				} else {
					bw.write(itos(dq.pollLast()));
				}
				if(i < N - 1)
					bw.newLine();
			} else {
				if (op.equals("size")) {
					bw.write(itos(dq.size()));
				} else if (op.equals("empty")) {
					bw.write(dq.isEmpty() ? "1" : "0");
				} else {
					if (dq.isEmpty()) {
						bw.write("-1");
					} else if (op.equals("front")) {
						bw.write(itos(dq.peekFirst()));
					} else {
						bw.write(itos(dq.peekLast()));
					}
				}
				if(i < N - 1)
					bw.newLine();
			}
		}

		bw.flush();
	}

	static String itos(int n) {
		return Integer.toString(n);
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}

}
