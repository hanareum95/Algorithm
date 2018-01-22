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
					dfs(i, j, img[i][j]);
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
					dfs(i, j, img[i][j]);
					count_abnormal++;
				}
			}
		}
		System.out.println(count_normal+" "+count_abnormal);
		
	}

	static void dfs(int x, int y, char color){
		
		visit[x][y] = true;
		
		for(int i = 0 ; i < 4 ; i++){
			int tempX = x+dx[i];
			int tempY = y+dy[i];
			
			if(tempX < 0 || tempX >= N || tempY < 0 || tempY >= N) continue;
			if(!visit[tempX][tempY] && img[tempX][tempY] == color) dfs(tempX, tempY, color);
		}
	}
}
