import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int k = Integer.parseInt(br.readLine());
		Stack<Integer> stk = new Stack<>();
		for (int i = 0; i < k; i++) {
			int num = Integer.parseInt(br.readLine());

			if (num != 0)
				stk.add(num);
			else
				stk.pop();
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(stk.stream().mapToInt(i -> i).sum()));
		bw.flush();

	}
}
