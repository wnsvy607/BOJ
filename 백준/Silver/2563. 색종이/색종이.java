import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		int N = stoi(s[0]);

		int[][] map = new int[101][101];

		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split(" ");
			int x = stoi(split[0]) - 1;
			int y = stoi(split[1]) - 1;

			for (int j = y; j < y + 10; j++) {
				for (int k = x; k < x + 10; k++) {
					map[j][k]++;
				}
			}
		}

		int count = 0;

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(map[i][j] != 0) count++;
			}
		}

		bw.write(itos(count));
		bw.flush();
	}

	static String itos(int n) {
		return Integer.toString(n);
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}

}