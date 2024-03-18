import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		int[] dp = new int[10001];

		for (int i = 1; i < 10001; i++) {
			int cal = cal(i);
			if (cal < 10001)
				dp[cal]++;
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 1; i < 10001; i++) {
			if (dp[i] == 0) {
				bw.write(String.valueOf(i));
				bw.newLine();
			}
		}
		bw.flush();

	}

	static int cal(int n) {
		int temp = n;
		int result = temp;
		while (temp > 0) {
			result += temp % 10;
			temp = temp / 10;
		}
		return result;
	}

}
