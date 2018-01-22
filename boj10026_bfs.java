import java.util.*;
import java.io.*;

public class boj10026 {

	static int N;
	static char[][] img;
	static boolean[][] visit;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		StringTokenizer st;
		
		int count_normal = 0;
		int count_abnormal = 0;
		
		N = Integer.parseInt(br.readLine());
		img = new char[N][N];
		visit = new boolean[N][N];
		
		for(int i = 0 ; i < N ; i++){
			st = new StringTokenizer(br.readLine());
			img[i] = st.nextToken().toCharArray();
			for(int j = 0 ; j < N ; j++){
				visit[i][j] = false;
			}
		}
		
		for(int i = 0 ; i < N ; i++){
			for(int j = 0 ; j < N ; j++){
				if(!visit[i][j]){
					bfs(i, j, img[i][j]);
					count_normal++;
				}
			}
		}
		
		for(int i = 0 ; i < N ; i++){
			for(int j = 0 ; j < N ; j++){
				visit[i][j] = false;
				if(img[i][j] == 'G')	img[i][j] = 'R';
			}
		}
		
		for(int i = 0 ; i < N ; i++){
			for(int j = 0 ; j < N ; j++){
				if(!visit[i][j]){
					bfs(i, j, img[i][j]);
					count_abnormal++;
				}
			}
		}
		System.out.println(count_normal+" "+count_abnormal);
		
	}

	static void bfs(int x, int y, char color){
		Queue<Node> q = new LinkedList<Node>();
		
		q.add(new Node(x, y));
		visit[x][y] = true;
			
		while(!q.isEmpty()){
			int tempX = q.peek().x;
			int tempY = q.poll().y;
			
			for(int i = 0 ; i < 4 ; i++){
				int moveX = tempX + dx[i];
				int moveY = tempY + dy[i];
				
				if(0 <= moveX && moveX < N && 0 <= moveY && moveY < N){
					if(!visit[moveX][moveY] && img[moveX][moveY] == color){
						q.add(new Node(moveX, moveY));
						visit[moveX][moveY] = true;
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
