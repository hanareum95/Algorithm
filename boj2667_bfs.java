import java.util.*;

public class boj2667_bfs {
	
	static int n;
	static int[][] map;
	static boolean[][] visit;
	static ArrayList<Integer> village;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		visit = new boolean[n][n];
		
		ArrayList<Node> list = new ArrayList<Node>();
		village = new ArrayList<Integer>();
		
		for(int i = 0 ; i < n ; i++ ){
			String temp = sc.next();
			for(int j = 0 ; j < n ; j++){
				map[i][j] = temp.charAt(j) - '0';
				visit[i][j] = false;
				if(map[i][j] == 1)	list.add(new Node(i, j));
			}
		}
		
		for(Node temp : list){
			if(!visit[temp.x][temp.y]){
				visit[temp.x][temp.y] = true;
				bfs(temp.x, temp.y);
			}
		}
		
		System.out.println(village.size());
		Collections.sort(village);
		for(int villageCount : village){
			System.out.println(villageCount);
		}
	}
	
	
	public static void bfs(int x, int y){
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(x, y));
		
		int count = 1;
		
		while(!q.isEmpty()){
			int qX = q.peek().x;
			int qY = q.poll().y;
			
			for(int i = 0 ; i < 4 ; i++){
				int temp_x = qX+dx[i];
				int temp_y = qY+dy[i];
				
				if(0 <= temp_x && temp_x < n && 0 <= temp_y && temp_y < n){
					if(!visit[temp_x][temp_y] && map[temp_x][temp_y] == 1){
						count++;
						visit[temp_x][temp_y] = true;
						q.add(new Node(temp_x, temp_y));
					}
				}
			}
		}
		village.add(count);
	}
}

class Node{
	int x,y;
	public Node(int x, int y){
		this.x = x;
		this.y = y;
	}
}