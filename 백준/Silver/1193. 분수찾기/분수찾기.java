import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int x = Integer.valueOf(br.readLine());

		int i;
		for (i = 1; i < x; i++) {
			if ((i + 1) * i / 2 >= x)
				break;
		}
		int l = i, r = 1;
		int move = x - ((i - 1) * i / 2) - 1;
		l -= move;
		r += move;
		if(i % 2 == 0){
			int temp = l;
			l = r;
			r = temp;
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(l + "/" + r);
		bw.flush();

	}
}
