import java.util.*;

public class boj7562 {

	static int[][] chess;
	static boolean[][] visit;
	static int N;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int caseNum = sc.nextInt();
		
		for(int i = 0 ; i < caseNum ; i++){
			N = sc.nextInt();
			
			init();
			
			int present_X = sc.nextInt();
			int present_Y = sc.nextInt();
			int arrive_X = sc.nextInt();
			int arrive_Y = sc.nextInt();
		
			bfs(present_X, present_Y);
			
			
			System.out.println(chess[arrive_X][arrive_Y]);
		}
		
	}
	
	static void init(){
		chess = new int[N][N];
		visit = new boolean[N][N];
		for(int i = 0 ; i < N ; i++){
			for(int j = 0 ; j < N ; j++){
				chess[i][j] = 0;
				visit[i][j] = false;
			}
		}
	}

	static void bfs(int start_x, int start_y){
		int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
		int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
		
		int q_x, q_y, tmp_x, tmp_y;
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node1(start_x, start_y));
		visit[start_x][start_y] = true;
		
		while(!q.isEmpty()){
			q_x = q.peek().x;
			q_y = q.poll().y;
			
			for(int i = 0 ; i < 8 ; i++){
				tmp_x = q_x+dx[i];
				tmp_y = q_y+dy[i];
				
				if(0 <= tmp_x && tmp_x < N && 0 <= tmp_y && tmp_y < N){
					if(visit[tmp_x][tmp_y] == false){
						visit[tmp_x][tmp_y] = true;
						chess[tmp_x][tmp_y] = chess[q_x][q_y]+1;
						q.add(new Node(tmp_x, tmp_y));
					}
				}
			}
		}
	}
}
class Node{
	int x, y;
	public Node(int x, int y){
		this.x = x;
		this.y = y;
	}
}
