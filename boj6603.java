import java.util.*;

public class boj6603 {

	static int n;
	static int[] lotto;
	static int count;
	static StringBuffer sb;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		while( (n =  sc.nextInt()) != 0 ){
			sb = new StringBuffer();
			lotto = new int[n];
			
			for(int i = 0 ; i < n ; i++){
				lotto[i] = sc.nextInt();
			}			
			
			for(int i = 0 ; i < n ; i++){
				
				count = 1;
				backtracking(i, lotto[i]+" ");
			}
			sb.append("\n");
			System.out.print(sb.toString());
		}
	}
	
	public static void backtracking(int i, String str){
		if(count == 6){
			sb.append(str+"\n");
		}else{
			for(int j = i+1 ; j < n ; j++){
				++count;
				backtracking(j, str+lotto[j]+" ");
			}
		}
		--count;
	}
}
