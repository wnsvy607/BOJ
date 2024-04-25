import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] split = br.readLine().split(" ");
		int N =  stoi(split[0]);
		int M =  stoi(split[1]);

		int count = 0;
		String[] nums = br.readLine().split(" ");
		int[] numbers = Arrays.stream(nums).mapToInt(Main::stoi).toArray();

		int s = 0;
		int e = 1;

		int sum = numbers[0];

		while(s < N && e <= N) {
			if(sum < M) {
				if(e == N)
					break;
				sum += numbers[e++];
				continue;
			} else if(sum == M) {
				count++;
			}
			sum -= numbers[s++];
		}

		bw.write(itos(count));
		bw.flush();
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static String itos(int i) {
		return Integer.toString(i);
	}

}