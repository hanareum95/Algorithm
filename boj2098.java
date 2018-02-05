import java.util.Scanner;
import java.util.StringTokenizer;

public class boj2098 {

	static int[][] dp;
	static int[][] weight;
	static int N;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		weight = new int[N][N];
		dp = new int[1<<16][16];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				weight[i][j] = sc.nextInt();
			}
		}

		System.out.println(turn(0, 1));
	}

	public static int turn(int current, int visited) {

		// 전부 방문한 경우
		if (visited == (1 << N) - 1) {
			if (weight[current][0] != 0) {
				return weight[current][0];
			}
			return 10000;
		}

		if (dp[current][visited] == 0) {

			dp[current][visited] = 10000;

			for (int i = 0; i < N; i++) {
				// i번 노드 방문 체크하고, i를 시작점으로 재귀
				if (weight[current][i] != 0 && (visited & (1 << i)) <= 0) {
					dp[current][visited] = Math.min(dp[current][visited],
							turn(i, visited | (1 << i)) + weight[current][i]);
				}
			}
		}
		return dp[current][visited];
	}
}
