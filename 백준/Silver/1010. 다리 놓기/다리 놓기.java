import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = stoi(br.readLine());
		List<Integer> answer = new ArrayList<>();
		for (int k = 0; k < t; k++) {
			String[] nm = br.readLine().split(" ");
			int n = stoi(nm[0]);
			int m = stoi(nm[1]);
			int[]dp = new int[m + 1];
			dp[0] = 1;
			dp[1] = m;

			for (int i = 2; i < n + 1; i++) {
				dp[i] = dp[i - 1] * (m - i + 1) / i;
			}

			answer.add(dp[n]);
		}

		for(var ans : answer) {
			bw.write(itos(ans));
			bw.newLine();
		}
		bw.flush();
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static String itos(int i) {
		return Integer.toString(i);
	}

}