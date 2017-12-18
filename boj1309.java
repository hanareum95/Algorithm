import java.util.Scanner;

public class boj1309 {
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int d[][] = new int[3][N+1];
		
		d[0][1] = d[1][1] = d[2][1] = 1;
		
		for(int i = 2 ; i < N+1 ; i++){
			d[0][i] = d[1][i-1] + d[2][i-1];
			d[1][i] = d[0][i-1] + d[2][i-1];
			d[2][i] = d[0][i-1] + d[1][i-1] + d[2][i-1];
		}
		
		System.out.println( (d[0][N] + d[1][N] + d[2][N])%9901 );
	
	}
}
