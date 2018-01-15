import java.util.ArrayList;
import java.util.Scanner;

public class boj1987 {

	static int row; // 가로
	static int col; // 세로
	static char[][] alphabet;

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	static char[] asc = new char[26]; // 65~90 : A~Z
	static int max = 0, count = 1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		row = sc.nextInt();
		col = sc.nextInt();
		alphabet = new char[row][col];

		for (int i = 0; i < row; i++) {
			alphabet[i] = sc.next().toCharArray();
		}

		asc[(int) alphabet[0][0] - 65] = 1;
		dfs(0, 0);
		System.out.println(max);
	}

	static void dfs(int x, int y) {

		int tmp_x, tmp_y;

		max = max <= count ? count : max;

		for (int i = 0; i < 4; i++) {
			tmp_x = x + dx[i];
			tmp_y = y + dy[i];

			if (0 <= tmp_x && tmp_x < row && 0 <= tmp_y && tmp_y < col) {
				if (asc[(int) alphabet[tmp_x][tmp_y] - 65] != 1) {
					count++;
					asc[(int) alphabet[tmp_x][tmp_y] - 65] = 1;

					dfs(tmp_x, tmp_y);

					count--;
					asc[(int) alphabet[tmp_x][tmp_y] - 65] = 0;
				}
			}
		}
	}
}
