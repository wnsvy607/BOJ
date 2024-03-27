import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = stoi(br.readLine());
		Stack<Integer> stk = new Stack<>();


		for(int i = 0; i < n; i++) {
			String op = br.readLine();

			if(op.contains("push")) {
				stk.add(stoi(op.split(" ")[1]));
				continue;
			} else if(op.contains("pop")) {
				if (stk.isEmpty()) {
					bw.write(itos(-1));
				} else
					bw.write(itos(stk.pop()));
			} else if(op.contains("size")) {
				bw.write(itos(stk.size()));
			} else if(op.contains("empty")) {
				bw.write(stk.isEmpty() ? itos(1) : itos(0));
			} else {
				if (stk.isEmpty())
					bw.write(itos(-1));
				else
					bw.write(itos(stk.peek()));
			}
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