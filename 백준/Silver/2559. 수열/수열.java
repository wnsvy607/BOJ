import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] split = br.readLine().split(" ");

		int N =  stoi(split[0]);
		int K =  stoi(split[1]);

		String[] numbers = br.readLine().split(" ");

		int max = 0;

		for (int i = 0; i < K; i++) {
			max += stoi(numbers[i]);
		}
		int buffer = max;

		for (int i = K; i < N; i++) {
			buffer -= stoi(numbers[i - K]);
			buffer += stoi(numbers[i]);
			max = Math.max(max, buffer);
		}

		bw.write(itos(max));
		bw.flush();
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static String itos(int i) {
		return Integer.toString(i);
	}

}
