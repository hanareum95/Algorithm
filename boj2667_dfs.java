import java.util.*;

public class boj2667_dfs {

	static int n;
	static int[][] map;
	static boolean[][] visit;
	static ArrayList<Integer> village;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		visit = new boolean[n][n];

		ArrayList<Node> list = new ArrayList<Node>();
		village = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			String temp = sc.next();
			for (int j = 0; j < n; j++) {
				map[i][j] = temp.charAt(j) - '0';
				visit[i][j] = false;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!visit[i][j] && map[i][j] != 0){
					village.add( dfs(i, j, 0) );				
				}
			}
		}

		System.out.println(village.size());
		Collections.sort(village);
		for (int villageCount : village) {
			System.out.println(villageCount);
		}
	}

	public static int dfs(int x, int y, int count) {
		
		count++;
		visit[x][y] = true;
		
		for(int i = 0 ; i < 4 ; i++){
			int temp_x = x+dx[i];
			int temp_y = y+dy[i];
			
			if (0 > temp_x || temp_x >= n || 0 > temp_y || temp_y >= n)	continue;
			if (map[temp_x][temp_y] == 0)	continue;
			if (visit[temp_x][temp_y])	continue;
			
			count = dfs(temp_x, temp_y, count);			
		}
		
		return count;
	}
}

class Node {
	int x, y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}