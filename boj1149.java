import java.io.*;
import java.util.StringTokenizer;

public class boj1149 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] price = new int[3][N];
		int[][] dp = new int[3][N];
		
		for(int i = 0 ; i < N ; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 3 ; j++){
				price[j][i] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = price[0][0];
		dp[1][0] = price[1][0];
		dp[2][0] = price[2][0];
		
		for(int i = 1 ; i < N ; i++){
			dp[0][i] = Math.min(dp[1][i-1], dp[2][i-1]) + price[0][i];
			dp[1][i] = Math.min(dp[0][i-1], dp[2][i-1]) + price[1][i];
			dp[2][i] = Math.min(dp[0][i-1], dp[1][i-1]) + price[2][i];
		}
		
		System.out.println(min(dp[0][N-1],dp[1][N-1],dp[2][N-1]));
	}

	static int min(int a, int b, int c){
		if(a > b){
			if(b > c)	return c;
			else		return b;
		}else{
			if(a > c)	return c;
			else		return a;
		}
	}
}
