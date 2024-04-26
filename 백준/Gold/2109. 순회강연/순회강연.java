import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = stoi(br.readLine());

		int maxD = 0;
		PriorityQueue<Request> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			Request request = new Request(br.readLine().split(" "));
			maxD = Math.max(maxD, request.day);
			pq.add(request);
		}

		int money = 0;

		boolean[] lectured = new boolean[10_001];

		while (!pq.isEmpty()) {
			Request request = pq.poll();

			for (int i = request.day; i > 0; i--) {
				if(!lectured[i]) {
					lectured[i] = true;
					money += request.pay;
					break;
				}
			}

		}

		bw.write(itos(money));
		bw.flush();
	}

	public static class Request implements Comparable<Request> {
		int pay;
		int day;

		public Request(String[] req) {
			pay = stoi(req[0]);
			day = stoi(req[1]);
		}

		@Override
		public int compareTo(Request request) {
			if (this.pay == request.pay) {
				return Integer.compare(request.day, this.day);
			}
			return Integer.compare(request.pay, this.pay);
		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static String itos(int i) {
		return Integer.toString(i);
	}

}