import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

		String temp = br.readLine();
		int weight = Integer.parseInt(temp);

		int[] sack = new int[2];
		
		while (weight > 2) {
			if(weight % 5 == 0) {
				weight -= 5;
				sack[1]++;
			} else if(weight % 3 == 0 && weight / 3 < 5) {
				weight -= 3;
				sack[0]++;
			} else {
				weight -= 5;
				sack[1]++;
			}
		}
		
		if (weight == 0)
			pw.print(sack[0] + sack[1]);
		else 
			pw.print(-1);
		pw.flush();
		pw.close();
		br.close();
	}
}