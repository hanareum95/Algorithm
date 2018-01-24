import java.util.Scanner;

public class boj11724 {

	static int N, M;
	static int[][] graph;
	static boolean[] visit;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int count = 0;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		graph = new int[N][N];
		visit = new boolean[N];

		for (int i = 0; i < N; i++) {
			visit[i] = false;
			for (int j = 0; j < N; j++) {
				graph[i][j] = 0;
			}
		}

		for (int i = 0; i < M; i++) {
			int u = sc.nextInt() - 1;
			int v = sc.nextInt() - 1;

			graph[u][v] = 1;
			graph[v][u] = 1;
		}

		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				dfs(i);
				count++;
			}
		}
		System.out.println(count);
	}

	static void dfs(int u) {

		visit[u] = true;

		for (int i = 0; i < N; i++) {
			if (graph[i][u] == 1 && !visit[i])
				dfs(i);
		}
	}
}
