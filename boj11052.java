import java.util.Scanner;

public class boj11052 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] p = new int[N+1];
		int[] max = new int[N+1];
		int temp = 0;
		
		for(int i = 1 ; i <= N ; i++){
			p[i] = sc.nextInt();
		}
		
		max[0] = 0;
		max[1] = p[1];
		
		for(int i = 2 ; i <= N ; i++){
			for(int j = 0 ; j < i ; j++){
				temp = Math.max(p[i-j]+max[j], temp);
				max[i] = temp;
			}
		}
		
		System.out.println(max[N]);
	}

}
