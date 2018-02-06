import java.util.Scanner;

public class boj9095 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i = 0 ; i < T ; i++){
			System.out.println(add(sc.nextInt()));
		}
	}

	static int add(int n){
		
		int[] d = new int[n+1];
		
		if( n == 1 )	return 1;
		else if( n == 2 )	return 2;
		else if( n == 3 )	return 4;
		
		d[1] = 1;
		d[2] = 2;
		d[3] = 4;
		
		for(int i = 4 ; i <= n ; i++){
			d[i] = d[i-1]+d[i-2]+d[i-3];
		}
		
		return d[n];
	}
}
