import java.io.*;
import java.util.*;

public class boj11403 {

	static int N;
	static int[][] graph;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);

		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for( int i = 0 ; i < N ; i++){
			for(int j = 0 ; j < N ; j++){
				for(int k = 0 ; k < N ; k++){
					if(graph[i][k]==1 && graph[j][i]==1){
						graph[j][k] = 1;
					}
				}
			}
		}
		

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println("");
		}
	}

}