import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class boj2583 {

	static int N, M, K;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] visit;
	static int count;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		map = new int[N][M];
		visit = new boolean[N][M];

		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = 0;
				visit[i][j] = false;
			}
		}
		for (int i = 0; i < K; i++) {
			int sX = sc.nextInt();
			int sY = sc.nextInt();
			int eX = sc.nextInt();
			int eY = sc.nextInt();

			for (int j = sX; j < eX; j++) {
				for (int h = sY; h < eY; h++) {
					map[h][j] = 1;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0 && !visit[i][j]){
					count = 1;
					dfs(i, j);
					list.add(count);					
				}
			}
		}

		System.out.println(list.size());
		Collections.sort(list);
		for (int temp : list) {
			System.out.print(temp + " ");
		}
	}

	static void dfs(int x, int y) {

		visit[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int tempX = x + dx[i];
			int tempY = y + dy[i];

			if (tempX >= N || tempX < 0 || tempY >= M || tempY < 0) {
				continue;
			}

			if (!visit[tempX][tempY] && map[tempX][tempY] == 0) {
				count++;
				dfs(tempX, tempY);
			}
		}
	}
}
