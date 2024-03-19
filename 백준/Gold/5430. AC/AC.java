import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		boolean reverse;
		int[] pointer = new int[2];
		for (int i = 0; i < t; i++) {
			String operations = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().split(",");
			if (n == 0) {
				if (operations.contains("D"))
					bw.write("error");
				else
					bw.write("[]");
				bw.newLine();
				continue;
			}
			arr[0] = arr[0].replace("[", "");
			arr[n - 1] = arr[n - 1].replace("]", "");

			pointer[0] = -1;
			pointer[1] = n;
			reverse = false;

			int buffer = 0;
			for (int j = 0; j < operations.length(); j++) {
				if (operations.charAt(j) == 'R') {
					if (reverse)
						pointer[1] -= buffer;
					else
						pointer[0] += buffer;
					buffer = 0;
					reverse = !reverse;
					continue;
				}

				buffer++;
			}

			if (buffer != 0) {
				if (reverse)
					pointer[1] -= buffer;
				else
					pointer[0] += buffer;
			}

			if (pointer[1] - pointer[0] < 1)
				bw.write("error");
			else {
				StringBuilder sb = new StringBuilder();
				sb.append("[");

				if (reverse) {
					for (int j = pointer[1] - 1; j > pointer[0]; j--) {
						sb.append(arr[j]);
						if (j != pointer[0] + 1)
							sb.append(",");
					}
				} else {
					for (int j = pointer[0] + 1; j < pointer[1]; j++) {
						sb.append(arr[j]);
						if (j != pointer[1] - 1)
							sb.append(",");
					}
				}

				sb.append("]");
				bw.write(sb.toString());
			}

			if (i != t - 1)
				bw.newLine();
		}

		bw.flush();
	}

}