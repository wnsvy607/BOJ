import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = stoi(br.readLine());
		int[][] board = new int[N][N];
		int K = stoi(br.readLine());
		for (int j = 0; j < K; j++) {
			String[] split = br.readLine().split(" ");
			board[stoi(split[0]) - 1][stoi(split[1]) - 1] = 1;
		}

		int L = Integer.parseInt(br.readLine());
		int prev = 0;
		int direction = 0;
		Deque<Point> q = new ArrayDeque<>();
		q.add(new Point(0, 0));
		board[0][0] = 2;
		boolean flag = false;

		for (int i = 0; i < L; i++) {
			String[] split = br.readLine().split(" ");
			int now = stoi(split[0]);
			// prev ~ now까지 이동
			int time = now - prev;
			int j;
			for (j = 1; j <= time; j++) {
				Point head = q.peekFirst();
				int cy = head.y + dir[direction][0];
				int cx = head.x + dir[direction][1];
				if (cy < 0 || cx < 0 || cy >= N || cx >= N || board[cy][cx] == 2) {
					flag = true;
					prev = prev + j;
					break;
				}
				if (board[cy][cx] == 0) {
					Point tail = q.pollLast();
					board[tail.y][tail.x] = 0;
				}
				board[cy][cx] = 2;
				q.addFirst(new Point(cy, cx));
			}

			if (flag) {
				break;
			}

			prev = now;
			direction = change(split[1], direction);
		}

		if (!flag) {
			Point head = q.peekFirst();
			int y = head.y + dir[direction][0];
			int x = head.x + dir[direction][1];
			prev++;
			while (y > -1 && x > -1 && y < N && x < N && board[y][x] != 2) {
				if (board[y][x] == 0) {
					Point tail = q.pollLast();
					board[tail.y][tail.x] = 0;
				}
				q.addFirst(new Point(y, x));
				y = y + dir[direction][0];
				x = x + dir[direction][1];
				prev++;
			}
		}

		bw.write(Integer.toString(prev));
		bw.flush();
	}

	// 우, 하, 좌
	static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

	static int stoi(String num) {
		return Integer.parseInt(num);
	}

	static int change(String direction, int cd) {
		int result = cd;
		if (direction.equals("D"))
			result++;
		else
			result--;
		if (result < 0)
			result += 4;

		return result % 4;
	}

	static class Point {
		int y, x;

		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
