import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = stoi(br.readLine());
		int[][] pe = new int[N][2];
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			pe[i][0] = stoi(s[0]);
			pe[i][1] = stoi(s[1]);
		}

		int[] ranking = new int[N];
		for (int i = 0; i < N; i++) {
			int rank = 1;

			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;

				if (pe[j][0] > pe[i][0] && pe[j][1] > pe[i][1]) {
					rank++;
				}
			}
			ranking[i] = rank;
		}

		for (int i = 0; i < N - 1; i++) {
			bw.write(ranking[i] + " ");

		}
		bw.write(itos(ranking[N - 1]));
		bw.flush();
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static String itos(int i) {
		return Integer.toString(i);
	}

}